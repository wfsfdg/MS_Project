package com.example.msproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Analyze extends AppCompatActivity {
    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String formattedDate = dateFormat.format(currentDate);
    long longDate = Long.parseLong(formattedDate);

    public int breakfastexpense=0;
    public int lunchexpense=0;
    public int dinnerexpense=0;
    public int drinkexpense=0;

    public int totalkcal=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        TextView dateTextView = findViewById(R.id.currentDate); // 여기에 텍스트뷰의 ID를 넣으세요

        // 현재 날짜 가져오기
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.getDefault());
        // 30일 전 날짜 계산
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        Date startDate = calendar.getTime();

        // 날짜 포맷 지정 (yyyy년 MM월 dd일)

        String formattedDate = sdf.format(startDate);
        String todayDateString = dateFormat.format(currentDate);
        String todaylongstring=sdf.format(currentDate);
        long before30days=Long.parseLong(formattedDate)*10000;
        long today=Long.parseLong(todaylongstring)*10000;
        // 텍스트뷰에 날짜 표시
        String displayText = todayDateString + "\n이전 30일간 식사 분석";
        dateTextView.setText(displayText);

        for (long i=before30days;i<=today;i+=10000)
        {
            for(long j=0;j<1200;j++)
            {
                int price = SharedPreference.getMealPrice(Analyze.this, String.valueOf(i+j), 0);
                int drinkprice=SharedPreference.getDrinkPrice(Analyze.this,String.valueOf(i+j),0);
                int kcal=SharedPreference.getMealKcal(Analyze.this,String.valueOf(i+j),0);
                int drinkkcal=SharedPreference.getDrinkKcal(Analyze.this,String.valueOf(i+j),0);
                breakfastexpense+=price;
                drinkexpense+=drinkprice;
                totalkcal+=kcal;
                totalkcal+=drinkkcal;
            }
            for(long k=1201;k<1600;k++)
            {
                int price = SharedPreference.getMealPrice(Analyze.this, String.valueOf(i+k), 0);
                int drinkprice=SharedPreference.getDrinkPrice(Analyze.this,String.valueOf(i+k),0);
                int kcal=SharedPreference.getMealKcal(Analyze.this,String.valueOf(i+k),0);
                int drinkkcal=SharedPreference.getDrinkKcal(Analyze.this,String.valueOf(i+k),0);
                lunchexpense+=price;
                drinkexpense+=drinkprice;
                totalkcal+=kcal;
                totalkcal+=drinkkcal;
            }
            for(long l=1601;l<2401;l++)
            {
                int price = SharedPreference.getMealPrice(Analyze.this, String.valueOf(i+l), 0);
                int drinkprice=SharedPreference.getDrinkPrice(Analyze.this,String.valueOf(i+l),0);
                int kcal=SharedPreference.getMealKcal(Analyze.this,String.valueOf(i+l),0);
                int drinkkcal=SharedPreference.getDrinkKcal(Analyze.this,String.valueOf(i+l),0);
                dinnerexpense+=price;
                drinkexpense+=drinkprice;
                totalkcal+=kcal;
                totalkcal+=drinkkcal;
            }
        }
        TextView totalKcalTextView = findViewById(R.id.TotalKcal);
        TextView dinnerExpenseTextView = findViewById(R.id.dinneroutput);
        TextView lunchExpenseTextView = findViewById(R.id.lunchoutput);
        TextView breakfastExpenseTextView = findViewById(R.id.breakoutput);
        TextView drinkExpenseTextView = findViewById(R.id.drinkoutput);

        totalKcalTextView.setText("총 칼로리: " + totalkcal + " kcal");
        dinnerExpenseTextView.setText(dinnerexpense + " 원");
        lunchExpenseTextView.setText(lunchexpense + " 원");
        breakfastExpenseTextView.setText(breakfastexpense + " 원");
        drinkExpenseTextView.setText(drinkexpense + " 원");
        Log.d("dd",String.valueOf(totalkcal));
        Log.d("dd",String.valueOf(before30days));

    }
}
