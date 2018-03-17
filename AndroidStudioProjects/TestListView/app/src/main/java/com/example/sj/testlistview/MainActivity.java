package com.example.sj.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;

public class MainActivity extends AppCompatActivity {
        ListView mListView;
        ArrayList<bean> mString;
    CheckAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mString =new ArrayList<>();
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            adapter.update(position);
                Log.i("ssj",String.valueOf(position)); Log.i("ssj","dsfa");
            }
        });

        for(int i=0;i<50;i++){
           bean b=new bean();
            b.setTitle(i+"");
            mString.add(b);
        }
         adapter=new CheckAdapter(mString,this);
        mListView.setAdapter(adapter);

    }
}
