package com.example.finalexamandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Countries> placesList=new ArrayList<>();
    ArrayList<Countries> temList=new ArrayList<>();
    String country []={"Canada","USA","England"};
    public static Countries selected;
    public static double number;

    TextView cap,totPrice,numOfPersons;
    Spinner sp1;
    ListView list1;
    ImageView imageFlag;
    SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cap=findViewById(R.id.txvCapital1);
        totPrice=findViewById(R.id.txvTotalPrice);
        numOfPersons=findViewById(R.id.txvPeople);
        sp1=findViewById(R.id.spinner);
        list1=findViewById(R.id.list1);
        imageFlag=findViewById(R.id.imgViewFlag);
        seek=findViewById(R.id.seekBar);
        fillData();
        ArrayAdapter adpt1=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,country);
        sp1.setAdapter(adpt1);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillTemp(country[position]);
                list1.setAdapter(new PlacesAdapter(MainActivity.this,temList));
                imageFlag.setImageResource(temList.get(position).getFlag());
                cap.setText(temList.get(position).getCountryCapital());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected=temList.get(position);
            }
        });
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numOfPersons.setText(String.valueOf(seekBar.getProgress()));
                calculatePrice();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public static double pp=0.0;
    //a method to calculate the total price
    public void calculatePrice(){
        int quant=Integer.parseInt(numOfPersons.getText().toString());
        number=selected.getPrice()*quant;
        if(quant>=15) {
            pp=number-(number*0.05);
            totPrice.setText(String.valueOf(pp));
        }
        else if(quant<15){
            pp=number;
            totPrice.setText(String.valueOf(pp));
        }
    }


//a method to fill them temp arraylist
    public void fillTemp(String country){
        temList.clear();
        for(Countries place: placesList)
            if(place.getCountryName().equals(country))
                temList.add(place);
    }

    public  void fillData(){
        placesList.add(new Countries(country[0],"Ottawa","Niagara Falls",100,R.drawable.niagarafalls1,R.drawable.canada));
        placesList.add(new Countries(country[0],"Ottawa","CN Tower",30,R.drawable.cn,R.drawable.canada));
        placesList.add(new Countries(country[0],"Ottawa","The Butchart Gardens",30,R.drawable.butchart,R.drawable.canada));
        placesList.add(new Countries(country[0],"Ottawa","Notre-Dame Basilica",50,R.drawable.notre,R.drawable.canada));
        placesList.add(new Countries(country[1],"Washington","The Statue of Liberty",90,R.drawable.statue,R.drawable.usa));
        placesList.add(new Countries(country[1],"Washington","The White House",60,R.drawable.white,R.drawable.usa));
        placesList.add(new Countries(country[1],"Washington","Times Square",75,R.drawable.times,R.drawable.usa));
        placesList.add(new Countries(country[2],"London","Big Ben",30,R.drawable.big,R.drawable.england));
        placesList.add(new Countries(country[2],"London","Westminster Abbey",25,R.drawable.westminster,R.drawable.england));
        placesList.add(new Countries(country[2],"London","Hyde Park",15,R.drawable.hydepark,R.drawable.england));

    }
}