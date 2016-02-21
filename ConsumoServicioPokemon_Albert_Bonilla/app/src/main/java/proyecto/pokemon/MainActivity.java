package proyecto.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private EditText edtNombre;
    private EditText edtTipo;
    private Nombres datosPokemon;
    private boolean valido = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = (EditText) findViewById(R.id.edtnombre);
        edtTipo = (EditText) findViewById(R.id.edttipo);

    }

     public void iniciar(View v)
    {
            if(edtNombre.getText().toString().equals("") || edtTipo.getText().toString().equals(""))
            {
                Toast.makeText(this, "Complete los datos", Toast.LENGTH_SHORT).show();
            }
            else {
                for(int i = 0; i < datosPokemon.nombres.length; i++) {

                    if (edtNombre.getText().toString().equals(datosPokemon.nombres[i]) && edtTipo.getText().toString().equals(datosPokemon.tipos[i])) {
                        valido = true;
                    }
                }

                if(valido == true)
                {
                    valido = false;
                    edtNombre.setText("");
                    edtTipo.setText("");
                    Intent nuevoform=new Intent(MainActivity.this, VisualizarLista.class);
                    startActivity(nuevoform);
                }
                else{
                    Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }
            }


    }

    public void borrar(View v)
    {
        valido = false;
        edtNombre.setText("");
        edtTipo.setText("");
    }

    public void salir(View v)
    {
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
