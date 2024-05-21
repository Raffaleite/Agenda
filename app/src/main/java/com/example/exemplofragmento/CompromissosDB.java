package com.example.exemplofragmento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CompromissosDB {

    private Context mContext;
    private static Context mStaticContext;
    private SQLiteDatabase mDatabase;

    public CompromissosDB(Context contexto){
        mContext = contexto.getApplicationContext();
        mStaticContext = mContext;
        mDatabase = new CompromissosDBHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getValoresConteudo(FragmentoDatePicker q, FragmentoTimePicker p, Fragmento1 d){
        ContentValues valores = new ContentValues();

        // pares chave-valor: nomes das colunas - valores
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DATA, q.getDate());
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.HORA,p.getTime());
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DESCRICAO, d.getDescription());
        return valores;
    }

    public void addComprimisso(FragmentoDatePicker q, FragmentoTimePicker p, Fragmento1 d){
        ContentValues valores = getValoresConteudo(q, p, d);
        mDatabase.insert(CompromissosDBSchema.CompromissosTbl.NOME, null, valores);
    }


}
