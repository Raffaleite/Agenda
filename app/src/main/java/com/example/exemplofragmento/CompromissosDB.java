package com.example.exemplofragmento;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class CompromissosDB {

    private Context mContext;
    private static Context mStaticContext;
    private SQLiteDatabase mDatabase;

    public CompromissosDB(Context contexto){
        mContext = contexto.getApplicationContext();
        mStaticContext = mContext;
        mDatabase = new CompromissosDBHelper(mContext).getWritableDatabase();
    }

    private static ContentValues getValoresConteudo(Compromisso r){
        ContentValues valores = new ContentValues();

        // pares chave-valor: nomes das colunas - valores
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DATA, r.getDate());
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.HORA, r.getTime());
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DESCRICAO, r.getDescription());
        return valores;
    }

    public void addCompromisso(Compromisso r){
        ContentValues valores = getValoresConteudo(r);
        mDatabase.insert(CompromissosDBSchema.CompromissosTbl.NOME, null, valores);
    }


}
