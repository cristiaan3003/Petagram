package cristian.com.cristian.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import cristian.com.cristian.R;
import cristian.com.cristian.adapter.FavoritoAdapter;
import cristian.com.cristian.db.ConstructorMascota;
import cristian.com.cristian.pojo.Mascota;

public class FavoritoActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private List<Mascota> mascotas;
    private RecyclerView vista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);
        generarToolbar();
        generarMascotas();
        vista = (RecyclerView) findViewById(R.id.rvMascotas);
        inicarAdaptador();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        vista.setLayoutManager(llm);

    }


    private void generarMascotas() {
        mascotas = new ArrayList<>();
        ConstructorMascota cm = new ConstructorMascota(getApplicationContext());
        mascotas = cm.obtenerCincoMejoresMascotas();

    }

    private void inicarAdaptador() {
        FavoritoAdapter fa = new FavoritoAdapter(mascotas,getApplicationContext());
        vista.setAdapter(fa);
    }

    private void generarToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
