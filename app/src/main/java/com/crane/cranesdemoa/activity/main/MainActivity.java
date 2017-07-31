package com.crane.cranesdemoa.activity.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.crane.cranesdemoa.R;
import com.crane.cranesdemoa.fragment.home.MainHomeFragment;
import com.crane.cranesdemoa.fragment.myCenter.MainMyCenterFragment;
import com.crane.cranesdemoa.fragment.xiu.MainXiuFragment;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    private Map<Integer,Fragment> mainFragments = new HashMap<Integer,Fragment>();
    private MainHomeFragment homePageFragment;
    private MainXiuFragment xiuFragment;
    private MainMyCenterFragment myCenterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        chooseMainItem(0);
                        break;
                    case R.id.navigation_dashboard:
                        chooseMainItem(1);
                        break;
                    case R.id.navigation_notifications:
                        chooseMainItem(2);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        chooseMainItem(0);
    }

    private void chooseMainItem(int tag) {
        FragmentManager fragmengManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmengManager.beginTransaction();
        try {
            if (!mainFragments.containsKey(tag)) {
                if (tag == 0) {
                    homePageFragment = new MainHomeFragment();		//主页选项卡
                    fragmentTransaction.add(R.id.fragmentLayout, homePageFragment, "home");
                    mainFragments.put(0,homePageFragment);
                }
                else if (tag == 1) {
                    xiuFragment = new MainXiuFragment();		//门店选项卡
                    fragmentTransaction.add(R.id.fragmentLayout, xiuFragment, "xiu");
                    mainFragments.put(1,xiuFragment);
                }
                else if (tag == 2) {
                    myCenterFragment = new MainMyCenterFragment();		//“我的”选项卡

                    fragmentTransaction.add(R.id.fragmentLayout, myCenterFragment, "myCenter");
                    mainFragments.put(2,myCenterFragment);
                }
            }
            for(int key : mainFragments.keySet()) {
                if (key == tag) {
                    fragmentTransaction.show(mainFragments.get(key));

                }
                else {
                    fragmentTransaction.hide(mainFragments.get(key));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            fragmentTransaction.commit();
        }
    }
}
