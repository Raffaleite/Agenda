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
import androidx.appcompat.app.AppCompatActivity;


public class Fragmento1 extends Fragment {
    Button Botao1;
    Button Botao2;
    Button Botao3;
    TextView texto1;
    TextView txt;
    View v;

    FragmentoDatePicker fragmentoData;
    FragmentoTimePicker fragmentoTime;

    CompromissosDB mCompromissoDB;

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

        Botao1 = v.findViewById(R.id.button1);
        Botao1.setOnClickListener(view -> {
            Log.d("prints", "botão data");
            fragmentoData = new FragmentoDatePicker();
            fragmentoData.show(getParentFragmentManager(), "datePicker");
        });

        Botao2 = v.findViewById(R.id.button2);
        Botao2.setOnClickListener(view -> {
            Log.d("prints", "botão hora");
            fragmentoTime = new FragmentoTimePicker();
            fragmentoTime.show(getParentFragmentManager(), "timePicker");
        });

        texto1 = v.findViewById(R.id.editTextDescription);
        texto1.setOnClickListener(view -> {
            TextView txt = Fragmento2.frgto2.findViewById(R.id.texto_frg2);
            if (txt != null) txt.append(
                    String.valueOf(texto1.getText())
            );

            Log.d("prints", "Descrição: " + texto1.getText());
        });


        Botao3 = v.findViewById(R.id.button3);
        Botao3.setOnClickListener(view -> {

            Log.d("prints", "botao Ok");

            txt = Fragmento2.frgto2.findViewById(R.id.texto_frg2);

            txt.setTextColor(Color.BLACK);

            Log.d("prints", "to aqui" + txt);

            if (mCompromissoDB == null){
                mCompromissoDB = new CompromissosDB(requireActivity().getBaseContext());
            }

            mCompromissoDB.addComprimisso(fragmentoData.data, fragmentoTime.time, String.valueOf(texto1.getText()));

        });

        return v;
    }
}