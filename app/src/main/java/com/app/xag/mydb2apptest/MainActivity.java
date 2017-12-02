package com.app.xag.mydb2apptest;

import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.EditText;


import com.app.xag.mydb2apptest.db.test_tab1;
import com.app.xag.mydb2apptest.db.test_tab1_Table;
import com.app.xag.mydb2apptest.util.LogUtil;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class MainActivity extends MyActivity implements OnClickListener {
    private EditText m_tab_id;
    private EditText m_tab_name;
    private EditText m_tab_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(getClass().getSimpleName(), "【onCreate】");
        setContentView(R.layout.activity_main);

        m_tab_id = (EditText) findViewById(R.id.tab_id);
        m_tab_name = (EditText) findViewById(R.id.tab_name);
        m_tab_value = (EditText) findViewById(R.id.tab_value);

        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(this);

        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(this);

        Button bt3 = (Button) findViewById(R.id.bt3);
        bt3.setOnClickListener(this);

        Button bt4 = (Button) findViewById(R.id.bt4);
        bt4.setOnClickListener(this);

        Button bt5 = (Button) findViewById(R.id.bt5);
        bt5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                SaveDB();
                break;
            case R.id.bt2:
                QueryDB();
                break;
            case R.id.bt3:
                InsertDB();
                break;
            case R.id.bt4:
                UpdateDB();
                break;
            case R.id.bt5:
                DeleteDB();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(getClass().getSimpleName(), "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(getClass().getSimpleName(), "【onDestroy】");
    }

    private  void SaveDB()
    {
        test_tab1 obj =new test_tab1();
        obj.setId(Integer.parseInt(m_tab_id.getText().toString()));
        obj.setData_name(m_tab_name.getText().toString());
        obj.setData_value(m_tab_value.getText().toString());
        boolean a=obj.save();
        LogUtil.d(getClass().getSimpleName(),"save状态："+a+",id="+obj.getId());
        //Toast.makeText(this,"插入状态："+a+",id="+obj.getId(),Toast.LENGTH_LONG).show();
    }

    private  void QueryDB()
    {
        //查询所有
        List<test_tab1> test_tab1s = new Select().from(test_tab1.class).queryList();
        for(test_tab1 tab1 : test_tab1s ){
            LogUtil.d(getClass().getSimpleName(),"id="+tab1.getId()+",data_name="+tab1.data_name+",data_value="+tab1.getData_value());
        }
    }

    private  void InsertDB()
    {
        try
        {
            test_tab1 obj =new test_tab1();
            //obj.setId(Integer.parseInt(m_tab_id.getText().toString()));
            obj.setData_name(m_tab_name.getText().toString());
            obj.setData_value(m_tab_value.getText().toString());
            long a=obj.insert();
            LogUtil.d(getClass().getSimpleName(),"return id="+a);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private  void UpdateDB()
    {
        try
        {
            SQLite.update(test_tab1.class).set(test_tab1_Table.data_value.eq(m_tab_value.getText().toString())).where(test_tab1_Table.id.eq(Integer.parseInt(m_tab_id.getText().toString()))).execute();
            LogUtil.d(getClass().getSimpleName(),"return id=ok");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private  void DeleteDB()
    {
        try
        {
            SQLite.delete(test_tab1.class).where(test_tab1_Table.id.eq(Integer.parseInt(m_tab_id.getText().toString()))).execute();
            LogUtil.d(getClass().getSimpleName(),"return id=ok");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
