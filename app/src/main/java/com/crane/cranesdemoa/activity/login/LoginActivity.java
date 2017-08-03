package com.crane.cranesdemoa.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crane.cranesdemoa.R;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    //临时设置的几个用户数据，充当程序登陆
    private Map<String,String> users = new HashMap<String,String>();

    private EditText userIdView;
    private EditText passwordView;

    private TextView toolbar;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        userIdView = (EditText)findViewById(R.id.userId);
        passwordView = (EditText) findViewById(R.id.password);
        toolbar = (TextView) findViewById(R.id.headTitle);
        loginBtn = (Button) findViewById(R.id.loginBtn);

        toolbar.setText("山东青年政治学院咻咻通");
        findViewById(R.id.headLeftImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setUSERDatas();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void setUSERDatas() {
        users.put("123456","123456");   //key为用户名，value为登陆密码
        users.put("abcdefg","abcdefg");
        users.put("666666","666666");
    }

    private void login() {
        Log.d("login", "进入loginBtn");
        if (userIdView.getText() == null || userIdView.getText().toString().length() == 0) {
            Toast.makeText(this,"请输入用户名", Toast.LENGTH_LONG).show();
            return;
        }
        if (passwordView.getText() == null || passwordView.getText().toString().length() == 0) {
            Toast.makeText(this,"请输入密码", Toast.LENGTH_LONG).show();
            return;
        }
        String userId = userIdView.getText().toString();
        String password = passwordView.getText().toString();
        if (users.containsKey(userId)) {
            if (users.get(userId).equals(password)) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "密码错误", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "用户不存在", Toast.LENGTH_LONG).show();
        }
    }
}

