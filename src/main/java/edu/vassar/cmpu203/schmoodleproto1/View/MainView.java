package edu.vassar.cmpu203.schmoodleproto1.View;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import edu.vassar.cmpu203.schmoodleproto1.databinding.MainBinding;

public class MainView {
    FragmentActivity activity;
    MainBinding binding;

    public MainView(FragmentActivity activity){
        //JASON DID THIS
        this.binding = MainBinding.inflate(activity.getLayoutInflater());
        this.activity = activity;

    }

    public View getRootView() {
        return this.binding.getRoot();
    }

    public void displayFragment(Fragment fragment, boolean allowBack) {
        FragmentManager fm = this.activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(this.binding.fragmentContainerView.getId(), fragment);

        if (allowBack) ft.addToBackStack(null);

        ft.commit();
    }


}
