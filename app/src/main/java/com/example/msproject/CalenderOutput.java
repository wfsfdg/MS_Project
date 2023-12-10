package com.example.msproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.LocalDateTime;


public class CalenderOutput extends AppCompatActivity {
    public int selectedYear;
    public int selectedMonth;
    public int selectedDayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_output);
        Button button = findViewById(R.id.nextButton2);
        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedYear = year;
                selectedMonth = month;
                selectedDayOfMonth = dayOfMonth;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                int ThisYear= currentDateTime.getYear();
                int ThisMonth=currentDateTime.getMonthValue();
                int Today=currentDateTime.getDayOfMonth();
                if (selectedYear == 0 || selectedMonth == 0 || selectedDayOfMonth == 0 ) {
                    // 날짜가 선택되지 않은 경우 현재 시간을 기본값으로 사용
                    if (selectedYear == 0) selectedYear = ThisYear;
                    if (selectedMonth == 0) selectedMonth = ThisMonth-1;
                    if (selectedDayOfMonth == 0) selectedDayOfMonth = Today;}
                LocalDateTime selectedDateTime = LocalDateTime.of(selectedYear, selectedMonth + 1,
                        selectedDayOfMonth, 0, 0);
                if (selectedDateTime.isAfter(currentDateTime)) {
                    Toast.makeText(CalenderOutput.this, "정확한 시간을 선택하세요", Toast.LENGTH_SHORT).show();
                }//미래의 시간을 선택하면 발생
               else{
                    Intent intent = new Intent(CalenderOutput.this, dataOutput.class);
                    intent.putExtra("year", selectedYear);
                    intent.putExtra("month", selectedMonth);
                    intent.putExtra("dayOfMonth", selectedDayOfMonth);

                    startActivity(intent);}

            }
        });
    }



}