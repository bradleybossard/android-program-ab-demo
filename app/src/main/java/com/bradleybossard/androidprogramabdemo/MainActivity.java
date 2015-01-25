package com.bradleybossard.androidprogramabdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

import java.io.File;

public class MainActivity extends Activity {
    
    private static final String TAG = "MainActivity";
    
    String botname = "alice2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File fileExt = new File(getExternalFilesDir(null).getAbsolutePath() + "/bots");
        if (!fileExt.exists()) {
            ZipFileExtraction extract = new ZipFileExtraction();

            try {
                extract.unZipIt(getAssets().open("bots.zip"), getExternalFilesDir(null).getAbsolutePath() + "/");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                final String path = getExternalFilesDir(null).getAbsolutePath();

                Bot bot = new Bot(botname, path);
                Chat chatSession = new Chat(bot);
                String request = "Hello. Are you alive? What is your name?";
                //String request = "What is your name?";
                String response = chatSession.multisentenceRespond(request);

                Log.v(TAG, "response = " + response);
                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                if (response.isEmpty()) {
                    response = "There is no response";
                }
                ((TextView) findViewById(R.id.title_text))
                        .setText(response);

            }
        }.execute();
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/

/*
    public class MainActivity extends Activity
    {
        String botname = "alice2";
        String path = "D:/university courses/A.terms/Final project/program-ab-0.0.6.26/bots";
        Bot bot = new Bot(botname, path);


        Chat chatSession = new Chat(bot);
        String request = "Hello. Are you alive? What is your name?";
        String response = chatSession.multisentenceRespond(request);

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            TextView t = new TextView(this);
            t = (TextView) findViewById(R.id.text);
            t.setText(response);

        }
    }
*/


/*
        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
// Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
*/


    }
