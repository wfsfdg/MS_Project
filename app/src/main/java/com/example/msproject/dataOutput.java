package com.example.msproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class dataOutput extends AppCompatActivity {
    public int selectedYear;
    public int selectedMonth;
    public int selectedDay;
    ListView listView;
    ListItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_output);

        Intent getintent = getIntent();
        if (getintent != null) {
            selectedYear = getintent.getIntExtra("year", 0);
            selectedMonth = getintent.getIntExtra("month", 0);
            selectedDay = getintent.getIntExtra("dayOfMonth", 0);

            TextView textView = findViewById(R.id.textView2);

            LocalDateTime selectedDateTime = LocalDateTime.of(selectedYear, selectedMonth + 1,
                    selectedDay, 0, 0);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
            String formattedDateTime = selectedDateTime.format(formatter);
            textView.setText(formattedDateTime);

        }

        adapter=new ListItemAdapter();
        listView=findViewById(R.id.listview);
        List<String> updatedData = new ArrayList<>();
        List<byte[]> imageData = new ArrayList<>();

        for(int i=0;i<24;i++)
        {
            for(int j=0;j<61;j++) {
                long mkeyvalue = selectedYear * 100000000L + (selectedMonth+1) * 1000000L + selectedDay * 10000L + i * 100L + j;
                String key = Long.toString(mkeyvalue);
                int hour = SharedPreference.getMealHour(dataOutput.this, key, 0);
                int minute = SharedPreference.getMealMinute(dataOutput.this, key, 0);
                int price = SharedPreference.getMealPrice(dataOutput.this, key, 0);
                int kcal = SharedPreference.getMealKcal(dataOutput.this, key, 0);
                String name = SharedPreference.getMealName(dataOutput.this, key, "");
                String loc = SharedPreference.getMealLoc(dataOutput.this, key, "");
                String review = SharedPreference.getMealReview(dataOutput.this, key, "");
                byte[] image=SharedPreference.getMealImage(dataOutput.this,key,new byte[0]);
                if (kcal!=0) {
                    String addData1 = String.format("%02d:%02d %s %s 가격: %d원 열량: %d kcal\n평가 : %s", hour, minute, loc, name, price, kcal,review);
                    adapter.addItem(new ListItem(image,addData1));
                    Log.d("debug",review);
                }
            }


        }
        for(int k=0;k<24;k++)
        {
            for(int l=0;l<61;l++) {
                long dkeyvalue = selectedYear * 100000000L + (selectedMonth+1) * 1000000L + selectedDay * 10000L + k * 100L + l;
                String drinkkey = Long.toString(dkeyvalue);
                int hour = SharedPreference.getDrinkHour(dataOutput.this, drinkkey, 0);
                int minute = SharedPreference.getDrinkMinute(dataOutput.this, drinkkey, 0);
                int price = SharedPreference.getDrinkPrice(dataOutput.this, drinkkey, 0);
                int kcal = SharedPreference.getDrinkKcal(dataOutput.this, drinkkey, 0);
                String name = SharedPreference.getDrinkName(dataOutput.this, drinkkey, "");
                String loc = SharedPreference.getDrinkLoc(dataOutput.this, drinkkey, "");
                String review = SharedPreference.getDrinkReview(dataOutput.this, drinkkey, "");
                byte[] image=SharedPreference.getDrinkImage(dataOutput.this,drinkkey,new byte[0]);
                if(kcal!=0) {
                    String addData1 = String.format("%02d:%02d %s %s 가격: %d원 열량: %d kcal\n평가 : %s", hour, minute, loc, name, price, kcal,review);
                    adapter.addItem(new ListItem(image,addData1));
                }
            }

        }
        listView.setAdapter(adapter);

    }

}
