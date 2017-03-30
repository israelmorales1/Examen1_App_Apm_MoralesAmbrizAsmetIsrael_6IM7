package com.example.cecyt9.examen1_app_apm_moralesambrizasmetisrael_6im7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.DoubleBuffer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickConvertir (View myView){

       try {
            EditText cantidadConvertir = (EditText) findViewById(R.id.CantidadConvertir);
            Intent intencion = new Intent(this,Activity2.class);
            Bundle recep = new Bundle();
            recep.putDouble("Result", Double.parseDouble(cantidadConvertir.getText().toString())/15);
            intencion.putExtras(recep);
            this.finish();
            startActivity(intencion);

        }catch (Exception e){
            Toast.makeText(this, "ERROR EN " + e.getCause(), Toast.LENGTH_SHORT).show();
        }

    }
}
