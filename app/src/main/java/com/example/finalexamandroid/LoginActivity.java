package com.example.finalexamandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Student stdList[]=new Student[3];
    EditText user,pass;
    Button login;
    public static Student std=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fillData();
        user=findViewById(R.id.extName);
        pass=findViewById(R.id.extPassword);
        login=findViewById(R.id.btnLogin);
        login.setOnClickListener(this);
    }


    public void fillData(){
        stdList[0]=new Student(100,"snehitha","user1","password1");
        stdList[1]=new Student(101,"pavan","user2","password2");
        stdList[2]=new Student(102,"gautam","user3","password3");
    }


    //a method which verifies the user, pass and returns the student object if that user is available
    public Student verifyLogin(String user, String pass){
        for(Student std:stdList)
            if(std.getUsername().equalsIgnoreCase(user) && std.getPassword().equals(pass))
                return std;
        return null;
    }


    @Override
    public void onClick(View v) {
        //get the use name
        String u=user.getText().toString();
        String p=pass.getText().toString();
        std=verifyLogin(u,p);
        if(std==null)
            Toast.makeText(this,"Invalid user name or password",Toast.LENGTH_LONG).show();
        else {
            //navigate to the MainActivity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}

