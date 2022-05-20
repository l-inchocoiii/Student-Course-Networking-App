package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.*;

public interface IReccResult {

    interface Listener {
        void toHomepage(Profile p);
        Profile returnCurrProf();
        ProfileDatabase cGetReccYear();
        ProfileDatabase cGetReccMajor();
        ProfileDatabase cGetReccClasses();
        ProfileDatabase returnPD();
        void toSearchResult(Profile p);
        Profile maSearchProfile(String s);
    }

}
