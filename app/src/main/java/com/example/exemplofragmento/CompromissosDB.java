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

    private static ContentValues getValoresConteudo(FragmentoDatePicker q, FragmentoTimePicker p){
        ContentValues valores = new ContentValues();

        // pares chave-valor: nomes das colunas - valores
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DATA, q.getDate());
        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.HORA,p.getTime());
//        valores.put(CompromissosDBSchema.CompromissosTbl.Cols.DESCRICAO, d);
        return valores;
    }

    public void addComprimisso(FragmentoDatePicker q, FragmentoTimePicker p){
        ContentValues valores = getValoresConteudo(q, p);
        Log.d("prints", "Cheguei: " +  q);
        mDatabase.insert(CompromissosDBSchema.CompromissosTbl.NOME, null, valores);
    }


}
