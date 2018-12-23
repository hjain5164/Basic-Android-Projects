package com.example.harshjain.musicearn;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoView = (VideoView)findViewById(R.id.videoplayer);
        Intent intent = getIntent();
        String path = intent.getStringExtra("videopath");
        videoView.setVideoURI(Uri.parse(path));
        videoView.setMediaController(new MediaController(VideoPlayer.this));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(VideoPlayer.this,Video.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.stopPlayback();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.stopPlayback();
    }
}
