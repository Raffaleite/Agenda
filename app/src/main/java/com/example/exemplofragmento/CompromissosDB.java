package com.example.exemplofragmento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;


public class CompromissosDB {
    private final SQLiteDatabase mDatabase;

    public CompromissosDB(@NonNull Context contexto) {
        Context mContext = contexto.getApplicationContext();
        mDatabase = new CompromissosDBHelper(mContext).getWritableDatabase();
    }

    @NonNull
    private static ContentValues getValoresConteudo(String data, String time, String description) {
        ContentValues valores = new ContentValues();

        // pares chave-valor: nomes das colunas - valores
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DATA, data);
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.HORA, time);
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DESCRICAO, description);
        return valores;
    }

    public void addComprimisso(String data, String time, String description) {
        ContentValues valores = getValoresConteudo(data, time, description);
        Log.d("prints", "data: " + data);
        Log.d("prints", "time: " + time);
        Log.d("prints", "description: " + description);
        Log.d("prints", "to aqui com os valores: " + valores);
        mDatabase.insert(CompromissosDBSchema.CompromissosTbl.NOME, null, valores);
    }

    public Cursor queryCompromisso(String clausulaWhere, String[] argsWhere){
        return mDatabase.query(CompromissosDBSchema.CompromissosTbl.NOME,
                null,  // todas as colunas
                clausulaWhere,
                argsWhere,
                null, // sem group by
                null, // sem having
                null  // sem order by
        );
    }


}
