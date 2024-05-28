package com.example.exemplofragmento;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;


import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
public class FragmentoOtherDatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int dia, mes, ano;
    String otherData;

    CompromissosDB mCompromissoDB;

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

            otherData = dia + "/" + mes + "/" + ano;

            this.setOtherDate(otherData);

            txt.setText(" ");
            txt.setTextColor(Color.BLACK);
            txt.append(this.getOtherDate());
            txt.append(" ");

            Log.d("prints", "Outra Data: " + this.getOtherDate());

            TextView text = Fragmento2.frgto2.findViewById(R.id.texto_frg2);
            txt.setText("");

            text.setTextColor(Color.BLACK);
            text.setText(this.getOtherDate());

            if (mCompromissoDB == null){
                mCompromissoDB = new CompromissosDB(requireActivity().getBaseContext());
            }

            Cursor cursor = mCompromissoDB.queryCompromisso(null, null);
            if (cursor != null) {
                if (cursor.getCount() == 0) {
                    Log.i("MSGS", "Nenhum resultado");
                }
                Log.i("MSGS", Integer.toString(cursor.getCount()));
                Log.i("MSGS", "cursor não nulo!");
                try {
                    cursor.moveToFirst();
                    while (!cursor.isAfterLast()) {
                        @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(CompromissosDBSchema.CompromissosTbl.Cols.DATA));
                        @SuppressLint("Range") String hora = cursor.getString(cursor.getColumnIndex(CompromissosDBSchema.CompromissosTbl.Cols.HORA));
                        @SuppressLint("Range") String descricao = cursor.getString(cursor.getColumnIndex(CompromissosDBSchema.CompromissosTbl.Cols.DESCRICAO));
                        Log.i("MSGS", data);
                        Log.i("MSGS", hora);
                        Log.i("MSGS", descricao);
                        Log.i("MSGS", this.getOtherDate());

                        if (data.equals(this.getOtherDate())){
                            text.append("\n" + hora + " - " + descricao);
                        }
                        cursor.moveToNext();
                    }
                } finally {
                    cursor.close();
                }
            } else {
                Log.i("MSGS", "cursor nulo!");
            }

        }
    }

    public String getOtherDate() {
        return otherData;
    }

    public void setOtherDate(String data) {
        this.otherData = data;
    }

}
