package swe.sofolab.listviewandfloatingactionbutton;

import android.app.SearchManager;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton fab_plus,fab_share,fab_search,fab_man,fab_like;

    Animation FadeOpen,FadeClose;

    boolean isOpen=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Floating();

        Toolbar toolbar=(Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle(R.string.title);
        getSupportActionBar().setSubtitle(R.string.sutitle);
        getSupportActionBar().setIcon(R.drawable.ic_action_toolbar);


        Intent searchIntent=getIntent();

        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())){
            String query=searchIntent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(MainActivity.this,query,Toast.LENGTH_SHORT).show();
        }


        ListView lst=(ListView)findViewById(R.id.listViewmain);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.countries));
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked on "+position,Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        SearchView searchView=(SearchView)menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager=(SearchManager)getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu1:
                Toast.makeText(getApplicationContext(),"First position",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu2:
                Toast.makeText(getApplicationContext(),"Second position",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu3:
                Toast.makeText(getApplicationContext(),"Third position",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu4:
                Toast.makeText(getApplicationContext(),"Fourth position",Toast.LENGTH_SHORT).show();
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    public void Floating(){


        fab_plus=(FloatingActionButton)findViewById(R.id.fab_plus_xml);
        fab_share=(FloatingActionButton)findViewById(R.id.fab_share_xml);
        fab_search=(FloatingActionButton)findViewById(R.id.fab_search_xml);
        fab_man=(FloatingActionButton)findViewById(R.id.fab_man_xml);
        fab_like=(FloatingActionButton)findViewById(R.id.fab_like_xml);


        FadeOpen=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_open);
        FadeClose=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_close);


        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOpen){

                    fab_search.startAnimation(FadeClose);
                    fab_share.startAnimation(FadeClose);
                    fab_man.startAnimation(FadeClose);
                    fab_like.startAnimation(FadeClose);

                    fab_search.setClickable(false);
                    fab_share.setClickable(false);
                    fab_man.setClickable(false);
                    fab_like.setClickable(false);

                    isOpen=false;


                }

                else {

                    fab_share.startAnimation(FadeOpen);
                    fab_search.startAnimation(FadeOpen);
                    fab_man.startAnimation(FadeOpen);
                    fab_like.startAnimation(FadeOpen);

                    fab_share.setClickable(true);
                    fab_search.setClickable(true);
                    fab_man.setClickable(true);
                    fab_like.setClickable(true);
                    isOpen=true;

                }

            }
        });


        fab_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"You clicked Dislike button",Toast.LENGTH_SHORT).show();
            }
        });

        fab_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked Man Icon",Toast.LENGTH_SHORT).show();

            }
        });


        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked Share Icon",Toast.LENGTH_SHORT).show();

            }
        });


        fab_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"You clicked Search Icon",Toast.LENGTH_SHORT).show();

            }
        });





    }



}
