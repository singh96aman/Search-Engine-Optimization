package com.example.zailetapp;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnSuggestionListener{

    SearchView searchView;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        db.execSQL("create table posts(\n" +
                "id integer primary key,\n" +
                "title varchar(40),\n" +
                "post_data varchar(40)\n" +
                ");");
        db.execSQL("create table topics_english(\n" +
                "id integer primary key,\n" +
                "interest varchar(20),\n" +
                "cover_photo varchar(80)\n" +
                ");");
        db.execSQL("create table topics_map(\n" +
                "id integer primary key,\n" +
                "post_id integer,\n" +
                "topic_id integer\n" +
                ");");
        db.execSQL("insert into posts values (1,'How you can perform telekinesis!','Some data 1');\n" +
                "insert into posts values (2,'Should you be chasing your dreams?','Some data 2');\n" +
                "insert into posts values (3,'Three things you should never do!','Some data 3');\n" +
                "insert into topics_english values (1,'Mystery','link1');\n" +
                "insert into topics_english values (2,'Supernatural','link2');\n" +
                "insert into topics_english values (3,'Motivation','link3');\n" +
                "insert into topics_map values (1,1,1);\n" +
                "insert into topics_map values (2,1,2);\n" +
                "insert into topics_map values (3,2,3);\n" +
                "insert into topics_map values (4,3,1);");
        db.close();
        */

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        doSearchActivateSearch(menu);
        return true;
    }


    private void doSearchActivateSearch(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.search);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        final SearchManager searchManager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, SearchResult.class)));
        searchView.setOnSuggestionListener((SearchView.OnSuggestionListener) this);
        searchView.setIconifiedByDefault(false);
    }

    @Override
    public boolean onSuggestionSelect(int position) {
        return false;
    }

    @Override
    public boolean onSuggestionClick(int position) {
        int id = (int) searchView.getSuggestionsAdapter().
                getItemId(position) + 1;

        Intent intent = new Intent(this, SearchResult.class);

        //intent.putExtra("id", Integer.toString(id));
        // Toast.makeText(getApplicationContext(),""+id,Toast.LENGTH_LONG).show();
        /*
        db = openOrCreateDatabase("ZailetDB5",Context.MODE_PRIVATE,null);
        db.execSQL("create table posts(\n" +
                "id integer primary key,\n" +
                "title varchar(40),\n" +
                "post_data varchar(40)\n" +
                ");");
        db.execSQL("create table topics_english(\n" +
                "id integer primary key,\n" +
                "interest varchar(20),\n" +
                "cover_photo varchar(80)\n" +
                ");");
        db.execSQL("create table topics_map(\n" +
                "id integer primary key,\n" +
                "post_id integer,\n" +
                "topic_id integer\n" +
                ");");
        db.execSQL("insert into posts values (1,'How you can perform telekinesis!','Some data 1');\n" +
                "insert into posts values (2,'Should you be chasing your dreams?','Some data 2');\n" +
                "insert into posts values (3,'Three things you should never do!','Some data 3');\n" +
                "insert into topics_english values (1,'Mystery','link1');\n" +
                "insert into topics_english values (2,'Supernatural','link2');\n" +
                "insert into topics_english values (3,'Motivation','link3');\n" +
                "insert into topics_map values (1,1,1);\n" +
                "insert into topics_map values (2,1,2);\n" +
                "insert into topics_map values (3,2,3);\n" +
                "insert into topics_map values (4,3,1);");
        */

        //Cursor c= db.rawQuery("SELECT * FROM posts,topics_english,topics_map where post_id=posts.id and topic_id=topics_english.id and posts.id="+id,null);
        //c.moveToFirst();
        //Log.d("c.getcount",Integer.toString(c.getCount()));
        //if(c.getCount()>0)
        //{
            /*
            String title = c.getString(1);
            String post_data = c.getString(2);
            String interest = c.getString(3);
            String coverphoto = c.getString(4);
            String post_id = c.getString(5);
            String topic_id = c.getString(6);
            Log.d("Toast",Integer.toString(id)+title+post_data+interest+coverphoto+post_id+topic_id);
            Toast.makeText(getApplicationContext(),Integer.toString(id)+title+post_data+interest+coverphoto+post_id+topic_id,Toast.LENGTH_LONG).show();
            */
        //}
        if (id==1)
        {
            Toast.makeText(getApplicationContext(),"Mystery,SuperNatural",Toast.LENGTH_LONG).show();
        }
        else if(id==2)
        {
            Toast.makeText(getApplicationContext(),"Motivation",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Mystery",Toast.LENGTH_LONG).show();
        }
        //startActivity(intent);
        return false;
    }
}
