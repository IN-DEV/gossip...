package com.example.loic.gissippool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loic.gissippool.Provider.Requete;
import com.example.loic.gissippool.Provider.Profil;
import com.example.loic.gissippool.Provider.DataBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LOIC on 05/07/1980.
 */
public class Identification extends Activity {


    RadioGroup group = null;
    private EditText email = null;
    private EditText speudo = null;
    private EditText pass = null;
   private TextView result = null;
    CheckBox mega = null;
    private Button btnconti;
    Profil pro ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification);

        mega = (CheckBox)findViewById(R.id.check);
        pass =(EditText)findViewById(R.id.passwd);
        speudo =(EditText)findViewById(R.id.pseudo);
        email =(EditText)findViewById(R.id.email);
        group = (RadioGroup)findViewById(R.id.group);

        btnconti=(Button)findViewById(R.id.btncontinu);
        btnconti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String spd = speudo.getText().toString();
                final String pas = pass.getText().toString();
                final String eml = email.getText().toString();

                if (spd.equals("") || pas.equals("") || eml.equals("")) {
                    Toast.makeText(Identification.this,
                            R.string.email_or_password_or_speudo_empty,
                            Toast.LENGTH_SHORT).show();
                    return;

                } else {
                    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
                    Pattern pp = Pattern.compile("[0-9]{1}[a-z]{9}");
                    Pattern ps = Pattern.compile("[a-z]{9}");

                    Matcher m = p.matcher(eml);
                    Matcher mp = pp.matcher(pas);
                    Matcher ms = pp.matcher(spd);

                    Toast.makeText(Identification.this, R.string.email_format_error,
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Identification.this, MainActivity.class);

                    Requete red = new Requete();
                    Profil pro = new Profil();

                     red.open();
                    red.insertART(pro);
                    red.close();

                    startActivity(intent);

                }
            }
        });



}
}