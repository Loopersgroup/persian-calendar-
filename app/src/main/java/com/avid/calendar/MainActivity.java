package com.avid.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;

import com.kasra.picker.customviews.DateRangeCalendarView;
import com.kasra.picker.dialog.DatePickerDialog;
import com.kasra.picker.dialog.TimePickerDialog;
import com.kasra.picker.utils.PersianCalendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton button = findViewById(R.id.my_btn);
        AppCompatEditText dateTxt = findViewById(R.id.date_txt);
        AppCompatEditText TimeTxt = findViewById(R.id.time_txt);
        AppCompatButton timeBtn = findViewById(R.id.time_btn);
        button.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = null;
                datePickerDialog = new DatePickerDialog(MainActivity.this);
                datePickerDialog.setSelectionMode(DateRangeCalendarView.SelectionMode.Range, DateRangeCalendarView.HolidayMode.Disable);

                datePickerDialog.setCanceledOnTouchOutside(true);
                datePickerDialog.setOnRangeDateSelectedListener(new DatePickerDialog.OnRangeDateSelectedListener() {
                    @Override
                    public void onRangeDateSelected(PersianCalendar startDate, PersianCalendar endDate) {
//                        dateTxt.setText(startDate.getPersianShortDate());
                    }
                });

                datePickerDialog.showDialog();



        });
        timeBtn.setOnClickListener(v -> {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.TimePickerCallback() {
                @Override
                public void onTimeSelected(int hours, int mins) {
//                    TimeTxt.setText(String.valueOf(hours)+" : "+String.valueOf(mins));
                }

                @Override
                public void onCancel() {

                }
            });

            timePickerDialog.showDialog();
        });

    }
}