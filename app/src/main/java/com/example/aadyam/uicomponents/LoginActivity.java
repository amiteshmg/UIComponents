package com.example.aadyam.uicomponents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity
{

    Button login_button;
    String username_string,password_string;
    EditText userid_edit,password_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        login_button=(Button)findViewById(R.id.login_button);
        TextView register_text_object = (TextView)findViewById(R.id.register_text);
        userid_edit=(EditText)findViewById(R.id.edit_username);
        password_edit=(EditText)findViewById(R.id.password_edit);

        SpannableString content = new SpannableString("New User?Signup here");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        register_text_object.setText(R.string.register_text);
        final Intent intent=new Intent(LoginActivity.this,Register.class);
        final Intent intent2 =new Intent(LoginActivity.this,Home.class);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username_string=userid_edit.getText().toString();
                password_string=password_edit.getText().toString();

                setToast(username_string);

                if(username_string.equals("amiteshmg@gmail.com") && password_string.equals("amit"))
                {
                        startActivity(intent2);
                }

                else
                {
                    Toast.makeText(LoginActivity.this,"Wrong input credentials!",Toast.LENGTH_SHORT).show();
                }
            }
        });




        register_text_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });




    }


    public void setToast(String msg)
    {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
