package com.example.gy.send;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private EditText et_number;
   private EditText et_content;
   private Button button2;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode==10){String phone=data.getStringExtra("phone");
            et_number.setText(phone);
        }else if (resultCode==20){
            String smsmcontent=data.getStringExtra("smscontent");
            et_content.setText(smsmcontent);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       et_number=(EditText)findViewById(R.id.et_number);
       et_content=(EditText)findViewById(R.id.et_content);
button2=(Button)findViewById(R.id.button2);

        Button button1=(Button)findViewById(R.id.button1);
        Button send=(Button)findViewById(R.id.send);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SmsTemplate.class);
                startActivityForResult(intent,2);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContactActivity.class);
              startActivityForResult(intent,1);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String number=et_number.getText().toString().trim();
              String content=et_content.getText().toString().trim();
                SmsManager smsManager=SmsManager.getDefault();
                ArrayList<String> divideMessage=smsManager.divideMessage(content);
                for (String div:divideMessage){
                    smsManager.sendTextMessage(number,null,div,null,null);
                }


            }
        });
    }
}
