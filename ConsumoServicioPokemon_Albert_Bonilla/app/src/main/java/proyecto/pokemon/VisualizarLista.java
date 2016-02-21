package proyecto.pokemon;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import proyecto.pokemon.entity.PokemonEntity;
import proyecto.pokemon.service.ApiImplementation;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class VisualizarLista extends ActionBarActivity {

    private ListView listaVisualizar;
    private TextView mostrarEstadoServicio;
    private Nombres datosPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_lista);

        mostrarEstadoServicio = (TextView) findViewById(R.id.txt_servicio);
        listaVisualizar = (ListView) findViewById(R.id.lista);
        final ArrayList<String> listaPokemon = new ArrayList();

        for(int i = 0; i < datosPokemon.nombres.length; i++)
        {
            listaPokemon.add(new String("Pokemon: ").concat(datosPokemon.nombres[i]));
            listaPokemon.add(new String("Tipo: ").concat(datosPokemon.tipos[i]));
            listaPokemon.add("");
        }


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        ApiImplementation.getService().getPokemons(new Callback<ArrayList<PokemonEntity>>() {
            @Override
            public void success(ArrayList<PokemonEntity> lista, Response response) {
                mostrarEstadoServicio.setText(" Online");
                for (PokemonEntity p : lista) {
                    //imprimir en consola
                    Log.i("respuesta", p.getNombre());
                    Log.i("respuesta", p.getTipo());
                    Log.i("respuesta", p.getImagen());
                }

            }

            @Override
            public void failure(RetrofitError retrofitError) {
                mostrarEstadoServicio.setText(" Offline");
            }
        });
        adaptador.addAll(listaPokemon);
        listaVisualizar.setAdapter(adaptador);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_visualizar_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
