package br.ufjf.dcc196.chelgomes.filmes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListasFilmesAdapter.OnListarFilmesClickListener{

    private RecyclerView recyclerViewFilmes;
    private List<ListaFilmes> filmes;
    private LinearLayoutManager layoutManager;
    private ListasFilmesAdapter listasFilmesAdapter;
    private ItemTouchHelper.SimpleCallback touchHelperCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmes = new ArrayList<ListaFilmes>(){{
            add(new ListaFilmes("2012","2009","ficcao cientifica","Roland Emmerich",
                    "sim"));
            add(new ListaFilmes("O Dia Depois do Amanha","2004","ficcao cientifica","Roland Emmerich",
                    "sim"));
            add(new ListaFilmes("Inferno de Dante","1997","aventura","Roger Donaldson",
                    "sim"));
            add(new ListaFilmes("Incontrolavel","2011","Acao","Tony Scott",
                    "sim"));
            add(new ListaFilmes("Matrix","1999","ficcao cientifica","Lana Wachowski",
                    "nao"));
            add(new ListaFilmes("Os Mercenarios2","2012","Acao","Simon West",
                    "sim"));
            add(new ListaFilmes("Esquadrao Suicida","2021","Acao","James Gunn",
                    "nao"));
            add(new ListaFilmes("Rota de Fuga","2013","Acao","Mikael Hafstrom",
                    "sim"));
            add(new ListaFilmes("O Homem nas Trevas","2016","Suspense","Fede Alvaresz",
                    "nao"));
            add(new ListaFilmes("Jumanji - Proxima Fase","2019","Aventura","Jake Kasdan",
                    "nao"));
        }};

        recyclerViewFilmes = findViewById(R.id.recyclerViewFilmes);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFilmes.setLayoutManager(layoutManager);
        listasFilmesAdapter = new ListasFilmesAdapter(filmes, this );
        recyclerViewFilmes.setAdapter(listasFilmesAdapter);

        touchHelperCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                filmes.remove(viewHolder.getAdapterPosition());
                listasFilmesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        new ItemTouchHelper(touchHelperCallback).attachToRecyclerView(recyclerViewFilmes);

    }

    @Override
    public void onListarFilmesClick(View source, int position) {
        filmes.get(position).incrementa();
        listasFilmesAdapter.notifyItemChanged(position);
        Toast.makeText(this, "Click"+position, Toast.LENGTH_SHORT).show();

    }
}