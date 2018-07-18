package com.learndemo.learndemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  String DATABASE = "database.db";
    private static String TABLE = "mytable";
    private static String EMPLOYEE = "employee";
    private static String AGE = "age";
    private static String SALARY = "salary";
    private static String CODE = "code";
    String br;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        br = "CREATE TABLE "+TABLE+"("+EMPLOYEE+ " Text, "+CODE+ " Text, "+SALARY+ " Text, "+AGE+ " Text);";
        db.execSQL(br);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE+ " ;");

    }
    public void insertdata(String Emp, String EmpAge, String EmpSal,String EmpCode){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMPLOYEE, Emp);
        contentValues.put(CODE, EmpAge);
        contentValues.put(SALARY, EmpSal);
        contentValues.put(AGE, EmpCode);
        db.insert(TABLE, null,contentValues);

    }
    public List<DataModel>getdata(){
        List<DataModel> data = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE+";", null);
        StringBuffer stringBuffer = new StringBuffer();
        DataModel dataModel = null;
        while (cursor.moveToNext()){
            dataModel = new DataModel();
            String Emp = cursor.getString(cursor.getColumnIndexOrThrow("Emp"));
            String EmpSal = cursor.getString(cursor.getColumnIndexOrThrow("EmpSal"));
            String EmpAge = cursor.getString(cursor.getColumnIndexOrThrow("EmpAge"));
            dataModel.setEmp(Emp);
            dataModel.setEmpSal(EmpSal);
            dataModel.setEmpAge(EmpAge);

            stringBuffer.append(dataModel);
            data.add(dataModel);
        }

return data;
    }

}
