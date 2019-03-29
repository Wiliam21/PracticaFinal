package com.example.mad.practicafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class InformacionActivity extends AppCompatActivity {
    TextView txtNombre,txtEdad,txtSexo,txtMascota,txtPasatimepos;
    ImageButton imgbCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        imgbCerrar = (ImageButton) findViewById(R.id.imgbCerrar);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtMascota = (TextView) findViewById(R.id.txtMascota);
        txtPasatimepos = (TextView) findViewById(R.id.txtPasatimepos);

        Intent Recibir=getIntent();
        String[] Datos=Recibir.getStringArrayExtra("DATOS");

        txtNombre.setText(Datos[0]);
        txtEdad.setText(Datos[1]);
        txtSexo.setText(Datos[2]);
        if(Datos[3].equals("0"))txtPasatimepos.setText("Ninguno");
        if(Datos[3].equals("1"))txtPasatimepos.setText("Videojuegos");
        if(Datos[3].equals("2"))txtPasatimepos.setText("Escuchar musica");
        if(Datos[3].equals("3"))txtPasatimepos.setText("Videojuegos\nEscuchar musica");
        txtMascota.setText(Datos[4]);
    }

    public void Cerrar(View view){
        startActivity(new Intent(this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        finish();
    }
}
