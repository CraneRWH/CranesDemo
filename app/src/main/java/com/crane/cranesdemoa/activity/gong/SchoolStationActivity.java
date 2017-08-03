package com.crane.cranesdemoa.activity.gong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.crane.cranesdemoa.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolStationActivity extends AppCompatActivity {

    private TextView titleView;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_station);
        titleView = (TextView) findViewById(R.id.headTitle);
        titleView.setText("校内维修点");

        findViewById(R.id.headLeftImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(this,getDatas(),R.layout.schoole_station_list_item,
                new String[]{"station","name","phone","qq"},
                new int[]{R.id.station,R.id.name,R.id.phone,R.id.qq});
        listView.setAdapter(adapter);
    }

    private List<Map<String, String>> getDatas() {
        List<Map<String,String>> datas = new ArrayList<Map<String, String>>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("station","山青第一店");
        map.put("name", "李云龙");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第2店");
        map.put("name", "张三");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第3店");
        map.put("name", "李四");
        map.put("phone","152453400000");
        map.put("qq","435434");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第4店");
        map.put("name", "王五");
        map.put("phone","151321231231");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第5店");
        map.put("name", "赵六");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第6店");
        map.put("name", "刘起");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第7店");
        map.put("name", "乾隆");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第8店");
        map.put("name", "康熙");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第9店");
        map.put("name", "雍正");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第10店");
        map.put("name", "嘉庆");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第11店");
        map.put("name", "刀光");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第12店");
        map.put("name", "道光");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第13店");
        map.put("name", "文章");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("station","山青第14店");
        map.put("name", "孙云龙");
        map.put("phone","152234123213");
        map.put("qq","1123213121");
        datas.add(map);

        return datas;
    }
}
