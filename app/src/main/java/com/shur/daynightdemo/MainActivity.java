package com.shur.daynightdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Shur on 2016/11/29 .
 * Every doorway, every intersection has a story .
 * E-mail : 310421346@qq.com .
 * Android夜间模式和日间模式切换
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditText;
    private String[] tipsArray;
    private Button btnDay, btnNight, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btnNight = (Button) findViewById(R.id.btn_night);
        btnNight.setOnClickListener(this);
        btnDay = (Button) findViewById(R.id.btn_day);
        btnDay.setOnClickListener(this);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.et_main);
        mEditText.setHint(getRandomWelcomeTips());
    }

    /**
     * 获取随机hint提示
     * @return
     */
    private String getRandomWelcomeTips() {
        String tips = null;
        tipsArray = this.getResources().getStringArray(R.array.tips);
        int index = (int) (Math.random()*(tipsArray.length-1));
        tips = tipsArray[index];
        return tips;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                startActivity(new Intent(MainActivity.this,AboutActivity.class));
                break;
            case R.id.btn_day:
                //日间模式
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();
                break;
            case R.id.btn_night:
                //切换夜间模式
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                recreate();
                break;
        }
    }
}
