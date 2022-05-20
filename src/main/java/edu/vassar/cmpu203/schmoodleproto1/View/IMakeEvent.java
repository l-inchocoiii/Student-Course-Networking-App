package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.Event;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;

public interface IMakeEvent {

    interface Listener {

        void toHomepage(Profile p);
        Profile returnCurrProf();
        Event cMakeNewEvent(String newtitle, String newcontents);
        void logout();
    }
}
