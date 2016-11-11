package com.example.damian.customlistviewdifferentobjects.fragments;

import android.view.View;
import android.widget.ListView;

import com.example.damian.customlistviewdifferentobjects.R;
import com.example.damian.customlistviewdifferentobjects.staticsVolumes.StaticVolumesObjects;
import com.example.damian.customlistviewdifferentobjects.adapters.ListViewAdapter;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectParentModel;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-12.
 */

public class FragmentCustomListView extends FragmentParent {

    private ListViewAdapter listViewAdapter;
    private ArrayList<ObjectParentModel> objectParentModels = new ArrayList<>();

    public FragmentCustomListView() {
        layoutid = R.layout.fragment_join_list_view;
    }

    @Override
    public void init(View view) {

        objectParentModels = StaticVolumesObjects.getObjectParentModels();

        listViewAdapter = new ListViewAdapter(getContext(), objectParentModels);
        ListView listView = (ListView) view.findViewById(R.id.list_view_join);
        listView.setAdapter(listViewAdapter);
    }

    public void addObjectJoin(int typeObject) {

        StaticVolumesObjects.addJoin(typeObject);

        listViewAdapter.notifyDataSetInvalidated();
    }

    public boolean undoObject() {

        if (objectParentModels.isEmpty()) {
            return false;
        } else {
            objectParentModels.remove(objectParentModels.size() - 1);
            listViewAdapter.notifyDataSetInvalidated();
            return true;
        }
    }
}
