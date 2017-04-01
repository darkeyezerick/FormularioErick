package giovanni.itt.AppGustavoFormulario;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import giovanni.itt.form.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnviar;
    private EditText ediNombre,ediDireccion, ediTelefono,ediFecha;
    private Button bfecha;
    private  int dia,mes,ano;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button) findViewById(R.id.ButtonEnviar);
        ediNombre = (EditText) findViewById(R.id.txtNombre);
        ediDireccion = (EditText) findViewById(R.id.txtVilla);
        ediTelefono = (EditText) findViewById(R.id.txtTelefono);
        btnEnviar.setOnClickListener(this);
        bfecha = (Button) findViewById(R.id.bfecha);
        ediFecha = (EditText) findViewById(R.id.txtFecha);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre = (String) extras.get("nombre");
            String datoTelefono = (String) extras.get("telefono");//Obtengo el telefono
            String datoDireccion = (String) extras.get("direccion");//Obtengo direccion
            String datoFecha = (String) extras.get("fecha");//obtengo fecha

            ediNombre.setText(datoNombre);//envia datos de nombre
            ediTelefono.setText(datoTelefono);//envia datos de telelfono
            ediDireccion.setText(datoDireccion);
            ediFecha.setText(datoFecha);



        }
    }

        public void Fecha_Pick (View view) {
            if (view == bfecha) {
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        ediFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }
                        , dia, mes, ano);
                datePickerDialog.show();
            }
        }






    @Override
    public void onClick(View v) {
        Intent explicit_intent;

        explicit_intent = new Intent(this, Main2Activity.class);
        String auxEdiNombre = ediNombre.getText().toString();
        String auxEdiTelefono = ediTelefono.getText().toString();
        String auxEdiDireccion = ediDireccion.getText().toString();
        String auxEdiFecha = ediFecha.getText().toString();

        explicit_intent.putExtra("nombre", auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("telefono", auxEdiTelefono);//Guardamos un entero
        explicit_intent.putExtra("direccion", auxEdiDireccion);
        explicit_intent.putExtra("fecha",auxEdiFecha);
        startActivity(explicit_intent);


    }

}



