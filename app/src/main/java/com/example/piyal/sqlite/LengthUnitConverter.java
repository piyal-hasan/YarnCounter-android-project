package com.example.piyal.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class LengthUnitConverter extends AppCompatActivity {
    ArrayAdapter<String> adb1,adb2,adb3;
    Spinner sp1,sp2,sp3;
    EditText weight;
    TextView result;
    Button refresh;
    double W,L;
    String item="";
    EditText length_1,length_2;
    private double value=0.0;
    DecimalFormat style=new DecimalFormat("####,##,##,###.##############");
    double[] convt={0.0};
    final double[] km={1000.00,1.00,100000.00,1000000.00,1000000000.00,1000000000000.00,0.6213688756,1093.6132983,3280.839895,39370.07874};
    final double[] cm={0.01,0.00001,1.00,10.00,10000.00,10000000.00,0.0000062137,0.010936133,0.032808399,0.3937007874};
    final double[] metre={1.00,0.001,100.00,1000.00,1000000.00,1000000000.00,0.0006213689,1.0936132983,3.280839895,39.37007874};
    final double[] mm={0.001,0.000001,0.1,1.0,1000.0,1000000.0, 6.213688756E-7,0.0010936133,0.0032808399,0.0393700787};
    final double[] micro={0.000001,9.999999999E-10,0.0001,0.001,1.0,1000,6.213688756E-10,0.0000010936,0.0000032808,0.0000393701};
    final double[] nm={1.E-9,1.E-12,1.E-7,0.000001,0.001,1.0,6.213688756E-13,1.093613298E-9,3.280839895E-9,3.937007874E-8};
    final double[] Mile={1609.35,1.60935,160935.0,1609350.0,1609350000.0,1609350000000.0,1.0,1760.0065617,5280.019685,63360.23622};
    final double[] yard={0.9144,0.0009144,91.44,914.4,914400,914400000,0.0005681797,1.0,3.0,36.0};
    final double[] foot={0.3048,0.0003048,30.48,304.8,304800.0,304800000,0.0001893932,0.3333333333,1.0,12.0};
    final double[] inch={0.0254,0.0000254,2.54,25.4,25400.0,25400000.0,0.0000157828,0.0277777778,0.0833333333,1.0};
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.length_converter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("LengthConverter");
        refresh= (Button) findViewById(R.id.refresh);
        length_1= (EditText) findViewById(R.id.editText);
        length_2= (EditText) findViewById(R.id.editText2);
        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        final List<String> lenunit=new ArrayList<>();
        lenunit.add("m");
        lenunit.add("km");
        lenunit.add("cm");
        lenunit.add("mm");
        lenunit.add("µm");
        lenunit.add("nm");
        lenunit.add("mile");
        lenunit.add("yard");
        lenunit.add("foot");
        lenunit.add("inch");
        adb1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,lenunit);
        adb1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adb1);
        adb2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,lenunit);
        adb2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adb2);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                length_1.setText("");
                length_2.setText("");
                sp1.setSelection(0);
                sp2.setSelection(0);
            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int p, long id) {
                int position= sp2.getSelectedItemPosition();
                try {

                    if (length_1.getText().toString().equals("")) {
                        value = 0.0;
                    } else {
                        value = Double.parseDouble(length_1.getText().toString());
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                switch (parent.getSelectedItem().toString()){
                    case "m":{
                        convt=metre;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "cm":{
                        convt=cm;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "km":{
                        convt=km;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "µm":{
                        convt=micro;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "nm":{
                        convt=nm;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "mile":{
                        convt=Mile;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "yard":{
                        convt=yard;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "foot":{
                        convt=foot;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case "inch":{
                        convt=inch;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        length_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int position=sp2.getSelectedItemPosition();


                try {

                    if(length_1.getText().toString().equals(""))
                    {
                        value=0.0;
                    }
                    else {
                        value = Double.parseDouble(length_1.getText().toString());
                    }
                    convertmethod(value,position,length_1.getText().toString());

                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(length_1.getText().equals(""))
                {
                    length_1.setText("0");
                }
                try {
                    double value=0.0;
                    value = Double.parseDouble(length_1.getText().toString());

                        convertmethod(value,position,length_1.getText().toString());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void convertmethod(double value, int position,String status) {
        if(status.equals("")){
            length_2.setText("");
        }
        else {
            double ans = convt[position] * value;
            String v = style.format(ans);
            length_2.setText(v);
        }
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
