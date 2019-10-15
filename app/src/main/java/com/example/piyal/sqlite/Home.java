package com.example.piyal.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        ImageView addicon=new ImageView(this);
        addicon.setImageResource(R.drawable.add);
        ImageView setting=new ImageView(this);
        setting.setImageResource(R.drawable.setting);
        ImageView profile=new ImageView(this);
        profile.setImageResource(R.drawable.profile);
        ImageView document =new ImageView(this);
        document.setImageResource(R.drawable.document);
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(addicon)
                .build();
        final SubActionButton settinsubbt=new SubActionButton.Builder(this).setContentView(setting).build();
        SubActionButton docsubbt=new SubActionButton.Builder(this).setContentView(document).build();
        SubActionButton profilesubbt=new SubActionButton.Builder(this).setContentView(profile).build();
        FloatingActionMenu menu=new FloatingActionMenu.Builder(this)
                .addSubActionView(settinsubbt)
                .addSubActionView(profilesubbt)
                .addSubActionView(docsubbt)
                .attachTo(actionButton)
                .build();
        profilesubbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),About.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        findViewById(R.id.calculate_count_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),CalculateCount.class);
                startActivity(i);
            }
        });
        findViewById(R.id.count_convert_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),"I'm not Completed...& comming soon....",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getBaseContext(),ConvertCount.class);
                startActivity(i);
            }
        });
        findViewById(R.id.Convert_Length_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),LengthUnitConverter.class);
                startActivity(i);
            }
        });
        findViewById(R.id.Convert_Weight_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getBaseContext(),WeightConverter.class);
                startActivity(i);
            }
        });

    }
}
