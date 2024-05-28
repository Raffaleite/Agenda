package com.example.exemplofragmento;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class FragmentoDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int dia, mes, ano;
    String data;

    @NonNull
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
        Log.d("Data", "Ano: "+ year);
        Log.d("Data", "Mês: "+ (month + 1));
        Log.d("Data", "Dia: "+ day);
        dia = day;
        mes = month + 1;
        ano = year;

        TextView txt = Fragmento2.frgto2.findViewById(R.id.texto_frg2);

        if (txt != null) {

            data = dia + "/" + mes + "/" + ano;

            this.setDate(data);

            txt.setText(" ");
            txt.setTextColor(Color.argb(0,0,0,0));
            txt.append(" ");
            txt.append(this.getDate());
            txt.append(" ");

            Log.d("prints", "Data: " + this.getDate());
        }
    }


    public String getDate() {
        return data;
    }

    public void setDate(String data) {
        this.data = data;
    }
}
