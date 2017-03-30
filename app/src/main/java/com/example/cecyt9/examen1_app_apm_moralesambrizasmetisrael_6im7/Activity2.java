package com.example.cecyt9.examen1_app_apm_moralesambrizasmetisrael_6im7;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView desplegado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle recep = getIntent().getExtras();
        desplegado = (TextView) findViewById(R.id.ResultRe);
        Double resultado = recep.getDouble("Result");
        desplegado.setText(desplegado.getText().toString() + Double.toString(resultado));
    }

    public void onClickEnviar(View myView){

        try {
            Intent intento = new Intent(Intent.ACTION_SEND);
            intento.setType("text/plain");
            intento.putExtra(Intent.EXTRA_EMAIL,new String[]{"eoropezag@ipn.mx"});
            intento.putExtra(Intent.EXTRA_SUBJECT,"EXAMEN 1ER PARCIAL");
            intento.putExtra(Intent.EXTRA_TEXT,desplegado.getText().toString());
            
            startActivity(intento);
        }catch (Exception e){
            new AlertDialog.Builder(myView.getContext())
                    .setTitle("UPS..... HAY UN ERROR")
                    .setMessage("CAUSADO POR " + e.getCause())
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }


}
