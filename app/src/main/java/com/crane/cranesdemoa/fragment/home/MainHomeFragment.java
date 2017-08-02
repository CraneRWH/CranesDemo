package com.crane.cranesdemoa.fragment.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.crane.cranesdemoa.R;
import com.crane.cranesdemoa.myView.MListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainHomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private TextView toolBar;
    private ViewPager viewPager;

    private MListView listView;

    private List<Map<String,String>> datas = new ArrayList<Map<String,String>>();

    public MainHomeFragment() {
        // Required empty public constructor
    }

    public static MainHomeFragment newInstance(String param1, String param2) {
        MainHomeFragment fragment = new MainHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_home, container, false);
        toolBar = (TextView) view.findViewById(R.id.headTitle);
        toolBar.setText("山东青年政治学院咻咻通首页");
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        listView = (MListView) view.findViewById(R.id.listView);
        setDatas();
        SimpleAdapter adapter = new SimpleAdapter(getContext(), datas, R.layout.home_page_list_item,
                new String[]{"textView","finish"},
                new int[]{R.id.textView,R.id.finishText});
        listView.setAdapter(adapter);
        return view;
    }

    private void setDatas() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("textView","轮胎破了个大洞，需要换新的了");
        map.put("finish", "已完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","后照镜需要修理");
        map.put("finish", "未完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","车把有些不正");
        map.put("finish", "未完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","脚蹬子怎么好像不舒服");
        map.put("finish", "已完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","车座子有些问题");
        map.put("finish", "已完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","电动车电池破损严重");
        map.put("finish", "未完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","电动车电池破损严重");
        map.put("finish", "未完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","电动车电池破损严重");
        map.put("finish", "已完成");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("textView","电动车电池破损严重");
        map.put("finish", "未完成");
        datas.add(map);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
