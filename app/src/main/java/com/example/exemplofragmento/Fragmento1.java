package com.example.exemplofragmento;

import android.graphics.Color;  
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import org.w3c.dom.Text;

// Repositório com exemplo de Fragmentos estáticos

public class Fragmento1 extends Fragment {
    private Button Botao1;
    private Button Botao2;
    private Button Botao3;
    private TextView texto1;
    private View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        // Recupera uma "View v" para acessar as propriedades e métodos do fragmento
        v = inflater.inflate(R.layout.fragmento1, container, false);



        Botao1 = (Button) v.findViewById(R.id.button1);
        Botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botão data");
                DialogFragment fragmentoData = new FragmentoDatePicker();
                fragmentoData.show(getParentFragmentManager(), "datePicker");


            }
        });

        Botao2 = (Button) v.findViewById(R.id.button2);
        Botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botão hora");
                DialogFragment fragmentoTime = new FragmentoTimePicker();
                fragmentoTime.show(getParentFragmentManager(), "timePicker");


            }
        });



        texto1 = (TextView) v.findViewById(R.id.editTextDescription);
        texto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "descrição");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                if (txt != null) txt.append(
                        String.valueOf(texto1.getText())
                );
                Log.d("prints", "Descrição: " + texto1.getText());
            }
        });


        Botao3 = (Button) v.findViewById(R.id.button3);
        Botao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("prints", "botao Ok");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);

                txt.setTextColor(Color.BLACK);

            }
        });

        return v;
    }
}