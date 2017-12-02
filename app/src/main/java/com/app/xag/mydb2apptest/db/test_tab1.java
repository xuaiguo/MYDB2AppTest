package com.app.xag.mydb2apptest.db;


import com.app.xag.mydb2apptest.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by aiguo on 2017/11/25.
 */
@Table(database = AppDatabase.class)
public class test_tab1 extends BaseModel {
    @Column
    @Unique
    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String data_name;

    @Column
    public  String data_value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public String getData_value() {
        return data_value;
    }

    public void setData_value(String data_value) {
        this.data_value = data_value;
    }
}

