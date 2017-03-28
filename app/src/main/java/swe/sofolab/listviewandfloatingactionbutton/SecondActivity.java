package swe.sofolab.listviewandfloatingactionbutton;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=(Toolbar)findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String query=new String();
        Intent searchIntent=getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            query=searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SecondActivity.this,query,Toast.LENGTH_SHORT).show();

        }

        String[] mycountries=getResources().getStringArray(R.array.countries);

        ArrayList<String> mylist=new ArrayList<String>();

        for (int i=0; i<mycountries.length;i++)
            if (mycountries[i].toLowerCase().contains(query.toLowerCase()))
            mylist.add(mycountries[i]);

        ListView lst=(ListView)findViewById(R.id.listViewsearch);
        ArrayAdapter adapter=new ArrayAdapter(SecondActivity.this,android.R.layout.simple_list_item_1,mylist);
        lst.setAdapter(adapter);


    }
}
