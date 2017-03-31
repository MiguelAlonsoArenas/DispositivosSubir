package com.example.alonso.appcruzazul;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class Miembro_Cruz_Azul extends AppCompatActivity implements View.OnClickListener {

    private Button Enviar, Nacimiento;
    private EditText Nombre, Direccion, Telefono, Fecha;
    private int anio, mes, dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miembro__cruz__azul);

        Enviar = (Button) findViewById(R.id.btnEnviar);
        Nacimiento = (Button) findViewById(R.id.btnFecha);
        Nombre = (EditText) findViewById(R.id.txtNombre);
        Direccion = (EditText) findViewById(R.id.txtdireccion);
        Telefono = (EditText) findViewById(R.id.txtTelefono);
        Fecha = (EditText) findViewById(R.id.txtFecha);
        Enviar.setOnClickListener(this);

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


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Fecha_Pick (View view) {
        if (view == Nacimiento) {
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    Fecha.setText(new StringBuilder().append(month + 1)
                            .append("-").append(dayOfMonth).append("-").append(year)
                            .append(" "));
                }
            }
                    , dia, mes, anio);
            datePickerDialog.show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        intent = new Intent(this, Registro.class);
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


