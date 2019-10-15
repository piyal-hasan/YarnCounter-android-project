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

public class WeightConverter extends AppCompatActivity {

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
    double[] kg={1.00,1000.00,1000000.00,0.001,0.0009842073,0.0011023122,2.2046244202,35.273990723,5000.00,15432.4,564.382};

    double[] g={0.001,1.00,1000,0.000001,9.842073304E-7,0.0000011023,0.0022046244,0.0352739907,5.00,15.4324,0.564382};

    double[] mg={0.000001,0.001,1.00,9.999999999E-10,9.842073304E-10,1.10231221E-9,0.0000022046,0.000035274,0.005,0.0154324,0.000564382};

    double[] m_ton={1000.00,1000000.00,1000000000.00,1.00,0.9842073304,1.1023122101,2204.6244202,35273.990723,5000000.00,1.543e+7,564382.00,1.543e+7,564382.00};

    double[] l_ton={1016.04608,1016046.08,1016046080.00,1.01604608,1.00,1.12,2240.00,35840.00,5080230.4,15680000.00,573440};

    double[] s_ton={907.184,907184.00,907184000.00,0.907184,0.8928571429,1.00,2000.00,32000.00,4535920.00,14000000.00,512000.00};

    double[] lb={0.453592,453.592,453592.00,0.000453592,0.0004464286,0.0005,1.00,16.00,2267.96,7000.00,256.00};

    double[] oz={0.0283495,28.3495,28349.5,0.0000283495,0.0000279018,0.00003125,0.0625,1.00,141.7475,437.5,16.00};

    double[] cr={0.0002,0.2,200.00,2.E-7,1.96841466E-7,2.20462442E-7,0.0004409249,0.0070547981,1.00,3.08647167,0.112876678};

    double[] gr={6.4799e-5,0.06479900007048,64.7989,6.47989e-8,6.37755e-8,7.14286e-8,0.000142857,0.002285712,0.323995,1.00,0.0365713};

    double[] dr={0.0017718452,1.7718452,1771.8452,1.7719e-6,0.00000174386161,0.000001953125,0.00390625,0.0625,8.85922598,27.34375,1.00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weight_converter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("WeightUnitConverter");
        length_1=(EditText)findViewById(R.id.editText);
        length_2=(EditText)findViewById(R.id.editText2);
         sp1 = (Spinner) findViewById(R.id.spinner);
         sp2=(Spinner)findViewById(R.id.spinner2);
        refresh=(Button)findViewById(R.id.refresh);
        String unit[]={"kg","g","mg","matric ton","long ton","short ton","lb","oz","carat","gr","dr"};
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
                //Toast.makeText(WeightConverter.this,String.valueOf(position)+parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).toString();
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
                        convt=kg;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 1:{
                        convt=g;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 2:{
                        convt=mg;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 3:{
                        convt=m_ton;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 4:{
                        convt=l_ton;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 5:{
                        convt=s_ton;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 6:{
                        convt=lb;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 7:{
                        convt=oz;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 8:{
                        convt=cr;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 9:{
                        convt=gr;
                        convertmethod(value,position,length_1.getText().toString());
                        break;
                    }
                    case 10:{
                        convt=dr;
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
                //Toast.makeText(WeightConverter.this,"Selectunit",Toast.LENGTH_SHORT).show();
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
           // Toast.makeText(getApplicationContext(),"BACK",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getBaseContext(),Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        return true;
    }

}

