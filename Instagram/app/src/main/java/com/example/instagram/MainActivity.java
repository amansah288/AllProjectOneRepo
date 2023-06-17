package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {

    ImageButton s_1;
    VideoView videoView,videoView_2,videoView_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(flag);
        setContentView(R.layout.activity_main);

        s_1 = findViewById(R.id.s_1);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);  //casting to VideoView is not Strictly required above API level 26
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videoclip); //set the path of the video that we need to use in our VideoView
        videoView.start();//start() method of the VideoView class will start the video to play

        VideoView videoView_2 = (VideoView) findViewById(R.id.videoView_2);  //casting to VideoView is not Strictly required above API level 26
        videoView_2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videoclip2); //set the path of the video that we need to use in our VideoView
        videoView.start();

        VideoView videoView_3 = (VideoView) findViewById(R.id.videoView_3);  //casting to VideoView is not Strictly required above API level 26
        videoView_2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.videoclip3); //set the path of the video that we need to use in our VideoView
        videoView.start();


    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

                    //You can also pass multiple flags as i did. one for hide navigation one for make layout stable
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                             View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);


                }
            }
        }
    }

}