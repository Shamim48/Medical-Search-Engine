package com.fci.shamim.medicalsearchengine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_in extends AppCompatActivity {
     Person person;
     private EditText emailEt,passwordEt;
     TextView showTextTv;

     // MH Sagor
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailEt=findViewById(R.id.signInEmailET);
        passwordEt=findViewById(R.id.signInPasswordET);
        showTextTv=findViewById(R.id.showTextTvId);
        person=new Person(this);

        sharedPreferences = this.getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getBoolean("isLoggedIn", false) == true){
            Intent intent = new Intent(getApplicationContext(), Home.class);
            startActivity(intent);
        }
/*

        showTextTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    showTextTv.setText("\n"+person.getName()+"\n"+

                            person.getNumber()+"\n" +
                            person.getAge()+"\n"+
                            person.getGender()+"\n"+
                            person.getAddress()+"\n"+
                            person.getEmail()+"\n");
                }catch (Exception e){
                    toast("Exception : "+e);
                }
            }
        });

*/


    }

    public void signIn(View view) {
        String email=emailEt.getText().toString();
        String password=passwordEt.getText().toString();
        try {
            if((email.equals(person.getEmail()) && (password.equals(person.getPassword())))) {

                // MH Sagor
                person.saveUserAuth(true);

              Intent intent = new Intent(getApplicationContext(), Home.class);
              startActivity(intent);
              emailEt.setText("");
              passwordEt.setText("");
            }else {
              Toast.makeText(getApplicationContext(),"Email Or Password Not Correct",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception :"+e,Toast.LENGTH_SHORT).show();

        }

    }

    public  void signup(View view) {
        Intent intent = new Intent(getApplicationContext(), Sign_Up.class);
        startActivity(intent);
    }
    public  void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

    }
}
