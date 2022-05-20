package edu.vassar.cmpu203.schmoodleproto1.View;

import android.media.MediaRouter2;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import edu.vassar.cmpu203.schmoodleproto1.Controller.Controller;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.R;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentLoginpageBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.MainBinding;

public class LoginPage extends Fragment implements ILoginPage{

    LoginPage.Listener listener;
    FragmentLoginpageBinding binding;

    public LoginPage(ILoginPage.Listener listener){
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //JASON DID THIS
        // Inflate the layout for this fragment
        binding = FragmentLoginpageBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       //Snackbar.make(view, listener.returnProfName(), Snackbar.LENGTH_LONG).show();

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retrieve username value
                Editable usernameEditable = LoginPage.this.binding.username.getText();
                String usernamey = usernameEditable.toString();
                Editable passwordEditable = LoginPage.this.binding.password.getText();
                String passwordy = passwordEditable.toString();
                Profile user = listener.cLoginValidator(usernamey, passwordy);
                if (user == null) {
                    Snackbar.make(view, "Username or Password is incorrect", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //retrieve username value
                listener.toCreateNewProf();
            }
        });
        }

    }
