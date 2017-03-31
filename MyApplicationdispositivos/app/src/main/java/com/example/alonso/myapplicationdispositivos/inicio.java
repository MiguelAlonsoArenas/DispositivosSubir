package com.example.alonso.myapplicationdispositivos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class inicio extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


    }


    @Override
    public void onClick(View v) {
        Intent explicit_intent;
        explicit_intent = new Intent(this, practica3.class);
        startActivity(explicit_intent) ;
    }
}

