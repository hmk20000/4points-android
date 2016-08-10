package com.example.seogiwon.four_points;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainShowFourPointsActivity extends AppCompatActivity {
    /* API 접속을 위한 구분 키워드 */



    // 탭바 설정
    ViewPager pager;
    TabLayout tabs;



    // GPS 위도, 경도 값
   // double latitude, longitude;

    // 뒤로 버튼 두 번 눌러서 종료되도록


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(""); // 포커스 문제 때문에 activity title 없애기
        setContentView(R.layout.activity_showfourpoints);


        // 액션바 처리 부분
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);

 //           ActionBar actionBar = getSupportActionBar();
  //           actionBar.setDisplayShowTitleEnabled(false);

        // 뒤로 버튼 두 번 눌러 종료되도록
        Intent intent = getIntent();

        // 탭 처리 부분
        pager = (ViewPager) findViewById(R.id.pager);
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());



        InitialFragment initialFragment = new InitialFragment();
        adapter.addItem(initialFragment, "표지");

        //2
        FirstOutFragment firstOutFragment = new FirstOutFragment();
        adapter.addItem(firstOutFragment, "1-1");
        //        세 번째 탭 설정, 3
        FirstInFragment firstInFragment = new FirstInFragment();
        adapter.addItem(firstInFragment, "1-2");

        SecondOutFragment secondOutFragment = new SecondOutFragment();
        adapter.addItem(secondOutFragment, "2-1");

        SecondInFragment secondInFragment = new SecondInFragment();
        adapter.addItem(secondInFragment, "2-2");

        ThirdOutFragment thirdOutFragment = new ThirdOutFragment();
        adapter.addItem(thirdOutFragment,"3-1");

        ThirdInFragment thirdInFragment = new ThirdInFragment();
        adapter.addItem(thirdInFragment,"3-2");

        FourthOutFragment fourthOutFragment = new FourthOutFragment();
        adapter.addItem(fourthOutFragment, "4-1");

        FourthInFragment fourthInFragment = new FourthInFragment();
        adapter.addItem(fourthInFragment, "4-2");

        FifthOutFragment fifthOutFragment = new FifthOutFragment();
        adapter.addItem(fifthOutFragment,"5-1");

               FifthInFragment fifthInFragment = new FifthInFragment();
               adapter.addItem(fifthInFragment,"5-2");

        LastFragment lastFragment = new LastFragment();
        adapter.addItem(lastFragment,"표지");

        FinalFragment finalFragment = new FinalFragment();
       adapter.addItem(finalFragment, "마지막");
        //   전체적인 탭 설정
        pager.setAdapter(adapter);
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);

        // 페이지 툴바 안보이게 하기.
        tabs.setVisibility(TextView.GONE);

        tabs.getTabAt(0).setText("표지");
        tabs.getTabAt(1).setText("1-1");
        tabs.getTabAt(2).setText("1-2");
        tabs.getTabAt(3).setText("2-1");
        tabs.getTabAt(4).setText("2-2");
        tabs.getTabAt(5).setText("3-1");
        tabs.getTabAt(6).setText("3-2");
        tabs.getTabAt(7).setText("4-1");
        tabs.getTabAt(8).setText("4-2");
        tabs.getTabAt(9).setText("5-1");
        tabs.getTabAt(10).setText("5-2");
        tabs.getTabAt(11).setText("표지");
        tabs.getTabAt(12).setText("마지막");


    }


    /* 전체 탭바를 관리하는 페이저 설정 */

    class MainPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        ArrayList<String> titles = new ArrayList<String>();

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> items) {
            super(fm);
            this.items = items;
        }

        public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> items, ArrayList<String> titles) {
            super(fm);
            this.items = items;
            this.titles = titles;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        public void addItem(Fragment fragment, String title) {
            items.add(fragment);
            titles.add(title);

        }

        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }

    }

}
