package com.example.gy.send;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private List<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ListView lv=(ListView)findViewById(R.id.lv);
         list=new ArrayList<Person>();
        for(int i=0;i<20;i++){
            Person p=new Person();
            p.setName("栾雪"+i);
            p.setPhone("111"+i);
            list.add(p);

        }
        lv.setAdapter(new Myadapter());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String phone=list.get(position).getPhone();
                Intent intent=new Intent();
                intent.putExtra("phone",phone);
                setResult(10,intent);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

    private class Myadapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
          if (convertView==null){
              view=View.inflate(getApplicationContext(),R.layout.contact_item,null);


          }else{
              view=convertView;

          }
        TextView name= (TextView)view.findViewById(R.id.tv_name);
          TextView phone=(TextView)view.findViewById(R.id.tv_phone);
          name.setText(list.get(position).getName());
          phone.setText(list.get(position).getPhone());
            return view;
        }

    }
}
