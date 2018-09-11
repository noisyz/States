package com.noisyz.states;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.noisyz.mvvmbase.ui.activity.abs.ContainerWithToolbarActivity;
import com.noisyz.mvvmbase.ui.activity.abs.FragmentContainerActivity;
import com.noisyz.states.modules.list.StatesListFragment;

public class MainActivity extends FragmentContainerActivity{

    @Override
    protected Fragment initFragment() {
        return StatesListFragment.newInstance();
    }

}
