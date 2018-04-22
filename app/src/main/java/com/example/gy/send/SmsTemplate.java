package com.example.gy.send;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class SmsTemplate extends AppCompatActivity {
private ListView lv;
private String object[]={"我在吃饭稍后联系","我在学习请勿打扰","我在上课","我在开会"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_template);
        lv=(ListView)findViewById(R.id.lv);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,object);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String smscontent=object[position];
                Intent intent=new Intent();
                intent.putExtra("smscontent",smscontent);
                setResult(20,intent);
                finish();
            }
        });

    }
}
