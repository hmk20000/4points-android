package com.example.seogiwon.four_points;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button navigationBT, searchBT;

    // 뒤로 버튼 두 번 눌러서 종료되도록
    private BackPressCloseHandler backPressCloseHandler;
    boolean bLog = false; // false : 로그아웃 상태
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(""); // 포커스 문제 때문에 activity title 없애기
        setContentView(R.layout.activity_main);

        // 뒤로 버튼 두 번 눌러 종료되도록
        backPressCloseHandler = new BackPressCloseHandler(this);

        //navigationBT = (Button)findViewById(R.id.mainNavigationBT);
    //로딩화면 3초후에 메인화면으로 자동 넘어가기.
        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000); // 3초 후에 hd Handler 실행
    }

    private class splashhandler implements Runnable{
        public void run() {
            startActivity(new Intent(getApplication(), MainShowFourPointsActivity.class)); // 로딩이 끝난후 이동할 Activity
            MainActivity.this.finish(); // 로딩페이지 Activity Stack에서 제거
        }




    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
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
