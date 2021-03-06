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

public class XinXIBuActivity extends AppCompatActivity {

    private TextView titleView;

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xin_xibu);
        titleView = (TextView) findViewById(R.id.headTitle);
        titleView.setText("信息部");

        findViewById(R.id.headLeftImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        listView = (ListView) findViewById(R.id.listView);

        SimpleAdapter adapter = new SimpleAdapter(this,getDatas(),R.layout.xinxibu_list_item,
                new String[]{"zhiwei","name","phone","qq"},
                new int[]{R.id.zhiwei,R.id.name,R.id.phone,R.id.qq});
        listView.setAdapter(adapter);
    }

    private List<Map<String, String>> getDatas() {
        List<Map<String,String>> datas = new ArrayList<Map<String, String>>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("zhiwei","部长");
        map.put("name", "李云龙");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","副部长");
        map.put("name", "张三");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","副部长");
        map.put("name", "李四");
        map.put("phone","152453400000");
        map.put("qq","435434");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","副部长");
        map.put("name", "王五");
        map.put("phone","151321231231");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "赵六");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "刘起");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "乾隆");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "康熙");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "雍正");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "嘉庆");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "刀光");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "道光");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "文章");
        map.put("phone","15200000000");
        map.put("qq","11111111");
        datas.add(map);

        map = new HashMap<String,String>();
        map.put("zhiwei","干事");
        map.put("name", "孙云龙");
        map.put("phone","152234123213");
        map.put("qq","1123213121");
        datas.add(map);

        return datas;
    }
}
