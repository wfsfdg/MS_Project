package com.example.msproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.LocalDateTime;

public class CalenderInput extends AppCompatActivity {
    private int selectedYear;
    private int selectedMonth;
    private int selectedDayOfMonth;
    private int selectedHour;
    private int selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_input);
        Button button = findViewById(R.id.nextButton);
        CalendarView calendarView = findViewById(R.id.calendarView);
        TimePicker timePicker = findViewById(R.id.timePicker);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectedYear = year;
                selectedMonth = month;
                selectedDayOfMonth = dayOfMonth;
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                selectedHour = hourOfDay;
                selectedMinute = minute;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalDateTime currentDateTime = LocalDateTime.now();
                int ThisYear= currentDateTime.getYear();
                int ThisMonth=currentDateTime.getMonthValue();
                int Today=currentDateTime.getDayOfMonth();
                if (selectedYear == 0 || selectedMonth == 0 || selectedDayOfMonth == 0 ||
                        selectedHour == 0 || selectedMinute == 0) {
                    // 날짜가 선택되지 않은 경우 현재 시간을 기본값으로 사용
                    if (selectedYear == 0) selectedYear = ThisYear;
                    if (selectedMonth == 0) selectedMonth = ThisMonth-1;
                    if (selectedDayOfMonth == 0) selectedDayOfMonth = Today;
                    if (selectedHour == 0) selectedHour = currentDateTime.getHour();
                    if (selectedMinute == 0) selectedMinute = 0;
                }
                LocalDateTime selectedDateTime = LocalDateTime.of(selectedYear, selectedMonth + 1,
                        selectedDayOfMonth, selectedHour, selectedMinute);

                if (selectedDateTime.isAfter(currentDateTime)) {
                    Toast.makeText(CalenderInput.this, "정확한 시간을 선택하세요", Toast.LENGTH_SHORT).show();
                }//미래의 시간을 선택하면 발생
                else
                {

                    Intent intent = new Intent(CalenderInput.this, dataInput.class);
                    intent.putExtra("year", selectedYear);
                    intent.putExtra("month", selectedMonth);
                    intent.putExtra("dayOfMonth", selectedDayOfMonth);
                    intent.putExtra("hour", selectedHour);
                    intent.putExtra("minute", selectedMinute);
                    startActivity(intent);
                }
            }
        });


    }
}