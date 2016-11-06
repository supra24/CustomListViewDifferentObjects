package com.example.damian.customlistviewdifferentobjects.staticsVolumes;

import com.example.damian.customlistviewdifferentobjects.objects.ObjectModelFirst;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectModelSecond;
import com.example.damian.customlistviewdifferentobjects.objects.ObjectParentModel;

import java.util.ArrayList;

/**
 * Created by Damian on 2016-10-14.
 */

public class StaticVolumesObjects {

    private static ArrayList<ObjectParentModel> objectParentModels = new ArrayList<>();

    public static ArrayList<ObjectParentModel> getObjectParentModels() {
        return objectParentModels;
    }

    public static void addJoin(int i) {
        ObjectParentModel objectParentModel = null;

        if (i == 1) {
            objectParentModel = new ObjectModelFirst();
        } else if (i == 2) {
            objectParentModel = new ObjectModelSecond();
        }

        objectParentModels.add(objectParentModel);
    }
}
