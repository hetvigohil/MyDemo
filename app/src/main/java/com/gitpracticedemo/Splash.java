package com.gitpracticedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity implements Animation.AnimationListener
{

    ImageView btnStart;
    // Animation
    Animation animSequential, zoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnStart = (ImageView) findViewById(R.id.bdaybtn);

        //my animation

        // load the animation
        animSequential = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.up_from_bottom);

        // set animation listener
        animSequential.setAnimationListener(this);

        btnStart.startAnimation(animSequential);

        btnStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Intent i=new Intent(Splash.this,Login.class);
                //startActivity(i);
            }
        });
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }

        };
        timer.start();
    }

    @Override
    public void onAnimationStart(Animation animation)
    {

    }

    @Override
    public void onAnimationEnd(Animation animation)
    {
        // Take any action after completing the animation

        // check for zoom in animation
        if (animation == animSequential)
        {
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation)
    {

    }
    @Override
    protected void onPause()
    {
        //TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}

