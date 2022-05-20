package edu.vassar.cmpu203.schmoodleproto1.View;
import edu.vassar.cmpu203.schmoodleproto1.Model.*;

public interface IHomepageFragment {
    interface Listener {

        String showEvents(Profile p);
        void toCreateNewEvent();
        void logout();
        Profile maSearchProfile(String s);
        void toSearchResult(Profile p);
        void toEditProfile(Profile p);
        String showClasses(Profile p);
        void toFilters();
        ProfileDatabase returnPD();
        }

    }
