package com.example.piyal.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CalculateCount extends AppCompatActivity {
    ArrayAdapter<String> adb1,adb2,adb3;
    Spinner sp1,sp2,sp3;
    EditText length,weight;
    TextView result;
    Button refresh;
    double W,L;
    String item="";
    double lvalue=0.0,wvalue=0.0;
    final double[] lengtharry={1.0936132983,1093.6132983,0.010936133,0.0010936133,1760.00,1.00,0.3333333333,0.0277777778};
    final double[] weightarry={0.0022046226,1.00,0.0625,2.2046226218,0.00390626,0.00014285714};
    DecimalFormat style=new DecimalFormat("####,##,##,###.#########");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_count);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("CalculateCount");
        refresh= (Button) findViewById(R.id.refresh);
        length= (EditText) findViewById(R.id.editText);
        weight= (EditText) findViewById(R.id.editText2);
        result= (TextView) findViewById(R.id.result);
        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        sp3=(Spinner)findViewById(R.id.spinner3);
        List<String> lenunit=new ArrayList<>();
        lenunit.add("m");
        lenunit.add("km");
        lenunit.add("cm");
        lenunit.add("mm");
        lenunit.add("mile");
        lenunit.add("yard");
        lenunit.add("foot");
        lenunit.add("inch");
        List<String> wdunit=new ArrayList<>();
        wdunit.add("g");
        wdunit.add("lb");
        wdunit.add("oz");
        wdunit.add("kg");
        wdunit.add("dram");
        wdunit.add("grain");
        List<String> systemlist=new ArrayList<>();
        systemlist.add("Select Unit");
        systemlist.add("Tex");
        systemlist.add("Denier");
        systemlist.add("Liner(jute)");
        systemlist.add("Silk");
        systemlist.add("Wollen(Aberdeen)");
        systemlist.add("Wollen(American grain)");
        systemlist.add("Asbestos(American)");
        systemlist.add("Asbestos(British)");
        systemlist.add("Cotton bump yarn");
        systemlist.add("Cotton(British)");
        systemlist.add("Cotton(Continental)");
        systemlist.add("Glass(U.S.A & U.K)");
        systemlist.add("Linen(Wet-spun)");
        systemlist.add("Metric");
        systemlist.add("Spun silk");
        systemlist.add("Wollen(Alloa)");
        systemlist.add("Wollen(American cut)");
        systemlist.add("Wollen(American run)");
        systemlist.add("Wollen(Dewsbury)");
        systemlist.add("Wollen(Galashiels)");
        systemlist.add("Wollen(Hawicks)");
        systemlist.add("Wollen(West of England)");
        systemlist.add("Wollen(Yorkshire)");
        systemlist.add("Worsted");
        adb1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,lenunit);
        adb1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adb1);
        adb2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,wdunit);
        adb2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adb2);
        adb3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,systemlist);
        adb3.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp3.setAdapter(adb3);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                length.setText("");
                weight.setText("");
                sp1.setSelection(0);
                sp2.setSelection(0);
                sp3.setSelection(0);
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(length.getText().toString().equals("")||weight.getText().toString().equals("")){
                    lvalue=0.0;
                    wvalue=0.0;
                }
                else {
                    try {
                        wvalue = Double.parseDouble(weight.getText().toString());
                        lvalue = Double.parseDouble(length.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //Toast.makeText(this,String.valueOf(L+"    "+W),Toast.LENGTH_SHORT).show();
                switch (sp3.getSelectedItem().toString()) {
                    case "Denier": {
                        //Toast.makeText(this,String.valueOf("Diner convert= "+length_coverter(String.valueOf(length.getText()),item)),Toast.LENGTH_LONG).show();
                        DirectCount(wvalue, 9842.519685, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Tex": {
                        DirectCount(wvalue, 1093.6132983, lvalue, sp1.getSelectedItemPosition());

                        break;
                    }
                    case "Liner(jute)": {
                        DirectCount(wvalue, 14400.00, lvalue, sp1.getSelectedItemPosition());

                        break;
                    }
                    case "Silk": {
                        DirectCount(wvalue, 1000.00, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Wollen(Aberdeen)": {
                        DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Wollen(American grain)": {
                        DirectCount(wvalue, 20.00, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Cotton(British)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                        break;
                    }
                    case "Asbestos(American)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                        break;
                    }
                    case "Asbestos(British)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 50.00, 1.00, item);
                        break;
                    }
                    case "Cotton bump yarn": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                        //Toast.makeText(CalculateCount.this,String.valueOf(sp1.getSelectedItemPosition())+String.valueOf(sp2.getSelectedItemPosition()),Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case "Cotton(Continental)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1093.6132983, 1.1023113109, item);
                        break;
                    }
                    case "Linen(wet-spun)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                        break;
                    }
                    case "Glass(U.S.A and U.K)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                        break;
                    }
                    case "Metric": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.0936132983, 2.2046226218, item);
                        break;
                    }
                    case "Spun silk": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Alloa)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 11520.00, 24.00, item);
                        break;
                    }
                    case "Wollen(American cut)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Dewsbury)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                        break;
                    }
                    case "Wollen(American run)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 0.0625, item);
                        break;
                    }
                    case "Wollen(Hawicks)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.625, item);
                        break;
                    }
                    case "Wollen(Galashiels)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.5, item);
                        break;
                    }
                    case "Wollen(West of England)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 320.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Yorkshire)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 256.00, 1.00, item);
                        break;
                    }
                    case "Worsted": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 560.00, 1.00, item);
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(length.getText().toString().equals("")||weight.getText().toString().equals("")){
                    lvalue=0.0;
                    wvalue=0.0;
                }
                else {
                    try {
                        wvalue = Double.parseDouble(weight.getText().toString());
                        lvalue = Double.parseDouble(length.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                //Toast.makeText(this,String.valueOf(L+"    "+W),Toast.LENGTH_SHORT).show();
                switch (sp3.getSelectedItem().toString()) {
                    case "Denier": {
                        //Toast.makeText(this,String.valueOf("Diner convert= "+length_coverter(String.valueOf(length.getText()),item)),Toast.LENGTH_LONG).show();
                        DirectCount(wvalue, 9842.519685, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Tex": {
                        DirectCount(wvalue, 1093.6132983, lvalue, sp1.getSelectedItemPosition());

                        break;
                    }
                    case "Liner(jute)": {
                        DirectCount(wvalue, 14400.00, lvalue, sp1.getSelectedItemPosition());

                        break;
                    }
                    case "Silk": {
                        DirectCount(wvalue, 1000.00, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Wollen(Aberdeen)": {
                        DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Wollen(American grain)": {
                        DirectCount(wvalue, 20.00, lvalue, sp1.getSelectedItemPosition());
                        break;
                    }
                    case "Cotton(British)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                        break;
                    }
                    case "Asbestos(American)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                        break;
                    }
                    case "Asbestos(British)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 50.00, 1.00, item);
                        break;
                    }
                    case "Cotton bump yarn": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                        Toast.makeText(CalculateCount.this,String.valueOf(sp1.getSelectedItemPosition())+String.valueOf(sp2.getSelectedItemPosition()),Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case "Cotton(Continental)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1093.6132983, 1.1023113109, item);
                        break;
                    }
                    case "Linen(wet-spun)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                        break;
                    }
                    case "Glass(U.S.A and U.K)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                        break;
                    }
                    case "Metric": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.0936132983, 2.2046226218, item);
                        break;
                    }
                    case "Spun silk": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Alloa)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 11520.00, 24.00, item);
                        break;
                    }
                    case "Wollen(American cut)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Dewsbury)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                        break;
                    }
                    case "Wollen(American run)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 100.00, 0.0625, item);
                        break;
                    }
                    case "Wollen(Hawicks)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.625, item);
                        break;
                    }
                    case "Wollen(Galashiels)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 300.00, 1.5, item);
                        break;
                    }
                    case "Wollen(West of England)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 320.00, 1.00, item);
                        break;
                    }
                    case "Wollen(Yorkshire)": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 256.00, 1.00, item);
                        break;
                    }
                    case "Worsted": {
                        InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                lvalue, sp1.getSelectedItemPosition(), 560.00, 1.00, item);
                        break;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(length.getText().toString().equals("")||weight.getText().toString().equals("")){
                    lvalue=0.0;
                    wvalue=0.0;
                }
                else {
                    try {
                        wvalue = Double.parseDouble(weight.getText().toString());
                        lvalue = Double.parseDouble(length.getText().toString());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
                    //Toast.makeText(this,String.valueOf(L+"    "+W),Toast.LENGTH_SHORT).show();
                    switch (sp3.getSelectedItem().toString()) {
                        case "Denier": {
                            //Toast.makeText(this,String.valueOf("Diner convert= "+length_coverter(String.valueOf(length.getText()),item)),Toast.LENGTH_LONG).show();
                            DirectCount(wvalue, 9842.519685, lvalue, sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Tex": {
                            DirectCount(wvalue, 1093.6132983, lvalue, sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Liner(jute)": {
                            DirectCount(wvalue, 14400.00, lvalue, sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Silk": {
                            DirectCount(wvalue, 1000.00, lvalue, sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(Aberdeen)": {
                            DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(American grain)": {
                            DirectCount(wvalue, 20.00, lvalue, sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Cotton(British)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                            break;
                        }
                        case "Asbestos(American)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                            break;
                        }
                        case "Asbestos(British)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 50.00, 1.00, item);
                            break;
                        }
                        case "Cotton bump yarn": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                            Toast.makeText(CalculateCount.this,String.valueOf(sp1.getSelectedItemPosition())+String.valueOf(sp2.getSelectedItemPosition()),Toast.LENGTH_SHORT).show();
                            break;
                        }
                        case "Cotton(Continental)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 1093.6132983, 1.1023113109, item);
                            break;
                        }
                        case "Linen(wet-spun)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                            break;
                        }
                        case "Glass(U.S.A and U.K)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 100.00, 1.00, item);
                            break;
                        }
                        case "Metric": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 1.0936132983, 2.2046226218, item);
                            break;
                        }
                        case "Spun silk": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 840.00, 1.00, item);
                            break;
                        }
                        case "Wollen(Alloa)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 11520.00, 24.00, item);
                            break;
                        }
                        case "Wollen(American cut)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 300.00, 1.00, item);
                            break;
                        }
                        case "Wollen(Dewsbury)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 1.00, 0.0625, item);
                            break;
                        }
                        case "Wollen(American run)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 100.00, 0.0625, item);
                            break;
                        }
                        case "Wollen(Hawicks)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 300.00, 1.625, item);
                            break;
                        }
                        case "Wollen(Galashiels)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 300.00, 1.5, item);
                            break;
                        }
                        case "Wollen(West of England)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 320.00, 1.00, item);
                            break;
                        }
                        case "Wollen(Yorkshire)": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 256.00, 1.00, item);
                            break;
                        }
                        case "Worsted": {
                            InDirectCount(wvalue, sp2.getSelectedItemPosition(),
                                    lvalue, sp1.getSelectedItemPosition(), 560.00, 1.00, item);
                            break;
                        }
                    }
                }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        length.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(length.getText().toString().equals("")||weight.getText().toString().equals("")){
                    lvalue=0.0;
                    wvalue=0.0;
                    result.setText("0");
                }
                else{
                    try{
                        wvalue=Double.parseDouble(weight.getText().toString());
                        lvalue=Double.parseDouble(length.getText().toString());
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    switch (sp3.getSelectedItem().toString()) {
                        case "Denier": {

                            DirectCount(wvalue, 9842.519685,lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Tex": {
                            DirectCount(wvalue, 1093.6132983,lvalue,sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Liner(jute)": {
                            DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Silk": {
                            DirectCount(wvalue, 1000.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(Aberdeen)": {
                            DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(American grain)": {
                            DirectCount(wvalue, 20.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Cotton(British)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 840.00, 1.00,item);
                            break;
                        }
                        case "Asbestos(American)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 1.00,item);
                            break;
                        }
                        case "Asbestos(British)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 50.00, 1.00,item);
                            break;
                        }
                        case "Cotton bump yarn": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.00, 0.0625,item);
                            break;
                        }
                        case "Cotton(Continental)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1093.6132983, 1.1023113109, item);
                            break;
                        }
                        case "Linen(wet-spun)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.00,item);
                            break;
                        }
                        case "Glass(U.S.A and U.K)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 1.00,item);
                            break;
                        }
                        case "Metric": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.0936132983, 2.2046226218, item);
                            break;
                        }
                        case "Spun silk": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 840.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Alloa)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 11520.00, 24.00,item);
                            break;
                        }
                        case "Wollen(American cut)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Dewsbury)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.00, 0.0625,item);
                            break;
                        }
                        case "Wollen(American run)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 0.0625,item);
                            break;
                        }
                        case "Wollen(Hawicks)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.625,item);
                            break;
                        }
                        case "Wollen(Galashiels)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.5,item);
                            break;
                        }
                        case "Wollen(West of England)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 320.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Yorkshire)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 256.00, 1.00,item);
                            break;
                        }
                        case "Worsted": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 560.00, 1.00,item);
                            break;
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(length.getText().toString().equals("")||weight.getText().toString().equals("")){
                    lvalue=0.0;
                    wvalue=0.0;
                    result.setText("0");
                }
                else{
                    try{
                        wvalue=Double.parseDouble(weight.getText().toString());
                        lvalue=Double.parseDouble(length.getText().toString());
                    }
                    catch (NumberFormatException e){
                        e.printStackTrace();
                    }
                    switch (sp3.getSelectedItem().toString()) {
                        case "Denier": {

                            DirectCount(wvalue, 9842.519685,lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Tex": {
                            DirectCount(wvalue, 1093.6132983,lvalue,sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Liner(jute)": {
                            DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());

                            break;
                        }
                        case "Silk": {
                            DirectCount(wvalue, 1000.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(Aberdeen)": {
                            DirectCount(wvalue, 14400.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Wollen(American grain)": {
                            DirectCount(wvalue, 20.00, lvalue,sp1.getSelectedItemPosition());
                            break;
                        }
                        case "Cotton(British)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 840.00, 1.00,item);
                            break;
                        }
                        case "Asbestos(American)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 1.00,item);
                            break;
                        }
                        case "Asbestos(British)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 50.00, 1.00,item);
                            break;
                        }
                        case "Cotton bump yarn": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.00, 0.0625,item);
                            break;
                        }
                        case "Cotton(Continental)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1093.6132983, 1.1023113109, item);
                            break;
                        }
                        case "Linen(wet-spun)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.00,item);
                            break;
                        }
                        case "Glass(U.S.A and U.K)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 1.00,item);
                            break;
                        }
                        case "Metric": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.0936132983, 2.2046226218, item);
                            break;
                        }
                        case "Spun silk": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 840.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Alloa)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 11520.00, 24.00,item);
                            break;
                        }
                        case "Wollen(American cut)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Dewsbury)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 1.00, 0.0625,item);
                            break;
                        }
                        case "Wollen(American run)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 100.00, 0.0625,item);
                            break;
                        }
                        case "Wollen(Hawicks)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.625,item);
                            break;
                        }
                        case "Wollen(Galashiels)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 300.00, 1.5,item);
                            break;
                        }
                        case "Wollen(West of England)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 320.00, 1.00,item);
                            break;
                        }
                        case "Wollen(Yorkshire)": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 256.00, 1.00,item);
                            break;
                        }
                        case "Worsted": {
                            InDirectCount(wvalue,sp2.getSelectedItemPosition(),
                                    lvalue,sp1.getSelectedItemPosition(), 560.00, 1.00,item);
                            break;
                        }
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    private void InDirectCount(double W, int wp, double L, int lp, double l, double w, String item) {

        double ans = (L*lengtharry[lp]*w) / (l*W*weightarry[wp]);
        String a= style.format(ans);
        result.setText(a);
    }
    private void DirectCount(double WEIGHT, double length, double LENGTH, int i) {

        double ans = (WEIGHT * length) /(LENGTH*lengtharry[i]);
        String value =style.format(ans);
        result.setText(value);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        if(mi.getItemId()==android.R.id.home){
            //Toast.makeText(getApplicationContext(),"BACK",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(CalculateCount.this,Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }
}
