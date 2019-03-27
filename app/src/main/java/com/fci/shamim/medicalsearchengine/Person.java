package com.fci.shamim.medicalsearchengine;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Person {
    private String userId;
    private String name;
    private String gender;
    private String age;
    private String address;
    private String number;
    private String email;
    private String password;

    public static final String NAME="name";
    public static final String NUMBER="number";
    public static final String GENDER="gender";
    public static final String AGE="age";
    public static final String ADDRESS="address";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public static final String CONFIRM_PASSWORD="confirmPassword";
    public static final String DEFAULT="Data nor Found..!";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Context context;
  /*  String email;
    String password;
    String confirmPassword;
*/
  public Person() {

  }
    public Person(Context context) {

        this.context = context;

        sharedPreferences=context.getSharedPreferences("data",MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }

    public void saveData(String name, String number, String age, String gender, String address, String email, String password,String confirmPassword){
        if (password.equals(confirmPassword)){
            editor.putString(NAME,name);
            editor.putString(NUMBER,number);
            editor.putString(AGE,age);
            editor.putString(GENDER,gender);
            editor.putString(ADDRESS,address);
            editor.putString(EMAIL,email);
            editor.putString(PASSWORD,password);
            editor.putString(CONFIRM_PASSWORD,confirmPassword);
            editor.commit();
            Toast.makeText(context.getApplicationContext(),"Save Success",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context.getApplicationContext(),"Password Not Match",Toast.LENGTH_SHORT).show();
        }

    }


    public Person(String name, String number, String age, String gender, String address, String email, String password) {
        this.name = name;
        this.gender = gender;
        this.number = number;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return sharedPreferences.getString(NAME,DEFAULT);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return sharedPreferences.getString(GENDER,DEFAULT);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return sharedPreferences.getString(AGE,DEFAULT);
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return sharedPreferences.getString(ADDRESS,DEFAULT);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return sharedPreferences.getString(NUMBER,DEFAULT);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return sharedPreferences.getString(EMAIL,DEFAULT);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return sharedPreferences.getString(PASSWORD,DEFAULT);
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void toast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
}
