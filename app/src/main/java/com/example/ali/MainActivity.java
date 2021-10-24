package com.example.ali;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner meat,veg,dessert;
    Button cal;
    TextView res;
    String[] data={"Chicken","Beef","Mutton","Fish"};
    ArrayList<String> result=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meat=findViewById(R.id.meat);
        veg=findViewById(R.id.veg_list);
        dessert=findViewById(R.id.desert_list);
        cal=findViewById(R.id.calculate);
        res=findViewById(R.id.result_score);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.meat, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.vegeatable, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.dessert, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        meat.setAdapter(adapter);
        veg.setAdapter(adapter1);
        dessert.setAdapter(adapter2);

        meat.setOnItemSelectedListener(this);
        veg.setOnItemSelectedListener(this);
        dessert.setOnItemSelectedListener(this);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double t =0;
                int min=200;
                int max=400;
                for(int i=0;i<result.size();i++){
                    t=t+(Math.random()*(max-min+1)+min);
                }
                res.setText(String.valueOf(t));
                result.clear();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int i = parent.getId();
        String text;
        switch (i) {
            case R.id.meat:
                text = parent.getItemAtPosition(position).toString();
                result.add(text);
            case R.id.veg_list:
                text = parent.getItemAtPosition(position).toString();
                result.add(text);
            case R.id.desert_list:
                text = parent.getItemAtPosition(position).toString();
                result.add(text);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }



}