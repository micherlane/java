package com.example.aplicacao.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aplicacao.R;
import com.example.aplicacao.modelos.Comida;

import org.w3c.dom.Text;

import java.util.List;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ComidaViewHolder> {

    private Context context;
    private List<Comida> comidas;

    public ComidaAdapter(Context context, List<Comida> comidas) {
        this.context = context;
        this.comidas = comidas;
    }

    //criar caixotes

    @NonNull
    @Override
    public ComidaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //Transformar o layout em objeto java:
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_comida,viewGroup, false); //Conecta ao layout

        ComidaViewHolder viewHolder =  new ComidaViewHolder(view);
        return viewHolder;
    }

    //preencher pacotes

    @Override
    public void onBindViewHolder(@NonNull ComidaViewHolder comidaViewHolder, int posicao) {
        Comida comida = comidas.get(posicao);
        //Esse método lista os valores na tela...
        comidaViewHolder.txtComidaNome.setText(comida.getNome());
        comidaViewHolder.txtComidaIngredientes.setText(comida.getIngredientes());
        comidaViewHolder.txtComidaValor.setText("R$ "+comida.getValor());
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    class ComidaViewHolder extends RecyclerView.ViewHolder{

        TextView txtComidaNome;
        TextView txtComidaIngredientes;
        TextView txtComidaValor;
        Button btnAdicionar;

        public ComidaViewHolder(@NonNull final View itemView) {
            super(itemView);

            //Binding
            txtComidaNome = itemView.findViewById(R.id.txt_comida_nome);
            txtComidaIngredientes = itemView.findViewById(R.id.txt_comida_ingredientes);
            txtComidaValor = itemView.findViewById(R.id.txt_comida_valor);
            btnAdicionar = itemView.findViewById(R.id.btn_adicionar);

            //Configurar clicks
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicao = getAdapterPosition();
                    Comida comida = comidas.get(posicao);
                    Snackbar.make(v,"clicou no(a) "+comida.getNome(),Snackbar.LENGTH_LONG).show();
                }
            });*/
            btnAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Comida comida = comidas.get(getAdapterPosition());
                    Snackbar.make(v,"Comida "+comida.getNome()+" adicionada ao carrinho", Snackbar.LENGTH_LONG).show();
                }
            });


        }
    }
}

