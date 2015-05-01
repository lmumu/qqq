package com.lkw.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ImageView login_head_iv;
    private RadioGroup login_rg;
    private EditText login_username;
    private EditText login_yanzhenma;
    private Button login_rg_btn;
    private TextView login_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_head_iv = (ImageView) findViewById(R.id.login_head_iv);
        login_head_iv.setOnClickListener(this);

        login_rg = (RadioGroup) findViewById(R.id.login_rg);
        login_rg.setOnCheckedChangeListener(this);

        login_username = (EditText) findViewById(R.id.login_username);
        login_yanzhenma = (EditText) findViewById(R.id.login_yanzhenma);
        login_rg_btn = (Button) findViewById(R.id.login_rg_btn);
        login_register = (TextView) findViewById(R.id.login_register);
        login_register.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.login_head_iv:
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setClass(LoginActivity.this, MainActivity.class);
//                startActivity(intent);
                finish();
                break;
            case R.id.login_register:
               intent.setClass(LoginActivity.this,RegiserActivity.class);
                break;

        }
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i==R.id.login_rb1){
            login_username.setHint("请输入手机号，未注册将自动创建");
            login_yanzhenma.setHint("请输入验证码");
            login_rg_btn.setVisibility(View.VISIBLE);
        }else   if (i==R.id.login_rb2){
            login_username.setHint("请输入您的手机号/邮箱");
            login_yanzhenma.setHint("请输入密码");
            login_rg_btn.setVisibility(View.INVISIBLE);
        }
    }
}