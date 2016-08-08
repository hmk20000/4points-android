package com.example.seogiwon.four_points;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        navigationBT = (Button)findViewById(R.id.mainNavigationBT);

       navigationBT.setOnClickListener(mClickListener);




    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


                    intent = new Intent(getApplicationContext(), MainShowFourPointsActivity.class);
                    startActivity(intent);



        }
    };

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }


}
