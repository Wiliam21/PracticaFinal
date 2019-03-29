package com.example.mad.practicafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    EditText txteNombre,txtnEdad;
    CheckBox chkVideojuegos,chkMusica;
    RadioButton rdbFemenino,rdbMasculino;
    RadioGroup rdbgSexo;
    ImageView imgMascota;
    Spinner spnEspecie;
    ListView lstRaza;
    Button btnExit;
    String mascota="Ninguna";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txteNombre=(EditText)findViewById(R.id.txteNombre);
        txtnEdad=(EditText)findViewById(R.id.txtnEdad);
        chkMusica=(CheckBox)findViewById(R.id.chkMusica);
        chkVideojuegos=(CheckBox)findViewById(R.id.chkVideojuegos);
        rdbFemenino=(RadioButton)findViewById(R.id.rdbFemenino);
        rdbMasculino=(RadioButton)findViewById(R.id.rdbMasculino);
        rdbgSexo=(RadioGroup)findViewById(R.id.rdbgSexo);
        imgMascota=(ImageView)findViewById(R.id.imgMascota);
        spnEspecie=(Spinner)findViewById(R.id.spnEspecie);
        lstRaza=(ListView) findViewById(R.id.lstRaza);
        btnExit=(Button)findViewById(R.id.btnNext);

        ArrayAdapter Raza= ArrayAdapter.createFromResource(this,R.array.Mascotas,android.R.layout.simple_spinner_item);
        spnEspecie.setAdapter(Raza);

        spnEspecie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("Elige")){
                    ArrayAdapter raza=ArrayAdapter.createFromResource(MainActivity.this,R.array.Elige,android.R.layout.simple_gallery_item);
                    lstRaza.setAdapter(raza);
                }
                if (parent.getItemAtPosition(position).equals("Perros")){
                    ArrayAdapter raza=ArrayAdapter.createFromResource(MainActivity.this,R.array.Perros,android.R.layout.simple_gallery_item);
                    lstRaza.setAdapter(raza);
                    imgMascota.setImageResource(R.drawable.perritos);
                    Perros();
                }
                if (parent.getItemAtPosition(position).equals("Gatos")){
                    ArrayAdapter raza=ArrayAdapter.createFromResource(MainActivity.this,R.array.Gatos,android.R.layout.simple_gallery_item);
                    lstRaza.setAdapter(raza);
                    imgMascota.setImageResource(R.drawable.gatitos);
                    Gatos();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void Perros(){
        lstRaza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:imgMascota.setImageResource(R.drawable.labrador);mascota="Labrador";break;
                    case 1:imgMascota.setImageResource(R.drawable.pitbull);mascota="Pitbull";break;
                    case 2:imgMascota.setImageResource(R.drawable.pastor);mascota="Pastor Aleman";break;
                }
            }
        });
    }

    public void Gatos(){
        lstRaza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:imgMascota.setImageResource(R.drawable.bombay);mascota="Bombay";break;
                    case 1:imgMascota.setImageResource(R.drawable.korat);mascota="Korat";break;
                    case 2:imgMascota.setImageResource(R.drawable.mauegipcio);mascota="Mau Egipcio";break;
                }
            }
        });
    }

    public void Next(View view){
        String Nombre=txteNombre.getText().toString();
        String Edad=txtnEdad.getText().toString();
        String Sexo=null;
        if (rdbMasculino.isChecked())Sexo="Masculino";
        if (rdbFemenino.isChecked())Sexo="Femenino";
        int hobby=0;
        if (chkVideojuegos.isChecked())hobby+=1;
        if (chkMusica.isChecked())hobby+=2;
        String pasatiempo=String.valueOf(hobby);
        String[] Datos={Nombre,Edad,Sexo,pasatiempo,mascota};
        startActivity(new Intent(MainActivity.this,InformacionActivity.class).putExtra("DATOS",Datos));
    }
}
