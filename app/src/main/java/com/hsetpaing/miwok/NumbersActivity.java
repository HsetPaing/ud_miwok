package com.hsetpaing.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    /**
     * Handles playback of all the sound files
     **/
    private MediaPlayer mediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Puase playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // resume playback
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stoped, release the media player resources because we won't be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * This listener gets triggere when the {@link MediaPlayer} has completed playing the audio file
     **/
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new NumbersFragment()).commit();

//        // Create and setup the {@link AudioManager} to request audio focus
//        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//        //create an array of words
//        final ArrayList<Word> words = new ArrayList<Word>();
//
//        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
//        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
//        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
//        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
//        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
//        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
//        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
//        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
//        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
//        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
//
//        //Find the root view of the whole layout
////        LinearLayout rootView = (LinearLayout)findViewById(R.id.list);
////
////        for (int index = 0; index < words.size(); index++){
////            TextView wordView = new TextView(this);
////            wordView.setText(words.get(index));
////            list.addView(wordView);
////        }
//
//        WordAdapter itemsAdapter = new WordAdapter(this, words, R.color.category_numbers);
//
//        ListView listView = (ListView) findViewById(R.id.list);
//
//        listView.setAdapter(itemsAdapter);
//
//        /** Set a click listener to play the audio when the list item is clicked on **/
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                /** Get the {@link Word} object at the given postion the user click on**/
//                Word word = words.get(position);
//
//                Log.v("NumbersActivity", "Current word: " + word.toString());
//
//                //Release the media player if it currently exists because we are about to
//                //play a different sound file
//                releaseMediaPlayer();
//
//                // Request audio focus for playback
//                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
//                        // Use the music stream.
//                        AudioManager.STREAM_MUSIC,
//                        // Request permanent focus.
//                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    // Start playback
//
//
//                    //create and setup the {@link mediaplay} for the audio resource associated with the current word
//                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
//
//                    //start the audio file
//                    mediaPlayer.start(); // no need to call prepare(); create() does that for you
//
//                    /**
//                     * Setup a listener on the player, so that we can stop and release
//                     * the media player once the sounds has finished playing.
//                     */
//                    mediaPlayer.setOnCompletionListener(mCompletionListener);
//                }
//            }
//        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            //Regradless of whether or not we were granted audio focus, abandon it. This also
            //unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
