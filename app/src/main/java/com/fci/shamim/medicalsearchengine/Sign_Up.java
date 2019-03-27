package com.fci.shamim.medicalsearchengine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    private EditText nameEt, numberEt, ageEt, addressET,emailEt, passwordEt, confirmPasswordEt;
    TextView showTv;
    String gender="Male";
    Button signUpBtn;
    private RadioGroup radioGroupGender;
    Person person;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        findId();
       person=new Person(this);
      /*
       showTv.setText("\n"+person.getName()+"\n"+

               person.getNumber()+"\n" +
                       person.getAge()+"\n"+
                       person.getGender()+"\n"+
                       person.getAddress()+"\n"+
                       person.getEmail()+"\n");
*/
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);

                gender=rb.getText().toString();
                toast(gender+" is Selected");

            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=nameEt.getText().toString();
                String number=numberEt.getText().toString();
                String age=ageEt.getText().toString();
                String address=addressET.getText().toString();

                String email=emailEt.getText().toString();
                String password=passwordEt.getText().toString();
                String confirmPassword=confirmPasswordEt.getText().toString();

                person.saveData(name,number,age,gender,address, email,password,confirmPassword);


       /* String emailData=sharedPreferences.getString("email","Email Not Fount");
        String passworddata=sharedPreferences.getString("pass","Password Not Fount");
        String confirmpassdata=sharedPreferences.getString("confirmPass","Confirm Not Fount");
*/
                //  DataClass dataClass=new DataClass(emailData,passworddata,confirmpassdata);

                Intent intent=new Intent(getApplicationContext(),Sign_in.class);
                startActivity(intent);


            }
        });
    }

    public  void findId(){
        signUpBtn=findViewById(R.id.SignUpBT);
        nameEt =findViewById(R.id.signUpNameET);
        numberEt =findViewById(R.id.signUpNumberET);
        ageEt =findViewById(R.id.signAgelET);
        addressET =findViewById(R.id.signConfirmAddresslET);
        emailEt=findViewById(R.id.signUpEmailET);
        passwordEt =findViewById(R.id.signUpPasswordET);
        confirmPasswordEt =findViewById(R.id.signUpConfirmPassET);
        radioGroupGender =findViewById(R.id.radioGroupGenderId);
        showTv =findViewById(R.id.showTvId);
    }

    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
