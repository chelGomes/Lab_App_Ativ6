package br.ufjf.dcc196.chelgomes.filmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListasFilmesAdapter extends RecyclerView.Adapter  <ListasFilmesAdapter.ListasFilmesViewHolder>{
    private final List<ListaFilmes> filmes;
    private OnListarFilmesClickListener listener;

    public ListasFilmesAdapter(List<ListaFilmes> filmes, OnListarFilmesClickListener listener) {
        this.filmes = filmes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ListasFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View filmesView =  inflater.inflate(R.layout.listas_filmes_layout, parent, false);
        ListasFilmesViewHolder viewHolder = new ListasFilmesViewHolder(filmesView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListasFilmesViewHolder holder, int position) {
        holder.textViewTitulo.setText(filmes.get(position).getTitulo());
        holder.textViewAno.setText(filmes.get(position).getAno());
        holder.textViewEstilo.setText(filmes.get(position).getEstilo());
        holder.textViewDiretor.setText(filmes.get(position).getDiretor());
        holder.textViewAssistido.setText(filmes.get(position).getAssitistido());
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public class ListasFilmesViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitulo;
        private TextView textViewAno;
        private TextView textViewEstilo;
        private TextView textViewDiretor;
        private TextView textViewAssistido;


        public ListasFilmesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewAno = itemView.findViewById(R.id.textViewAno);
            textViewEstilo = itemView.findViewById(R.id.textViewEstilo);
            textViewDiretor = itemView.findViewById(R.id.textViewDiretor);
            textViewAssistido = itemView.findViewById(R.id.textViewAssistido);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onListarFilmesClick(itemView, getAdapterPosition());
                    Toast.makeText(v.getContext(),"Click"+getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
    public interface OnListarFilmesClickListener{
        void onListarFilmesClick(View source, int position);

    }
}
