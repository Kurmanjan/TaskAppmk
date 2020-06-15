package com.geektech.taskapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;


public class IntroActivity extends AppCompatActivity {
    ViewPager viewPager;
    Button skip, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        viewPager=findViewById(R.id.viewPager);
        skip=findViewById(R.id.skip);
        next=findViewById(R.id.next);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()<2){
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1, true);
            }else { startActivity(new Intent(IntroActivity.this, MainActivity.class) );}
            }

        });

        viewPager.setAdapter(new Pager(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        skip.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        next.setText("next");

                        Toast.makeText(IntroActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        skip.setVisibility(View.VISIBLE);
                        next.setVisibility(View.VISIBLE);
                        next.setText("next");
                        Toast.makeText(IntroActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        skip.setVisibility(View.GONE);
                        next.setText("Start");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

}
class Pager extends FragmentPagerAdapter {


    public Pager(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        IntroFragment fragment = new IntroFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}

