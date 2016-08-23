package com.example.seogiwon.four_points;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by seogiwon on 2016. 8. 22..
 */
public class AllPageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allpage);
        // 1. 다량의 데이터
        // 2. Adapter
        // 3. AdapterView - GridView

        int img[] = {
                R.drawable.initial, R.drawable.firstout, R.drawable.firstin,R.drawable.secondout, R.drawable.secondin, R.drawable.thirdout,
                R.drawable.thirdin, R.drawable.fourthout, R.drawable.fourthin, R.drawable.fifthout, R.drawable.fifthin, R.drawable.last, R.drawable.final1 //기존 final이란 거가 있어서 이름에 1붙임
        };

        // 커스텀 아답타 생성
        MyAdapter adapter = new MyAdapter(
                getApplicationContext(),
              R.layout.row,
               img);

        GridView gv = (GridView) findViewById(R.id.gridView1);
      gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용


        final TextView tv = (TextView) findViewById(R.id.textView1);

        // GridView 아이템을 클릭하면 상단 텍스트뷰에 position 출력
        // JAVA8 에 등장한 lambda expression 으로 구현했습니다. 코드가 많이 간결해지네요
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getApplication(), MainShowFourPointsActivity.class);
                intent.putExtra("pageNum",position);
                startActivity(intent);

               // tv.setText("position : " + position);
            }
        });
    } // end of onCreate


    class MyAdapter extends BaseAdapter {
        Context context;
        int layout;
        int img[];
        LayoutInflater inf;

        public MyAdapter(Context context, int layout, int[] img) {
            this.context = context;
            this.layout = layout;
            this.img = img;
            inf = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = inf.inflate(layout, null);

            ImageView iv = (ImageView) convertView.findViewById(R.id.imageView1);
            iv.setImageResource(img[position]);

            return convertView;
        }
    }
}
// end of class