package edu.vassar.cmpu203.schmoodleproto1.View;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.schmoodleproto1.Model.Class;
import edu.vassar.cmpu203.schmoodleproto1.Model.Event;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentCreatenewprofileBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentEditprofileBinding;

public class EditProfile extends Fragment implements IEditProfile {
    EditProfile.Listener listener;
    FragmentEditprofileBinding binding;
    Profile profile;


    public EditProfile(Profile profile, IEditProfile.Listener listener) {
        this.profile = profile;
        this.listener = listener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentEditprofileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        EditProfile.this.binding.newname.setText("Larry King");
//        EditProfile.this.binding.newpass.setText("abc123");
//        EditProfile.this.binding.newyear.setText("1863");
//        EditProfile.this.binding.newmajor.setText("Communications");

        EditProfile.this.binding.newname.setText(this.profile.name);
        EditProfile.this.binding.newpass.setText((this.profile.pass));
        String yearAsString = String.valueOf(this.profile.year);
        EditProfile.this.binding.newyear.setText(yearAsString);
        EditProfile.this.binding.newmajor.setText(this.profile.major);
        EditProfile.this.binding.currClasses.setText(listener.showClasses(profile));
        binding.currClasses.setText(listener.showClasses(profile));


        binding.implement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Profile previous = profile;
                Editable newnameEditable = EditProfile.this.binding.newname.getText();
                String newnamey = newnameEditable.toString();
                Editable newpassEditable = EditProfile.this.binding.newpass.getText();
                String newpassy = newpassEditable.toString();
                Editable newyearEditable = EditProfile.this.binding.newyear.getText();
                String s = newyearEditable.toString();
                int newyeary = Integer.parseInt(s);
                Editable newmajorEditable = EditProfile.this.binding.newmajor.getText();
                String newmajory = newmajorEditable.toString();

                listener.changeName(profile, newnamey);
                listener.changePass(profile, newpassy);
                listener.changeYear(profile, newyeary);
                listener.changeMajor(profile, newmajory);

                listener.toHomepage(profile);
                Snackbar.make(view, "Changes Implemented", Snackbar.LENGTH_LONG).show();
            }
                                             }
        );

        binding.backep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toHomepage(profile);
            }
                                          }
        );

        binding.addClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable newclassEditable = EditProfile.this.binding.newclass.getText();
                String newclassy = newclassEditable.toString();
                listener.cMakeNewClass(profile, newclassy);
                listener.changeHM(profile, profile.weightChart);
                binding.currClasses.setText(listener.showClasses(profile));
                Snackbar.make(view, "Added!", Snackbar.LENGTH_LONG).show();
            }
                                            }
        );
    }
}