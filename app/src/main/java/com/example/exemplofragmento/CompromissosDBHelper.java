package com.example.exemplofragmento;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CompromissosDBHelper extends SQLiteOpenHelper{

    private static final int VERSAO = 1;

    private static final String NOME_DATABASE = "compromissoDB";

    public CompromissosDBHelper(Context context){ super(context, NOME_DATABASE, null, VERSAO); }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ CompromissosDBSchema .CompromissosTbl.NOME+ "("+
                "_id integer PRIMARY KEY autoincrement,"+
                CompromissosDBSchema .CompromissosTbl.Cols.DATA+ ","+
                CompromissosDBSchema .CompromissosTbl.Cols.HORA + ","+
                CompromissosDBSchema .CompromissosTbl.Cols.DESCRICAO+ ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
        // Política de upgrade é simplesmente descartar o conteúdo e começar novamente
        db.execSQL("DROP TABLE IF EXISTS " + CompromissosDBSchema .CompromissosTbl.NOME);
        onCreate(db);
    }
}
