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

import edu.vassar.cmpu203.schmoodleproto1.Model.Event;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.R;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentCreatenewprofileBinding;
import edu.vassar.cmpu203.schmoodleproto1.databinding.FragmentMakeeventBinding;


public class MakeEvent extends Fragment implements IMakeEvent {

    MakeEvent.Listener listener;
    FragmentMakeeventBinding binding;

    public MakeEvent (IMakeEvent.Listener listener) {
        this.listener = listener;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMakeeventBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable newtitleEditable = MakeEvent.this.binding.newtitle.getText();
                String newtitley = newtitleEditable.toString();
                Editable newcontentsEditable = MakeEvent.this.binding.newcontents.getText();
                String newcontentsy = newcontentsEditable.toString();

                Event eventc = listener.cMakeNewEvent(newtitley, newcontentsy);

                Snackbar.make(view, "Posted!", Snackbar.LENGTH_LONG).show();

                //Snackbar.make(view, "Made!", Snackbar.LENGTH_LONG).show();
            }
                                        }
        );

        binding.backe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.toHomepage(listener.returnCurrProf());
            }
        });
    }
}