package com.example.babyyang.test2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.*;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button) this.findViewById(R.id.button);
        final EditText et1 = (EditText) findViewById(R.id.editText);

        bn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String In1 = et1.getText().toString();

                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("UserId", In1);
                startActivityForResult(intent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==0 && resultCode==0){
            String str = data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
    }
}