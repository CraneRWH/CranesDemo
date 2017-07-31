package com.crane.cranesdemoa.activity.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crane.cranesdemoa.R;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    //临时设置的几个用户数据，充当程序登陆
    private Map<String,String> users = new HashMap<String,String>();

    private EditText userIdView;
    private EditText passwordView;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        userIdView = (EditText)findViewById(R.id.userId);
        passwordView = (EditText) findViewById(R.id.password);
        toolbar = (Toolbar) findViewById(R.id.toolBar);

        toolbar.setTitle("山东青年政治学院咻咻通");
        toolbar.setLogo(R.mipmap.arrow_left_white_icon);
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setUSERDatas() {
        users.put("123456","123456");   //key为用户名，value为登陆密码
        users.put("abcdefg","abcdefg");
        users.put("666666","666666");
    }
}

