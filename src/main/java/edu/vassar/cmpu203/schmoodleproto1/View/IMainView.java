package edu.vassar.cmpu203.schmoodleproto1.View;
import android.view.View;
import androidx.fragment.app.Fragment;

public interface IMainView {
        public View getRootView();
        public void displayFragment(Fragment fragment);
}

