package edu.vassar.cmpu203.schmoodleproto1.View;

import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;

public interface ILoginPage {
    interface Listener {
        Profile cLoginValidator(String username, String password);

        void toCreateNewProf();
    }
}
