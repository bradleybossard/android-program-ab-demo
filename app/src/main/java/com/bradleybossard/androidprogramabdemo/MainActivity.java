package com.bradleybossard.androidprogramabdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

//import android.R.string;
//import android.provider.Settings.System;
//import android.util.Log;


/*
Hello.  I was curious, has there been any progress on this, i.e. getting Program AB to run on Android.

I was kind of looking over this thread and another related one here

https://www.chatbots.org/ai_zone/viewthread/1778/

I have created a new Android Studio project and copied over the AB.jar library from the Project AB, but I realize now when diving a little deeper, that when you pass a path to Bot constructor, like so

String path = "/bots";
Bot bot = new Bot(botname, path);


http://stackoverflow.com/questions/26546204/aiml-file-does-not-exist-why-my-android-project-cannot-connect-to-aiml-files-in/26973015#26973015
*/


public class MainActivity extends Activity {

    String botname = "alice2";

    // TODO(bossard) : Ok, so when you create a bot, it needs a file structure like this
    //
    //  Directory	Contents
/*
    c:/example/bots/mybot/aiml	AIML Files
    c:/example/bots/mybot/aimlif	AIMLIF format files
    c:/example/bots/mybot/config	Bot configuration Files
    c:/example/bots/mybot/sets	AIML Sets
    c:/example/bots/mybot/maps	AIML Maps
*/
  //
    // TODO(bbossard) : Possible solution to overcoming the file problem path, only sync .zip file, then unzip it locally and use the files.
    //http://stackoverflow.com/questions/26546204/aiml-file-does-not-exist-why-my-android-project-cannot-connect-to-aiml-files-in/26973015#26973015

    String path = "D:/university courses/A.terms/Final project/program-ab-0.0.6.26/bots";
    Bot bot = new Bot(botname, path);

    Chat chatSession = new Chat(bot);
    String request = "Hello. Are you alive? What is your name?";
    String response = chatSession.multisentenceRespond(request);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = new TextView(this);
        t = (TextView) findViewById(R.id.title_text);
        t.setText(response);
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
