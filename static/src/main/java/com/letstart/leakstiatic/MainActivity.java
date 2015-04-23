package com.letstart.leakstiatic;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends Activity {

    static SampleTask sampleTask;
    static InnerDrama innerDrama;
    private static Drawable sBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // innerDrama = new InnerDrama();

       /* TextView label = new TextView(this);
        label.setText("Leaks are bad");

        if (sBackground == null) {
            sBackground = getResources().getDrawable( R.drawable._leo);
        }
        label.setBackgroundDrawable(sBackground);

        setContentView(label);*/


        sampleTask = new SampleTask();
        sampleTask.execute();
    }

    private static class SampleTask extends AsyncTask<Void, Void, Void> {

        private long mStartTime;

        @Override
        protected void onPreExecute() {
            mStartTime = System.currentTimeMillis();
        }

        @Override
        protected Void doInBackground(Void... params) {
            doBackgroundWork();
            return null;
        }

        private void doBackgroundWork() {
            long timeNow;
            do {
                timeNow = System.currentTimeMillis();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (timeNow - mStartTime < (1 * 60 * 1000));
        }

    }

    public class InnerDrama{
        public InnerDrama(){

          /*  ImageView iv = (ImageView)  findViewById(R.id.imageView);
            iv.setImageResource(R.drawable._leo);*/
            ArrayList<Integer> ar = new ArrayList<>();
            for (int i=0;i<65000;i++)
            {
                Integer in = new Random().nextInt();
                ar.add( in );
            }
            Log.i(getClass().getSimpleName(),"ne ho creato uno!" );

        }
    }
}
