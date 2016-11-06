package com.example.damian.customlistviewdifferentobjects.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.damian.customlistviewdifferentobjects.fragments.FragmentCustomListView;
import com.example.damian.customlistviewdifferentobjects.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Damian on 2016-11-06.
 */

public class ActivityListView extends AppCompatActivity {

    @BindView(R.id.floating_action_button_forward_add)
    FloatingActionButton floatingActionButton;

    private boolean doubleBackToExitPressedOnce = false;
    private static int CLOSE_APP_ON_BACK = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_kinematics_simple, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        FragmentCustomListView fragmentById = (FragmentCustomListView) getSupportFragmentManager().findFragmentById(R.id.custom_join_list_view_kinematics_forward);

        if (fragmentById != null) {

            switch (item.getItemId()) {

                case R.id.id_add_first:
                    fragmentById.addObjectJoin(1);
                    break;
                case R.id.id_add_second:
                    fragmentById.addObjectJoin(2);
                    break;
                case R.id.id_undo:
                    fragmentById.undoObject();
                    break;
                default:
                    return true;
            }
        } else {
            Toast.makeText(this, "Error Sending Message", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @OnClick(R.id.floating_action_button_forward_add)
    public void OnClickFloatingActionButtonAdd() {

        registerForContextMenu(floatingActionButton);
        openContextMenu(floatingActionButton);
    }
}
