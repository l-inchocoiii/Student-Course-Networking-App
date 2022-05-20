package edu.vassar.cmpu203.schmoodleproto1.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.R;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentHomepageBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentLoginpageBinding;

public class HomepageFragment extends Fragment implements IHomepageFragment {

    HomepageFragment.Listener listener;
    FragmentHomepageBinding binding;

    Profile profile;

    public HomepageFragment(Profile profile, IHomepageFragment.Listener listener) {
        this.listener = listener;
        this.profile = profile;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //JASON DID THIS
        // Inflate the layout for this fragment
        binding = FragmentHomepageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.pName.setText(HomepageFragment.this.profile.name);
        String s = String.valueOf(HomepageFragment.this.profile.year);
        binding.pYear.setText(s);
        binding.pMajor.setText(HomepageFragment.this.profile.major);
        binding.pClasses.setText(listener.showClasses(profile));
        binding.events.setText(listener.showEvents(profile));

        //returns all key value pairs, where a null value result
        //means that the key is not present in the hashmap

//        String se = "";
//        for(int i = 0; i < listener.returnPD().list.size(); i++) {
//            se +=  listener.returnPD().list.get(i).name + " " + profile.weightChart.get(listener.returnPD().list.get(i).name) + "\n";
//        }
//        binding.viewHM.setText(se);


        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.logout();
                //TODO
                //implement back (logout) functionality
            }
        });

        binding.makeEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toCreateNewEvent();
                //TODO
                //implement back (logout) functionality
            }
        });

        binding.initializesearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable searchbarEditable = HomepageFragment.this.binding.searchbar.getText();
                String searchbary = searchbarEditable.toString();
                Profile result = listener.maSearchProfile(searchbary);
                if (result != null) {
                    listener.toSearchResult(result);
                } else {
                    Snackbar.make(view, "No such Profile Found", Snackbar.LENGTH_LONG).show();
                }
            }
            //TODO
            //implement back (logout) functionality
        });

        binding.editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toEditProfile(profile);
            }
        });

        binding.recc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toFilters();
            }
        });
    }
}