package giovanni.itt.AppGustavoFormulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import giovanni.itt.form.R;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    TextView txtNombre, txtTelefono, txtDireccion, txtFecha;
    private Button beditar;
    private EditText ediNombre;
    int request_code = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtNombre = (TextView) findViewById(R.id.textNombres);
        txtTelefono = (TextView) findViewById(R.id.textTelfonos);
        txtDireccion = (TextView) findViewById(R.id.textDirecciones);
        txtFecha =(TextView) findViewById(R.id.textNacimiento);
        beditar = (Button) findViewById(R.id.ButtonEditar);
        beditar.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre = (String) extras.get("nombre");//Obtengo el nombre
            String datoTelefono = (String) extras.get("telefono");//Obtengo el telefono
            String datoDireccion = (String) extras.get("direccion");//Obtengo direccion
            String datoFecha = (String) extras.get("fecha");

            txtNombre.setText("Nombre: "+datoNombre);
            txtTelefono.setText("Telefono :"+datoTelefono);
            txtDireccion.setText("Direccion :"+datoDireccion);
            txtFecha.setText("Fecha Nacimiento :"+datoFecha);



        }
    }

    public void Onclick (View view) {
        Intent explicit_intent;
        explicit_intent = new Intent(this, Main3Activity.class);
        startActivity(explicit_intent);
    }



    @Override
    public void onClick(View v) {
        Intent explicit_intent;

        explicit_intent = new Intent(this, MainActivity.class);
        String auxEdiNombre = txtNombre.getText().toString();
        String auxEdiTelefono = txtTelefono.getText().toString();
        String auxEdiDireccion = txtDireccion.getText().toString();
        String auxEdiFecha = txtFecha.getText().toString();

        explicit_intent.putExtra("nombre", auxEdiNombre);//Guardamos una cadena
        explicit_intent.putExtra("telefono", auxEdiTelefono);//Guardamos un entero
        explicit_intent.putExtra("direccion", auxEdiDireccion);
        explicit_intent.putExtra("fecha",auxEdiFecha);
        startActivity(explicit_intent);


    }
}


