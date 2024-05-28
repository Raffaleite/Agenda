package com.example.exemplofragmento;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

/*
Exemplo de https://github.com/udofritzke/FragmentosDataEHora
 */

public class FragmentoTimePicker extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
    int hora, minuto;
    String time;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hour, int minute) {

        hora = hour;
        minuto = minute;

        TextView txt = Fragmento2.frgto2.findViewById(R.id.texto_frg2);

        if (txt != null){
            time = hora +
                    ":" + minuto;

            this.setTime(time);

            txt.append(" ");
            txt.append(this.getTime());
            txt.append(" ");

            Log.d("prints", "Horário: " + this.getTime());

        }

    }

    public String getTime() {
        return time;
    }

    public void setTime(String data) {
        this.time = data;
    }

}

