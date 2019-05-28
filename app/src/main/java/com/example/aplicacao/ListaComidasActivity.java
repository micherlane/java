package com.example.aplicacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aplicacao.adapters.ComidaAdapter;
import com.example.aplicacao.modelos.Comida;

public class ListaComidasActivity extends AppCompatActivity {

    private RecyclerView rvComidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comidas);

        rvComidas = findViewById(R.id.rv_comidas);

        // preencher os dados na tela
        atualizarViews();
    }

    private void atualizarViews() {
        ComidaAdapter adapter = new ComidaAdapter(this, Comida.getComidas());

        rvComidas.setAdapter(adapter);

        rvComidas.setLayoutManager(new LinearLayoutManager(this));
    }
}
