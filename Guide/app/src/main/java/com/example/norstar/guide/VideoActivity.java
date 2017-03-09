package com.example.norstar.guide;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;

public class VideoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_video);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.vlist,
                new String[]{
                        "title","img"
                },
                new int[]{
                        R.id.title2,R.id.imgBtn
                });
        setListAdapter(adapter);

    }

    private List<Map<String,Object>>getData(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("title","G1");
        map.put("img",R.drawable.pc1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title","G2");
        map.put("img",R.drawable.pc2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title","G3");
        map.put("img",R.drawable.pc3);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title","G4");
        map.put("img",R.drawable.pc4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title","G5");
        map.put("img",R.drawable.pc5);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("title","G6");
        map.put("img",R.drawable.pc6);
        list.add(map);

        return list;

    }
}
