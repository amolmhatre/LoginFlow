package com.amol.testlogin;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by amolmhatre on 7/4/20
 */

public class PopTime extends DialogFragment implements View.OnClickListener{

    View view;
    TimePicker timePicker;
    DatePicker datePicker;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.pop_time,container, false);
        timePicker = (TimePicker)view.findViewById(R.id.timePicker);
        datePicker = (DatePicker)view.findViewById(R.id.datePicker);
        button = (Button)view.findViewById(R.id.buttonClock);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        this.dismiss();//Dismiss the activity
        String time = "Time "+timePicker.getHour()+":"+timePicker.getMinute()+
                "\nDate "+datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
        HomePage homePage = (HomePage)getActivity(); //Accessing activity and its methods using activity object
        homePage.setTime(time);
    }
}
