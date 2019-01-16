package com.hsetpaing.miwok;

public class Word {

    private static final int NO_IMAGE_PROIDED = -1;

    /** **/
    private int mImageResourceId = NO_IMAGE_PROIDED;

    /**
     * Default tranlation for the word
     **/
    private String mDefaultTranslation;

    /**
     * Miwok tranlation for the word
     **/
    private String mMiwokTranslation;

    /** Audio resource ID for the word **/
    private int mAudioResourceId;

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId,int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROIDED;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mImageResourceId=" + mImageResourceId +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
