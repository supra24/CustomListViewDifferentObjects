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

    public static void addJoin(int typeObject) {
        ObjectParentModel objectParentModel = null;

        if (objectParentModels.isEmpty()) {
            if (typeObject == 1) {
                objectParentModel = new ObjectModelFirst(0);
            } else if (typeObject == 2) {
                objectParentModel = new ObjectModelSecond(0);
            }
        } else {
            if (typeObject == 1) {
                objectParentModel = new ObjectModelFirst(objectParentModels.get(objectParentModels.size() - 1).getObjectIndex() + 1);
            } else if (typeObject == 2) {
                objectParentModel = new ObjectModelSecond(objectParentModels.get(objectParentModels.size() - 1).getObjectIndex() + 1);
            }
        }

        objectParentModels.add(objectParentModel);
    }

    public static void setOneModel(ObjectModelFirst oneModel) {

        objectParentModels.remove(oneModel.getObjectIndex());
        objectParentModels.add(oneModel.getObjectIndex(), oneModel);
    }

    public static void setOneModel(ObjectModelSecond oneModel) {

        objectParentModels.add(oneModel.getObjectIndex(), oneModel);
    }
}
