package com.app.xag.mydb2apptest;

import com.raizlabs.android.dbflow.annotation.Database;
/*
import com.raizlabs.android.dbflow.annotation.Migration;
import com.raizlabs.android.dbflow.sql.SQLiteType;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.migration.AlterTableMigration;
import com.raizlabs.android.dbflow.sql.migration.BaseMigration;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
*/
/**
 * Created by aiguo on 2017/11/30.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public final class AppDatabase {
    //数据库名称
    public static final String NAME = "MYDB2";
    //数据库版本号
    public static final int VERSION = 1;

}