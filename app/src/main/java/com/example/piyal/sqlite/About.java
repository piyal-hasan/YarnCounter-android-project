package com.example.piyal.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        setTitle("About");

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        if(mi.getItemId()==android.R.id.home){
            //Toast.makeText(getApplicationContext(),"BACK",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getBaseContext(),Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }
}
