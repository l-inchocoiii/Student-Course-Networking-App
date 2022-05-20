package edu.vassar.cmpu203.schmoodleproto1.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentCreatenewprofileBinding;

public class Createnewprofile extends Fragment implements ICreatenewprofile{

    Createnewprofile.Listener listener;
    FragmentCreatenewprofileBinding binding;

    public Createnewprofile(ICreatenewprofile.Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreatenewprofileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable newnameEditable = Createnewprofile.this.binding.newname.getText();
                String newnamey = newnameEditable.toString();
                Editable newpassEditable = Createnewprofile.this.binding.newpass.getText();
                String newpassy = newpassEditable.toString();
                Editable newyearEditable = Createnewprofile.this.binding.newyear.getText();
                String s = newyearEditable.toString();
                int newyeary = Integer.parseInt(s);
                Editable newmajorEditable = Createnewprofile.this.binding.newmajor.getText();
                String newmajory = newmajorEditable.toString();

                listener.cMakeNewProfile(newnamey, newpassy, newyeary, newmajory);

                //TODO
                //make this interact with fucntions from controller to make a new profile
            }
                                      }
        );
        binding.backc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.logout();
                }
                                         }
        );
    }
}
