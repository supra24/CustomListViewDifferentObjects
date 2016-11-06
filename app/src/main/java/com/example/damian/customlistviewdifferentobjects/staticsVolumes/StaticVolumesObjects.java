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

//    public static void setOneJoinModel(ObjectParentModel objectParentModel) {
//
//        objectParentModels.get(objectParentModel.getTv_lp()).setEt_alpha(objectParentModel.getEt_alpha());
//        objectParentModels.get(objectParentModel.getTv_lp()).setEt_a(objectParentModel.getEt_a());
//        objectParentModels.get(objectParentModel.getTv_lp()).setEt_theta(objectParentModel.getEt_theta());
//        objectParentModels.get(objectParentModel.getTv_lp()).setEt_d(objectParentModel.getEt_d());
//    }

    public static void addJoin(int i) {
        ObjectParentModel objectParentModel = null;

        if (i == 1) {
            objectParentModel = new ObjectModelFirst();
        } else if (i == 2) {
            objectParentModel = new ObjectModelSecond();
        }

//        if (objectParentModels.isEmpty())
//            objectParentModel.setTv_lp(1);
//        else
//            objectParentModel.setTv_lp(objectParentModels.get(objectParentModels.size() - 1).getTv_lp() + 1);

        objectParentModels.add(objectParentModel);
    }
}
