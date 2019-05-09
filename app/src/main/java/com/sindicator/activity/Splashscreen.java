package com.sindicator.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.sindicator.R;

public class Splashscreen extends AppCompatActivity {

    Thread thread;
    ImageView img;
    protected Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        img= (ImageView) findViewById(R.id.imagv);
        animation= AnimationUtils.loadAnimation(this, R.anim.animation);
        img.setScaleType(ImageView.ScaleType.FIT_XY);

        thread=new Thread()
        {
            public void run()
            {
                try
                {
                    int wait=0;
                    while (wait<5000)
                    {
                        sleep(100);
                        wait+=100;
                    }

                    Intent i=new Intent(Splashscreen.this,AppIntro.class);
                    i.setFlags(i.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(i);
                    Splashscreen.this.finish();
                }

                catch (InterruptedException e)
                {

                }

                finally {

                }
            }
        };

        thread.start();
    }

}

