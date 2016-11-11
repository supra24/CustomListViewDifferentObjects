package com.example.damian.customlistviewdifferentobjects.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.damian.customlistviewdifferentobjects.objects.ObjectModelFirst;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectParentModel;
import com.example.damian.customlistviewdifferentobjects.R;
import com.example.damian.customlistviewdifferentobjects.staticsVolumes.StaticVolumesObjects;

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

    @Override
    public int getItemViewType(int position) {
        return objectParentModels.get(position).getTypeObject();
    }

    @Override
    public int getViewTypeCount() {
        return 1;
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

        final ListViewHolder listViewHolder;

        listViewHolder = new ListViewHolder();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (getItemViewType(position)) {
            case 1: {
                convertView = inflater.inflate(R.layout.custom_list_view_object_first, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
            case 2: {
                convertView = inflater.inflate(R.layout.custom_list_view_object_second, parent, false);
                convertView.setTag(listViewHolder);
            }
            break;
        }

        switch (getItemViewType(position)) {
            case 1: {

                listViewHolder.textViewlp = (TextView) convertView.findViewById(R.id.list_view_join_i_forward);
                listViewHolder.editalpha = (EditText) convertView.findViewById(R.id.list_view_join_alpha_forward);
                listViewHolder.edita = (EditText) convertView.findViewById(R.id.list_view_join_a_forward);
                listViewHolder.edittheta = (EditText) convertView.findViewById(R.id.list_view_join_theta_forward);
                listViewHolder.editd = (EditText) convertView.findViewById(R.id.list_view_join_d_forward);

                ObjectModelFirst objectModelFirst = (ObjectModelFirst) objectParentModels.get(position);

                listViewHolder.textViewlp.setText(String.valueOf(objectModelFirst.getTv_lp()));
                listViewHolder.editalpha.setText(String.valueOf(objectModelFirst.getEt_alpha()));
                listViewHolder.edita.setText(String.valueOf(objectModelFirst.getEt_a()));
                listViewHolder.edittheta.setText(String.valueOf(objectModelFirst.getEt_theta()));
                listViewHolder.editd.setText(String.valueOf(objectModelFirst.getEt_d()));

                TextView.OnEditorActionListener onEditorActionListener = new TextView.OnEditorActionListener() {

                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                        ObjectModelFirst editingObjectModelFirst1 = new ObjectModelFirst(position);
                        editingObjectModelFirst1.setTv_lp(position);
                        editingObjectModelFirst1.setEt_alpha(Integer.parseInt(listViewHolder.editalpha.getText().toString()));
                        editingObjectModelFirst1.setEt_a(Integer.parseInt(listViewHolder.edita.getText().toString()));
                        editingObjectModelFirst1.setEt_theta(Integer.parseInt(listViewHolder.edittheta.getText().toString()));
                        editingObjectModelFirst1.setEt_d(Integer.parseInt(listViewHolder.editd.getText().toString()));

                        StaticVolumesObjects.setOneModel(editingObjectModelFirst1);
                        return false;
                    }
                };

                listViewHolder.editalpha.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.edita.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.edittheta.setOnEditorActionListener(onEditorActionListener);
                listViewHolder.editd.setOnEditorActionListener(onEditorActionListener);
            }
            break;
            case 2: {

                listViewHolder.textViewLayoutSecond = (TextView) convertView.findViewById(R.id.text_view_layout_second);

            }
            break;
        }
        return convertView;
    }
}

