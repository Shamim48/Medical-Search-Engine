package com.fci.shamim.medicalsearchengine;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  Person person;
  TextView showDataTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person=new Person(this);

        showDataTv=findViewById(R.id.showDataTvId);
        showDataTv.setText(" \n"+person.getName()+"\n"+

                            person.getNumber()+"\n" +
                            person.getAge()+"\n"+
                        person.getGender()+"\n"+
                            person.getAddress()+"\n"+
                            person.getEmail()+"\n"
                        );

    }

    public void signup(View view) {
    }


}
