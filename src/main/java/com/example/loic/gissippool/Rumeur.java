package com.example.loic.gissippool;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by LOIC on 09/07/2015.
 */
public class Rumeur extends Activity {

    private EditText suj;
    private EditText choise;
    private EditText contien;
    private Button btne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interrumeur);

        choise =(EditText)findViewById(R.id.cible);
        suj =(EditText)findViewById(R.id.sujet);
        contien =(EditText)findViewById(R.id.contenu);
        btne =(Button)findViewById(R.id.sendrumeur);

        btne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choix = choise.getText().toString();
                String sujets = suj.getText().toString();
              Toast msg =   Toast.makeText(Rumeur.this ,"New",Toast.LENGTH_LONG);
                msg.show();
            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rumeur, menu);
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


            //noinspection SimplifiableIfStatement
            case R.id.action_settings:
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



