package com.pallefire.b_34dynamicbrdcstserviceexam1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
   private Button button;
   private TextView textView;

    //1.create a dynamic broadcast reciever

    public class MyReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText("done yaar");

        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1= (EditText) findViewById(R.id.et1);
        button= (Button) findViewById(R.id.bt1);
        textView= (TextView) findViewById(R.id.tv1);
        //2.link above broad cast reciever--with some intent filter
        MyReciever myReciever=new MyReciever();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("work done");
        registerReceiver(myReciever,intentFilter);
        //2.code over here the actuon work done--will service will use for wake up the reciever
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=et1.getText().toString();
                Intent intent=new Intent(MainActivity.this,MyService.class);
                intent.putExtra("name",name);
                startService(intent);
            }
        });
    }
}
