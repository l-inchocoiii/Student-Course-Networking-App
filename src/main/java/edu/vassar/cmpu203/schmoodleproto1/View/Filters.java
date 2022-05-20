package edu.vassar.cmpu203.schmoodleproto1.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.R;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentFiltersBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentReccresultBinding;

public class Filters extends Fragment implements IFilters {

    Filters.Listener listener;
    FragmentFiltersBinding binding;

    Profile profile;
    public Filters(Profile profile, IFilters.Listener listener) {
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
        // Inflate the layout for this fragment
        binding = FragmentFiltersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.backf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toHomepage(listener.returnCurrProf());
            }
        });

        binding.yearf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toReccRes("year");
            }
        });

        binding.majorf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toReccRes("major");
            }
        });

        binding.classf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toReccRes("class");
            }
        });


    }
}