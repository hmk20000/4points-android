package com.example.seogiwon.four_points;

import android.app.Activity;
import android.widget.Toast;


public class BackPressCloseHandler {

    /**
     * Created by SeungHee on 2016-01-29.
     * '뒤로' 버튼을 두 번 눌렀을 경우 앱이 종료되도록 한다.
     */


        private long backKeyPressedTime = 0;
        private Toast toast;

        private Activity activity;

        //private Fragment2 fragment2;

        public BackPressCloseHandler(Activity context) {
            this.activity = context;
        }

        public void onBackPressed() {
            if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                showGuide();
                return;
            }
            if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
                activity.finish();
                toast.cancel();
            }
        }

        public void showGuide() {
            toast = Toast.makeText(activity,
                    "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

