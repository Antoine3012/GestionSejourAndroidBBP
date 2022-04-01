package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

public class PatientAdapter extends ArrayAdapter<Patient> {
    private final Context _context;
    private List<Patient> _patients;

    public PatientAdapter(@NonNull Context context, int resource, List<Patient> patients) {
        super(context, resource, patients
        );
        _context = context;
        _patients = patients;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item, parent, false);
        } else {
            convertView = (LinearLayout) convertView;
        }
        TextView viewTitle = (TextView) convertView.findViewById(R.id.title);
        viewTitle.setText(_patients.get(position).getTitle());
        viewTitle.setTag(_patients.get(position).getTitle());

        return convertView;
    }
}