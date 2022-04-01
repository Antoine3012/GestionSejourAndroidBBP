package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class SejourAdapter extends ArrayAdapter<Sejour> {
    private final Context _context;
    private List<Sejour> _sejours;

    public SejourAdapter(@NonNull Context context, int resource, List<Sejour> sejours) {
        super(context, resource, sejours);
        _context = context;
        _sejours = sejours;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView viewTitle = (TextView) convertView.findViewById(R.id.title);
        viewTitle.setText(_sejours.get(position).getId());
        viewTitle.setTag(_sejours.get(position).getId());

        return convertView;
    }
}
