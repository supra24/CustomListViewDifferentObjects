package com.example.damian.customlistviewdifferentobjects.objects;

/**
 * Created by Damian on 2016-11-06.
 */

public class ObjectModelSecond extends ObjectParentModel {

    private int tv_lp;

    @Override
    public int getTypeObject() {
        return 2;
    }

    public void setText(int tv_lp) {
        this.tv_lp = tv_lp;
    }

    public int getText() {
        return tv_lp;
    }
}
