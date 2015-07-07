package com.example.loic.gissippool;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

/**
 * Created by LOIC on 05/07/1980.
 */
public class Identification extends Activity {

    private RadioGroup group;
    private CheckBox check;
    private Button btnsuivant;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.identification);
    }
}
