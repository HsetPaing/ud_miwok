package com.hsetpaing.miwok;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

//        /**
//         * Numbers Activity
//         */
//        //Find the View that shows the numbers category
//        TextView numbers = (TextView)findViewById(R.id.numbers);
//        //Set a clicklistener on that View
//        numbers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Create a new intent to open the {@link NumberActivity}
//                Intent numbersIntent = new Intent(MainActivity.this,NumbersActivity.class);
//                //start the new activity
//                startActivity(numbersIntent);
//            }
//        });
////        NumbersClickListener clickListener = new NumbersClickListener();
////        numbers.setOnClickListener(clickListener);
//
//        /**
//         * Family Activity
//         */
//        TextView family = (TextView)findViewById(R.id.family);
//        family.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent familyIntent = new Intent(MainActivity.this,FamilyActivity.class);
//                startActivity(familyIntent);
//            }
//        });
//
//        /**
//         * Colors Activity
//         */
//        TextView colors = (TextView)findViewById(R.id.colors);
//        colors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent colorsIntent = new Intent(MainActivity.this,ColorsActivity.class);
//                startActivity(colorsIntent);
//            }
//        });
//
//        /**
//         * Pharses Activity
//         */
//        TextView pharses = (TextView)findViewById(R.id.phrases);
//        pharses.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent pharsesIntent = new Intent(MainActivity.this,PhrasesActivity.class);
//                startActivity(pharsesIntent);
//            }
//        });
    }
}
