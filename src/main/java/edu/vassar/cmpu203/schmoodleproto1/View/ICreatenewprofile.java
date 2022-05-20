package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.*;

public interface ICreatenewprofile {
    /* interface for contract that listener to view events must fulfill. */
    interface Listener {

        Profile cMakeNewProfile(String pName, String pPass, int pYear, String pMajor);
        void logout();
    }
}
