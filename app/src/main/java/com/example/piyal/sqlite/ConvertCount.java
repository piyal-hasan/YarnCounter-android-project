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

public class ConvertCount extends AppCompatActivity {
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
    double[] tex={1.00,9.00,10.00,0.0290,0.0290,0.2822,4960.5465,9921.0930,31003.4155,590.5412,4960.5465,1653.5155,
            310.0342,1000.00,590.5412,496.0546,1033.4472,1653.5155,310.0342,31003.4155,2480.2732,2686.9627,7750.8539,1550.1708,1937.7135,885.8119};

    double[] dn={0.1111,1.0000,1.1111,0.0032,0.0032,0.0314,44644.9183,89289.8366,279030.7394,5314.8712,44644.9183,14881.6394,2790.3074,9000.0000,
            5314.8712,4464.4918,9301.0246,14881.6394,2790.3074,279030.7394,22322.4592,24182.6641,69757.6849,13951.5370,17439.4212,7972.3068};

    double[] Decitex={0.1000,0.9000,1.0000,0.0029,0.0029,0.0282,49605.4648,99210.9296,310034.1549,5905.4125,49605.4648,16535.1549,3100.3415,10000.00,5905.4125,
            4960.5465,10334.4718,16535.1549,3100.3415,310034.1549,24802.7324,26869.6268,77508.5387,15501.7077,19377.1347,8858.1187};

    double[] Linen_Jute={34.4500,310.0500,344.5000,1.0000,1.0000,9.7227,143.9926,287.9853,899.9540,17.1420,143.9926,47.9975,8.9995,29.0276,17.1420,14.3993,29.9985,
            47.9975,8.9995,899.9540,71.9963,77.9960,224.9885,44.9977,56.2471,25.7130};

    double[] Woollen_Aberdeen={34.4500,310.0500,344.5000,1.0000,1.0000,9.7227,143.9926,287.9853,899.9540,17.1420,143.9926,47.9975,8.9995,29.0276,17.1420,14.3993,29.9985,
            47.9975,8.9995,899.9540,71.9963,77.9960,224.9885,44.9977,56.2471,25.7130};

    double[] Woollen_US_grain={3.5432,31.8892,35.4325,0.1029,0.1029,1.0000,1400.0000,2800.0000,8750.0000,166.6667,1400.0000,466.6667,87.5000,282.2270,166.6667,140.0000,
            291.6667,466.6667,87.5000,8750.0000,700.0000,758.3333,2187.5000,437.5000,546.8750,250.0000};

    double[] Asbestos_American={4960.5465,44644.9183,49605.4648,143.9926,143.9926,1400.0000,1.0000,2.0000,6.2500,0.1190,1.0000,0.3333,0.0625,0.2016,0.1190,0.1000,0.2083,
            0.3333,0.0625,6.2500,0.5000,0.5417,1.5625,0.3125,0.3906,0.1786};

    double[] Asbestos_English={9921.0930,89289.8366,99210.9296,287.9853,287.9853,2800.0000,0.5000,1.0000,3.1250,0.0595,0.5000,0.1667,0.0313,0.1008,0.0595,0.0500,0.1042,
            0.1667,0.0313,3.1250,0.2500,0.2708,0.7813,0.1563,0.1953,0.0893};

    double[] Cotton_bump_yarn={31003.4155,279030.7394,310034.1549,899.9540,899.9540,8750.0000,0.1600,0.3200,1.0000,0.0190,0.1600,0.0533,0.0100,0.0323,0.0190,0.0160,
            0.0333,0.0533,0.0100,1.0000,0.0800,0.0867,0.2500,0.0500,0.0625,0.0286};

    double[] Cotton_English={590.5412,5314.8712,5905.4125,17.1420,17.1420,166.6667,8.4000,16.8000,52.5000,1.0000,8.4000,2.8,0.5250,1.6934,1.00,0.84,1.75,2.8,0.5250,
            52.5,4.2,4.55,13.1250,2.6250,3.2812,1.5};

    double[] Glass_UK_USA={4960.5465,44644.9183,49605.4648,143.9926,143.9926,1400.00,1.00,2.00,6.25,0.1190,1.00,0.3333,0.0625,0.2016,0.1190,0.10,0.2083,0.3333,0.0625,
            6.25,0.50,0.5417,1.5625,0.3125,0.3906,0.1786};
    double[] Linen_set_dry={1653.5155,14881.6394,16535.1549,47.9975,47.9975,466.6667,3.0,6.0,18.75,0.3571,3.00,1.0,0.1875,0.6048,0.3571,0.30,0.6250,1.0,0.1875,18.750,
            1.50,1.6250,4.6875,0.9375,1.1719,0.5357};

    double[] Wool_Run={310.0342,2790.3074,3100.3415,8.9995,8.9995,87.50,16.00,32.00,100.00,1.9048,16.00,5.3333,1.00,3.2255,1.9048,1.60,3.3333,5.3333,1.00,100.00,
            8.00,8.6667,25.00,5.00,6.25,2.8571};

    double[] Metric={1000.00,9000.00,10000.00,29.0276,29.0276,282.2270,4.9605,9.9211,31.0034,0.5905,4.9605,1.6535,0.3100,1.00,0.5905,0.4961,1.0334,1.6535,0.3100,
            31.0034,2.4803,2.6870,7.7509,1.5502,1.9377,0.8858};

    double[] Spun_silk={590.5412,5314.8712,5905.4125,17.1420,17.1420,166.6667,8.40,16.8,52.5,1.00,8.4,2.8,0.5250,1.6934,1.00,0.84,1.75,2.8,0.5250,52.50,4.20,4.55,
            13.1250,2.6250,3.2812,1.50};

    double[] Typp={496.0546,4464.4918,4960.5465,14.3993,14.3993,140.00,10.00,20.00,62.50,1.1905,10.00,3.3333,0.6250,2.0159,1.1905,1.00,2.0833,3.3333,0.6250,
            62.50,5.00,5.4167,15.6250,3.1250,3.9062,1.7857};

    double[] Woollen_Alloa={1033.4472,9301.0246,10334.4718,29.9985,29.9985,291.6667,4.80,9.6,30.00,0.5714,4.80,1.60,0.30,0.9676,0.5714,0.48,1.00,1.6,0.30,30.00,
            2.40,2.60,7.50,1.50,1.8750,0.8571};

    double[] Woollen_American_cut={1653.5155,14881.6394,16535.1549,47.9975,47.9975,466.6667,3.00,6.00,18.75,0.3571,3.00,1.00,0.1875,0.6048,0.30,0.6250,1.00,18.75,1.50,
            0.3571,1.6250,4.6875,0.9375,1.1719,0.5357};

    double[] Woollen_American_run={310.0342,2790.3074,3100.3415,8.9995,8.9995,87.50,16.00,32.00,100.00,1.9048,16.00,5.3333,1.00,3.2255,1.9048,1.60,3.3333,5.3333,1.00,100.00,
            8.00,8.6667,25.00,5.00,6.25,2.8571};

    double[] Woollen_Dewsbury={31003.4155,279030.7394,310034.1549,899.9540,899.9540,8750.0000,0.1600,0.32,1.00,0.0190,0.16,0.0533,0.01,0.0323,0.019,0.016,0.0333,0.0533,
            0.01,1.00,0.08,0.0867,0.25,0.05,0.0625,0.0286};

    double[] Woollen_Galashiels={2480.2732,22322.4592,24802.7324,71.9963,71.9963,700.00,2.00,4.00,12.50,0.2381,2.00,0.6667,0.1250,0.4032,0.2381,0.20,0.4167,0.6667,
            0.1250,12.50,1.00,1.0833,3.1250,0.6250,0.7812,0.3571};

    double[] Woollen_Hawick={2686.9627,24182.6641,26869.6268,77.9960,77.9960,758.3333,1.8462,3.6923,0.2198,1.8462,0.6154,0.1154,0.3722,0.2198,0.1846,0.3846,0.6154,
            0.1154,11.5385,0.9231,1.00,2.8846,0.5769,0.7212,0.3297};

    double[] Woollen_Irish={7750.8539,69757.6849,77508.5387,224.9885,224.9885,2187.50,0.64,1.28,4.00,0.0762,0.64,0.2133,0.04,0.1290,0.0762,0.0640,0.1333,0.2133,
            0.2133,0.04,4.00,0.32,0.3467,1.00,0.20,0.25,0.1143};

    double[] Woollen_West_England={1550.1708,13951.5370,15501.7077,44.9977,44.9977,437.50,3.20,6.40,20.00,0.3810,3.20,1.0667,0.20,0.6451,0.3810,0.32,0.6667,1.0667,
            0.20,20.00,1.60,1.7333,5.00,1.00,1.25,0.5714};

    double[] Woollen_Yorkshire={1937.7135,17439.4212,19377.1347,56.2471,546.8750,2.56,5.12,16.00,0.3048,2.56,0.8533,0.16,0.5161,0.3048,0.2560,0.5333,0.8533,0.16,16.00,
            1.28,1.3867,4.00,0.80,1.00,0.4571};

    double[] Woollen_Worsted={885.8119,7972.3068,8858.1187,25.7130,25.7130,250.00,5.6,11.20,35.00,0.6667,5.60,1.8667,0.35,1.1289,0.6667,0.56,1.1667,1.8667,0.35,35.00,
            2.80,3.0333,8.75,1.75,2.1875,1.00};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.convert_count);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("CountConverter");
        length_1=(EditText)findViewById(R.id.editText);
        length_2=(EditText)findViewById(R.id.editText2);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        refresh=(Button)findViewById(R.id.refresh);
        String[] unit={"Tex","Denier","Decitex","Linen, Hemp, Jute","Woollen(Aberdeen)","Woollen(US grain)","Asbestos(American)","Asbestos(English)","Cotton bump yarn","Cotton(English)",
                "Glass(UK & USA)","Linen(set or dry spun)","Wool Run","Metric","Spun silk","Typp","Woollen(Alloa)","Woollen(American cut)","Woollen(American run)","Woollen(Dewsbury)",
                "Woollen(Galashiels)","Woollen(Hawick)","Woollen(Irish)","Woollen(West of England)","Woollen(Yorkshire)","Woollen(Yorkshire)","Woollen(Worsted)"};
        adb1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,unit);
        adb1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp1.setAdapter(adb1);
        adb2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,unit);
        adb2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        sp2.setAdapter(adb2);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                //Toast.makeText(ConvertCount.this,String.valueOf(position)+parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).toString();
                try {

                    if (length_1.getText().toString().equals("")) {
                        value = 0.0;
                    } else {
                        value = Double.parseDouble(length_1.getText().toString());
                    }
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                switch (p){
                    case 0:{
                        convt=tex;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 1:{
                        convt=dn;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 2:{
                        convt=Decitex;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 3:{
                        convt=Linen_Jute;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 4:{
                        convt=Woollen_Aberdeen;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 5:{
                        convt=Woollen_US_grain;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 6:{
                        convt=Asbestos_American;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 7:{
                        convt=Asbestos_English;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 8:{
                        convt=Cotton_bump_yarn;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 9:{
                        convt=Cotton_English;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 10:{
                        convt=Glass_UK_USA;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 11:{
                        convt=Linen_set_dry;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 12:{
                        convt=Wool_Run;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 13:{
                        convt=Metric;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 14:{
                        convt=Spun_silk;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 15:{
                        convt=Typp;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 16:{
                        convt=Woollen_Alloa;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 17:{
                        convt=Woollen_American_cut;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 18:{
                        convt=Woollen_American_run;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 19:{
                        convt=Woollen_Dewsbury;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 20:{
                        convt=Woollen_Galashiels;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 21:{
                        convt=Woollen_Hawick;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 22:{
                        convt=Woollen_Irish;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 23:{
                        convt=Woollen_West_England;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 24:{
                        convt=Woollen_Yorkshire;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 25:{
                        convt=Woollen_Worsted;
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
                //Toast.makeText(LengthUnitConverter.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
                //Toast.makeText(ConvertCount.this,"Selectunit",Toast.LENGTH_SHORT).show();
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
