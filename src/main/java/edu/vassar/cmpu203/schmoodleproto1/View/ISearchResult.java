package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.*;

public interface ISearchResult {

    interface Listener {
        void toHomepage(Profile p);
        Profile returnCurrProf();
        String showEvents(Profile p);
    }

}
