package com.project.attendanceforstudent.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.attendanceforstudent.Interface.CardClickListener;
import com.project.attendanceforstudent.Model.CheckingCard;
import com.project.attendanceforstudent.Networking.Attendance;
import com.project.attendanceforstudent.R;

import java.util.ArrayList;
import java.util.Comparator;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckingCardDataAdapter extends RecyclerView.Adapter<CheckingCardDataAdapter.ViewHolder>{
    private ArrayList<Attendance> checkingList;
    private Context context;

    public CheckingCardDataAdapter(Context context, ArrayList<Attendance> list) {
        this.context = context;
        this.checkingList = list;
    }

    @Override
    public CheckingCardDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.checking_card, viewGroup, false);
        return new CheckingCardDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckingCardDataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.week.setText("" + checkingList.get(i).getmScheduleCodeScheduleNumberOfDay());
        viewHolder.date.setText("Ngày " +checkingList.get(i).getmScheduleCodeScheduleDate());
        if (checkingList.get(i).getmAbsentStatus() == false)
        {
            viewHolder.is_absent.setVisibility(View.GONE);
            viewHolder.is_not_absent.setVisibility(View.VISIBLE);
        }
        else
        {
            viewHolder.is_not_absent.setVisibility(View.GONE);
            viewHolder.is_absent.setVisibility(View.VISIBLE);
        }
        
//        viewHolder.response_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                response();
//            }
//        });
    }

    private void response() {
    }

    @Override
    public int getItemCount() {
        return checkingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView week, date;
        LinearLayout is_absent, is_not_absent;
//        Button response_btn;
        CardClickListener cardClickListener;

        public ViewHolder(View view) {
            super(view);
            week = (TextView) view.findViewById(R.id.number_week_txt);
            date = (TextView) view.findViewById(R.id.date_txt);
            is_absent = (LinearLayout) view.findViewById(R.id.join_is_true);
            is_not_absent = (LinearLayout) view.findViewById(R.id.absent_is_true);
        }

    }

}
