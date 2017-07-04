package com.caoyang.news.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.caoyang.news.R;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView) findViewById(R.id.text);
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        textView.setText(data);
    }
}
