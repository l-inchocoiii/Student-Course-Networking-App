package edu.vassar.cmpu203.schmoodleproto1.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.R;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentReccresultBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentReccresultBinding;


public class ReccResult extends Fragment implements IReccResult{

    ReccResult.Listener listener;
    String s;
    FragmentReccresultBinding binding;

    Profile profile;
    public ReccResult(Profile profile, String s, IReccResult.Listener listener) {
        this.listener = listener;
        this.s = s;
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
        binding = FragmentReccresultBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (s.compareTo("year") == 0) {
            String se = "";
            for (int i = 0; i < listener.cGetReccYear().list.size(); i++) {
                Button button = new Button(this.getContext());
                button.setText(listener.cGetReccYear().list.get(i).name);
                int finalI = i;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Profile sProf = listener.maSearchProfile(listener.cGetReccYear().list.get(finalI).name);
                        listener.toSearchResult(sProf);
                    }
                });
                binding.linear.addView(button);
                se += listener.cGetReccYear().list.get(i).name + "\n";
            }
        }

        if (s.compareTo("major") == 0) {
            String se = "";
            for (int i = 0; i < listener.cGetReccMajor().list.size(); i++) {
                Button button = new Button(this.getContext());
                button.setText(listener.cGetReccMajor().list.get(i).name);
                int finalI = i;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Profile sProf = listener.maSearchProfile(listener.cGetReccMajor().list.get(finalI).name);
                        listener.toSearchResult(sProf);
                    }
                });
                binding.linear.addView(button);
                se += listener.cGetReccMajor().list.get(i).name + "\n";
            }
        }

        if (s.compareTo("class") == 0) {
            String se = "";
            for (int i = 0; i < listener.cGetReccClasses().list.size(); i++) {
                Button button = new Button(this.getContext());
                button.setText(listener.cGetReccClasses().list.get(i).name);
                int finalI = i;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Profile sProf = listener.maSearchProfile(listener.cGetReccClasses().list.get(finalI).name);
                        listener.toSearchResult(sProf);
                    }
                });
                binding.linear.addView(button);
                se += listener.cGetReccClasses().list.get(i).name + "\n";
            }
        }

        binding.backgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toHomepage(listener.returnCurrProf());
            }
        });
    }
}