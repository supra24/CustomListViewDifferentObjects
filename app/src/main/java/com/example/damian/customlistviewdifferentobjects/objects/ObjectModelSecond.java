package com.example.damian.customlistviewdifferentobjects.objects;

/**
 * Created by Damian on 2016-11-06.
 */

public class ObjectModelSecond extends ObjectParentModel {

    private int index;
    private int tv_lp;

    public ObjectModelSecond(int index){
        this.index = index;
    }

    @Override
    public int getTypeObject() {
        return 2;
    }

    @Override
    public int getObjectIndex() {
        return index;
    }

    public void setText(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public int getText() {
        return tv_lp;
    }
}
