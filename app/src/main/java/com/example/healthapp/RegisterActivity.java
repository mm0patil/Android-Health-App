package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edName,edPhone,edPin,edPinConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edName = findViewById(R.id.editTextName);
        edPhone = findViewById(R.id.editTextPhone);
        edPin = findViewById(R.id.EditTextPin);
        edPinConfirm = findViewById(R.id.EditTextPinConfirm);
        btn = findViewById(R.id.ButtonRegister);
        tv = findViewById(R.id.textViewLoginHere);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = edName.getText().toString();
                String Phone = edPhone.getText().toString();
                String Pin = edPin.getText().toString();
                String PinConfirm = edPinConfirm.getText().toString();
                Database db = new Database(getApplicationContext(),"healthcare",null,1);
                if(Name.length()==0 || Phone.length()==0 || Pin.length()==0 || PinConfirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Enter all details",Toast.LENGTH_SHORT).show();
                }else{
                    if(Pin.compareTo(PinConfirm)==0){
                        db.register(Name,Phone,Pin);
                        Toast.makeText(getApplicationContext(),"Record Inserted",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Pin does not Match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}