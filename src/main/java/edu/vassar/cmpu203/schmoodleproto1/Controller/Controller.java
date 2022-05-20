package edu.vassar.cmpu203.schmoodleproto1.Controller;

import java.util.HashMap;

import edu.vassar.cmpu203.schmoodleproto1.Model.*;
import edu.vassar.cmpu203.schmoodleproto1.Model.Class;

public class Controller {
    ProfileDatabase pd;
    DashboardDatabase dd;
    Profile curr;
    public Controller CC;

    public Controller(){
        this.pd = new ProfileDatabase();
        this.dd = new DashboardDatabase();
    }

    public Profile cSearchProfile(String s) {
        return pd.searchProfile(s);
    }

    public void cChangeName(Profile p, String newName) {
        p.changeName(p, newName);
    }

    public void cChangePass(Profile p, String newPass) {
        p.changePass(p, newPass);
    }

    public void cChangeYear(Profile p, int newYear) {
        p.changeYear(p, newYear);
    }

    public void cChangeMajor(Profile p, String newMajor) {
        p.changeMajor(p, newMajor);
    }

    public void cChangeHM(Profile p, HashMap<String, Integer> hm) {
        p.changeHM(p, hm);
    }

    public Profile cMakeNewProfile(ProfileDatabase pd, String pName, String pPass, int pYear, String pMajor){
        return pd.makeNewProfile(pd, pName, pPass, pYear,  pMajor);
    }


    public Event cMakeNewEvent(EventDatabase ed, String newTitle, String newContents) {
        return ed.makeNewEvent(ed, newTitle, newContents);
    }

    public Class cMakeNewClass(Profile p, String newclasstitle) {
        Class rclass = p.classDB.makeNewClass(p.classDB, newclasstitle);
        return rclass;
    }
}