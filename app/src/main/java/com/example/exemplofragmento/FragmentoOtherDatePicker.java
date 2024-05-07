package com.example.exemplofragmento;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;


import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
public class FragmentoOtherDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int dia, mes, ano;
    String data;

    private View v;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(requireContext(), this, year, month, day);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //Log.d("Data", "Ano: "+String.valueOf(year));
        //Log.d("Data", "Mês: "+String.valueOf(month+1));
        //Log.d("Data", "Dia: "+String.valueOf(day));
        dia = day;
        mes = month + 1;
        ano = year;


        TextView txt = (TextView) Fragmento2.frgto2.findViewById(R.id.texto_frg2);

        if (txt != null) {

            data = String.valueOf(dia) +
                    "/" + String.valueOf(mes) +
                    "/" + String.valueOf(ano);
            txt.setText("");
            txt.setTextColor(Color.BLACK);
            txt.append(" ");
            txt.append(data);
            txt.append(" ");

            Log.d("prints", "OutraData: " + data);

        }
    }


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
