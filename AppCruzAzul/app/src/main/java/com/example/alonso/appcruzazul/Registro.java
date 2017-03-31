package com.example.alonso.appcruzazul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    TextView Nombre, Direccion, Telefono, Fecha;
    Button Editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Nombre = (TextView) findViewById(R.id.Nombre);
        Telefono = (TextView) findViewById(R.id.telefono);
        Direccion = (TextView) findViewById(R.id.direccion);
        Fecha =(TextView) findViewById(R.id.nacimiento);
        Editar = (Button) findViewById(R.id.btnEditar);
        Editar.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String obtenerNombre = (String) bundle.get("Nombre");
            String obtenerTelefono = (String) bundle.get("Telefono");
            String obtenerDireccion = (String) bundle.get("Direccion");
            String obtenerFecha = (String) bundle.get("Fecha");

            Nombre.setText(obtenerNombre);
            Telefono.setText(obtenerTelefono);
            Direccion.setText(obtenerDireccion);
            Fecha.setText(obtenerFecha);

        }
    }

    public void Onclick (View view) {
        Intent explicit_intent;
        explicit_intent = new Intent(this, Proceso.class);
        startActivity(explicit_intent);
    }



    @Override
    public void onClick(View v) {
        Intent intent;

        intent = new Intent(this, Miembro_Cruz_Azul.class);
        String cNombre = Nombre.getText().toString();
        String cTelefono = Telefono.getText().toString();
        String cDireccion = Direccion.getText().toString();
        String cFecha = Fecha.getText().toString();

        intent.putExtra("Nombre", cNombre);
        intent.putExtra("Telefono", cTelefono);
        intent.putExtra("Direccion", cDireccion);
        intent.putExtra("Fecha",cFecha);
        startActivity(intent);

    }
}

