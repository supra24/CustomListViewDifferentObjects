package com.example.damian.customlistviewdifferentobjects.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.damian.customlistviewdifferentobjects.objects.ObjectModelFirst;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectModelSecond;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectParentModel;
import com.example.damian.customlistviewdifferentobjects.R;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class ListViewAdapter extends ArrayAdapter<ObjectParentModel> {


    private Context context;
    private ArrayList<ObjectParentModel> objectParentModels;
    private LayoutInflater inflater;
    private LinearLayout linearLayoutFirst, linearLayoutSecond;

    public ListViewAdapter(Context context, ArrayList<ObjectParentModel> items) {
        super(context, 0, items);

        this.context = context;
        this.objectParentModels = items;

    }

    @Override
    public int getCount() {
        if (objectParentModels == null)
            return 0;
        else
            return objectParentModels.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ListViewHolder {

        TextView textViewlp;
        EditText editalpha;
        EditText edita;
        EditText edittheta;
        EditText editd;

        TextView textViewLayoutSecond;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        switch (objectParentModels.get(position).getTypeObject()) {
            case 1: {

                final ListViewHolder listViewHolder;

                ObjectModelFirst objectModelFirst = (ObjectModelFirst) objectParentModels.get(position);

                listViewHolder = new ListViewHolder();
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custom_list_view_object_first, null);

                listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_forward);
                listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha_forward);
                listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a_forward);
                listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta_forward);
                listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d_forward);

                convertView.setTag(listViewHolder);

                listViewHolder.textViewlp.setText(String.valueOf(objectModelFirst.getTv_lp()));
                listViewHolder.editalpha.setText(String.valueOf(objectModelFirst.getEt_alpha()));
                listViewHolder.edita.setText(String.valueOf(objectModelFirst.getEt_a()));
                listViewHolder.edittheta.setText(String.valueOf(objectModelFirst.getEt_theta()));
                listViewHolder.editd.setText(String.valueOf(objectModelFirst.getEt_d()));
            }
            break;
            case 2: {
                final ListViewHolder listViewHolder;

                ObjectModelSecond objectModelSecond = (ObjectModelSecond) objectParentModels.get(position);

                listViewHolder = new ListViewHolder();
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.custom_list_view_object_second, null);

                listViewHolder.textViewLayoutSecond = (TextView) convertView.findViewById(R.id.text_view_layout_second);

                convertView.setTag(listViewHolder);
            }
            break;
        }

        linearLayoutFirst = (LinearLayout) convertView.findViewById(R.id.id_linear_layout_first);
        linearLayoutSecond = (LinearLayout) convertView.findViewById(R.id.id_linear_layout_second);

        return convertView;
    }
}

