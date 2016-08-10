package com.example.seogiwon.four_points;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button navigationBT, searchBT;

    // 뒤로 버튼 두 번 눌러서 종료되도록
    private BackPressCloseHandler backPressCloseHandler;

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


}
