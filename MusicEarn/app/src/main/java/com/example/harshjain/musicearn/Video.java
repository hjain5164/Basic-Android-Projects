package com.example.harshjain.musicearn;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Video extends AppCompatActivity {
private List<VideoModel> list;
private ListView listView;
private CustomVideoAdapter customVideoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);        if(ContextCompat.checkSelfPermission(Video.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Video.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
        }
        listView = (ListView)findViewById(R.id.video_list);
        list = getAllAudioFromDevice(Video.this);
        customVideoAdapter = new CustomVideoAdapter(Video.this,R.layout.video_items,list);
        listView.setAdapter(customVideoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                VideoModel v = (VideoModel)adapterView.getItemAtPosition(i);

                Intent intent = new Intent(Video.this,VideoPlayer.class);
                intent.putExtra("videopath",v.getPath());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Video.this,MainActivity.class));
    }

    public List<VideoModel> getAllAudioFromDevice(final Context context) {

        final List<VideoModel> tempAudioList = new ArrayList<>();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Video.VideoColumns.DATA};
        Cursor c = context.getContentResolver().query(uri, projection, null,null, null);
        if (c != null) {
            while (c.moveToNext()) {
                VideoModel videoModel = new VideoModel();
                String path = c.getString(0);
//                String album = c.getString(1);
//                String artist = c.getString(2);
                String name = path.substring(path.lastIndexOf("/") + 1);
                videoModel.setName(name);
                videoModel.setPath(path);
                tempAudioList.add(videoModel);
            }c.close();
        }
        return tempAudioList;
    }

}
