package com.pallefire.b_34dynamicbrdcstserviceexam1;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle=intent.getExtras();
        String name=bundle.getString("name");
        Toast.makeText(MyService.this, "name is.."+name, Toast.LENGTH_SHORT).show();

        //3.trigger or start broad cast reciever--use intent and sendbroadcast
        Intent intent1=new Intent();

        //here the workcone is the action
        intent1.setAction("work done");
        sendBroadcast(intent1);
        //code over here


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
