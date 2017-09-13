package com.example.babyyang.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstateState){
        super.onCreate(savedInstateState);
        setContentView(R.layout.second_layout);
        processExtraData();

        Button bn = (Button)findViewById(R.id.buttonexit);

        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = getIntent();
                String name = intent.getStringExtra("UserId");
                intent.putExtra("result","退出成功，期待:" + name + "下次登录");
                setResult(0,intent);
                finish();
            }
        });

    }
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        processExtraData();
    }
    private void processExtraData(){
        Intent intent = getIntent();
        String name = intent.getStringExtra("UserId");
        Toast.makeText(this,"用户  "+ name +"  上线了",Toast.LENGTH_LONG).show();
    }

}
