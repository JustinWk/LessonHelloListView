package com.example.haslina.hellolistview;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class ListViewMainActivity extends Activity {

    ListView lv;
    String[] data = {"Student 1" ,"Student 2" ,"Student 3" ,"Student 4"
            ,"Student 5" ,"Student 6" ,"Student 7" ,"Student 8" ,
            "Student 9","Student 1" ,"Student 2" ,"Student 3" ,
            "Student 4" ,"Student 5" ,"Student 6" ,"Student 7" ,
            "Student 8" ,"Student 9"  };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_main);
        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,data)
        {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);

                    text.setTextColor(Color.BLACK);


                return view;
            }
        };
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String valueInListView = (String) lv.getItemAtPosition(position);

                Snackbar.make(findViewById(android.R.id.content), valueInListView +
                        " is clicked which is at position no. " + (position+1),
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_view_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
