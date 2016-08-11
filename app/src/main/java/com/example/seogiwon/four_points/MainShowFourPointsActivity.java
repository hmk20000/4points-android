package com.example.seogiwon.four_points;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainShowFourPointsActivity extends AppCompatActivity {
    /* API 접속을 위한 구분 키워드 */
    boolean bLog = false;

    // 탭바 설정
    ViewPager pager;
    TabLayout tabs;
    Toolbar toolbar;




    // 뒤로 버튼 두 번 눌러서 종료되도록
    //브랜치 추가


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

        // 페이지 탭바 안보이게 하기.
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
// 툴바 안보이게 하기
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // 메뉴버튼이 처음 눌러졌을 때 실행되는 콜백메서드
        // 메뉴버튼을 눌렀을 때 보여줄 menu 에 대해서 정의
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d("test", "onCreateOptionsMenu - 최초 메뉴키를 눌렀을 때 호출됨");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("test", "onPrepareOptionsMenu - 옵션메뉴가 " +
                "화면에 보여질때 마다 호출됨");
        if(bLog){ // 로그인 한 상태: 로그인은 안보이게, 로그아웃은 보이게
            menu.getItem(0).setEnabled(true);
            menu.getItem(1).setEnabled(false);
        }else{ // 로그 아웃 한 상태 : 로그인 보이게, 로그아웃은 안보이게
            menu.getItem(0).setEnabled(false);
            menu.getItem(1).setEnabled(true);
        }

        bLog = !bLog;   // 값을 반대로 바꿈

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 메뉴의 항목을 선택(클릭)했을 때 호출되는 콜백메서드
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Log.d("test", "onOptionsItemSelected - 메뉴항목을 클릭했을 때 호출됨");

        int id = item.getItemId();


        switch(id) {
            case R.id.menu_letter_size:
                Toast.makeText(getApplicationContext(), "글자크기 메뉴 클릭",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_language:
                Toast.makeText(getApplicationContext(), "언어설정 메뉴 클릭",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_mode:
                Toast.makeText(getApplicationContext(), "숙련?",
                        Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_record:
                Toast.makeText(getApplicationContext(), "기록보기",
                        Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
