package com.example.exemplofragmento;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

public class Fragmento2 extends Fragment {
    static  View frgto2;
    private Button Botao4;
    private Button Botao5;
    ViewGroup c;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o layout para este fragmento
        frgto2 = inflater.inflate(R.layout.fragmento2, container, false);
        // Retorna uma "View frgto2" para acessar as propriedades e métodos do fragmento a partir da Activity pai

        Botao4 = (Button) frgto2.findViewById(R.id.button1);
        Botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);
                txt.setText("");
                Date currentDate = new Date();

                String timeZoneID = "America/Sao_Paulo";
                TimeZone timeZone = TimeZone.getTimeZone(timeZoneID);

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setTimeZone(timeZone);
                String formattedDate = sdf.format(currentDate);

                txt.setTextColor(Color.BLACK);
                txt.setText(formattedDate);


            }
        });

        Botao5 = (Button) frgto2.findViewById(R.id.button2);
        Botao5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment fragmentoData = new FragmentoOtherDatePicker();
                fragmentoData.show(getParentFragmentManager(), "datePicker");

            }
        });
        return frgto2; //inflater.inflate(R.layout.fragmento2, container, false);
    }
}