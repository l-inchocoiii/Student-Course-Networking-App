package edu.vassar.cmpu203.schmoodleproto1.View;

import java.util.HashMap;

import edu.vassar.cmpu203.schmoodleproto1.Model.Class;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;

public interface IEditProfile {
    interface Listener {
        void changeName(Profile p, String s);
        void changePass(Profile p, String s);
        void changeYear(Profile p, int year);
        void changeMajor(Profile p, String s);
        void changeHM(Profile p, HashMap<String, Integer> hm);
        void toHomepage(Profile p);
        String showClasses(Profile p);
        Class cMakeNewClass(Profile p, String s);
    }
}
