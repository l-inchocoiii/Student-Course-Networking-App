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
import edu.vassar.cmpu203.schmoodleproto1.databinding.*;

public class SearchResult extends Fragment implements ISearchResult {

    SearchResult.Listener listener;
    FragmentSearchResultBinding binding;

    Profile profile;
    public SearchResult(Profile profile, ISearchResult.Listener listener) {
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
        binding = FragmentSearchResultBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.pName.setText(SearchResult.this.profile.name);
        String s = String.valueOf(SearchResult.this.profile.year);
        binding.pYear.setText(s);
        binding.pMajor.setText(SearchResult.this.profile.major);

        binding.events.setText(listener.showEvents(profile));

        binding.backsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toHomepage(listener.returnCurrProf());
            }
        });
    }
}