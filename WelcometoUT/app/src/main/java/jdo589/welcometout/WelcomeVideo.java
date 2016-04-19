package jdo589.welcometout;

import android.annotation.SuppressLint;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class WelcomeVideo extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausing = false;
    Button buttonPlayVideo;
    VideoView welcomeVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_video);

        Button buttonPlayVideo = (Button)findViewById(R.id.buttonPlayVideo);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        VideoView mVideoView = (VideoView)findViewById(R.id.welcomeVideo);
        String uriPath = "android.resource://jdo589.welcometout/"+R.raw.movie;
        Uri uri = Uri.parse(uriPath);

        buttonPlayVideo.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                // VideoView reference see main.xml
                VideoView mVideoView = (VideoView)findViewById(R.id.welcomeVideo);

                String uriPath = "android.resource://jdo589.welcometout/"+R.raw.movie;

                // Creates a Uri which parses the given encoded URI string
                Uri uri = Uri.parse(uriPath);

                // set the video URO
                mVideoView.setVideoURI(uri);
                // start the video
                mVideoView.requestFocus();
                mVideoView.start();


            }});
    }

}
