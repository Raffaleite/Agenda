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
    private Button Botao1; // data
    private Button Botao2; // hora
    private Button Botao3;
    private TextView texto1;
    private String descricao;
    private View v;





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



        Botao1 = (Button) v.findViewById(R.id.button1);
        Botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botão data");
                FragmentoDatePicker fragmentoData = new FragmentoDatePicker();
                fragmentoData.show(getParentFragmentManager(), "datePicker");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg3);
                if (txt != null) txt.append(
                        fragmentoData.getDate()
                );



            }
        });

        Botao2 = (Button) v.findViewById(R.id.button2);
        Botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("prints", "botão hora");
                FragmentoTimePicker fragmentoTime = new FragmentoTimePicker();
                fragmentoTime.show(getParentFragmentManager(), "timePicker");
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg4);
                if (txt != null) txt.append(
                        fragmentoTime.getTime()
                );

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

                Log.d("prints", "Cheguei: ");

            }
        });

        return v;
    }

    public String getDescription() {
        return descricao;
    }

    public void setDescription(String descricao) {
        this.descricao = String.valueOf(descricao);
    }
}