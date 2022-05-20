package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.Model.ProfileDatabase;

public interface IFilters {

    interface Listener {
        void toHomepage(Profile p);
        Profile returnCurrProf();
        void toReccRes(String s);

    }
}
