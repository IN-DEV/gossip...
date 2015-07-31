package com.example.loic.gissippool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import com.example.loic.gissippool.R;


public class MainActivity extends Activity {

    private Button btnsuivant;
    private ListView list;
    private String [] titre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            RumeurAdapter adapter = new RumeurAdapter(MainActivity.this, titre);
            ListView listView = (ListView) findViewById(R.id.list_item);
            listView.setAdapter(adapter);

        }
    }
        protected void onStart(){
         super.onStart();
    }
           protected void onStop() {
               super.onStop();

           }

         protected void onPause(){
             super.onPause();
         }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){

            case R.id.action_search:
                return true;
            case R.id.action_ajout:
                Intent intent = new Intent(MainActivity.this,Rumeur.class);
                startActivity(intent);
                return true;

        //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
