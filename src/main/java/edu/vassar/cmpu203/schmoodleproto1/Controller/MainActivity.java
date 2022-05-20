package edu.vassar.cmpu203.schmoodleproto1.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentReference;

import java.util.HashMap;

import edu.vassar.cmpu203.schmoodleproto1.Model.Class;
import edu.vassar.cmpu203.schmoodleproto1.Model.ClassDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.Dashboard;
import edu.vassar.cmpu203.schmoodleproto1.Model.DashboardDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.Event;
import edu.vassar.cmpu203.schmoodleproto1.Model.EventDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Model.Profile;
import edu.vassar.cmpu203.schmoodleproto1.Model.ProfileDatabase;
import edu.vassar.cmpu203.schmoodleproto1.Persistence.FirestoreFacade;
import edu.vassar.cmpu203.schmoodleproto1.Persistence.IPersistenceFacade;
import edu.vassar.cmpu203.schmoodleproto1.View.ILoginPage;
import edu.vassar.cmpu203.schmoodleproto1.View.IReccResult;
import edu.vassar.cmpu203.schmoodleproto1.View.MainView;
import edu.vassar.cmpu203.schmoodleproto1.View.*;

public class MainActivity extends AppCompatActivity implements ILoginPage.Listener, IHomepageFragment.Listener, ICreatenewprofile.Listener, IMakeEvent.Listener, ISearchResult.Listener, IEditProfile.Listener, IReccResult.Listener, IFilters.Listener {
    private DashboardDatabase dd;
    Profile curr;
    MainView mainView;
    Controller CC;

    private IPersistenceFacade persistenceFacade = new FirestoreFacade();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create main view and set content to be its root view

        this.CC = new Controller();

        // create main view and set content to be its root view
        this.mainView = new MainView(this);
        setContentView(this.mainView.getRootView());

        // display the add items fragment
        this.mainView.displayFragment(new LoginPage(this), true);

        returnPD();
    }

    @Override
    public Profile cLoginValidator(String s, String sp) {
        CC.pd = returnPD();
        curr = CC.pd.loginValidator(s, sp);
        if (curr != null) {
            this.mainView.displayFragment(new HomepageFragment(curr, this), true);
        }
        return curr;
    }
    public Profile maSearchProfile(String s) {
        Profile sCurr = CC.cSearchProfile(s);
        return sCurr;
    }

    public void toSearchResult(Profile p) {
            this.mainView.displayFragment(new SearchResult(p,  this), true);
    }

    public void logout() {
        this.mainView.displayFragment(new LoginPage(this), true);
    }

    public void toHomepage(Profile p) {
        this.mainView.displayFragment(new HomepageFragment(curr, this), true);
    }

    public Profile returnCurrProf() {
        return curr;
    }

    public Profile cMakeNewProfile(String pName, String pPass, int pYear, String pMajor) {
        curr = CC.cMakeNewProfile(CC.pd, pName, pPass, pYear, pMajor);
        this.persistenceFacade.createProfileIfNotExists(curr);
        updatateHMForPD(pName);
        this.mainView.displayFragment(new HomepageFragment(curr, this), true);
        return curr;
    }

    public void updatateHMForPD(String pName) {
        CC.pd = returnPD();
        for(int i =0; i < CC.pd.list.size(); i++) {
            if (pName.compareTo(CC.pd.list.get(i).name) != 0) {
                HashMap<String, Integer> newHM = CC.pd.list.get(i).weightChart;
                newHM.put(pName, 0);
                this.persistenceFacade.changeHM(CC.pd.list.get(i).name, newHM);
            }
        }
    }

    public void toCreateNewProf() {
        this.mainView.displayFragment(new Createnewprofile(this), true);
    }

    public Event cMakeNewEvent(String newtitle, String newcontents) {
        Event newe = CC.cMakeNewEvent(curr.dash.eventD, newtitle, newcontents);
        persistenceFacade.makeNewEvent(curr.name, curr.dash.eventD);
        return newe;
    }

    public void toCreateNewEvent() {
        this.mainView.displayFragment(new MakeEvent(this), true);
    }

    public String showEvents(Profile p) {
        String s = "";
        int rotations = 0;
        if (p.dash.eventD.list.size() == 0) {
            return "No Events to Show";
        }
        for (int i = 0; i < p.dash.eventD.list.size(); i++) {
            rotations++;
            s += "Event #" + rotations + ": " + p.dash.eventD.list.get(i).eTitle + "\n" + p.dash.eventD.list.get(i).contents + "\n" + "\n";
        }
        return s;
    }

    public String showClasses(Profile p) {
        String s = "";
        int rotations = 0;
        if (p.classDB.list.size() == 0) {
            return "No Classes to Show";
        }
        for (int i = 0; i < p.classDB.list.size(); i++) {
            rotations++;
            s += "Class #" + rotations + ": " + p.classDB.list.get(i).classy + "\n" + "\n";
        }
        return s;
    }

    @Override
    public void toFilters() {
        this.mainView.displayFragment(new Filters(curr, this), true);
    }

    public Class cMakeNewClass(Profile p, String s) {
        CC.pd = returnPD();
        Class newc = CC.cMakeNewClass(curr, s);
        CC.pd = CC.pd.modWeights(p, CC.pd, s);
        for (int i = 0; i < CC.pd.list.size(); i++) {
            persistenceFacade.changeHM(CC.pd.list.get(i).name, CC.pd.list.get(i).weightChart);
        }
        persistenceFacade.makeNewClass(curr.name, curr.classDB);
        return newc;
    }

    public void changeName(Profile p, String s) {
        //persistenceFacade.changeName(p.name, s);
        CC.cChangeName(p, s);
    }

    public void changePass(Profile p, String s) {
        persistenceFacade.changePass(p.name, s);
        CC.cChangePass(p, s);
    }

    public void changeYear(Profile p, int y) {
        persistenceFacade.changeYear(p.name, y);
        CC.cChangeYear(p, y);
    }

    public void changeMajor(Profile p, String s) {
        persistenceFacade.changeMajor(p.name, s);
        CC.cChangeMajor(p, s);
    }

    public void changeHM(Profile p, HashMap<String, Integer> hm) {
        //CC.pd = CC.pd.modWeights(p, CC.pd, s);
        persistenceFacade.changeHM(p.name, hm);
        CC.cChangeHM(p, hm);
    }

    public void toEditProfile(Profile p){
        this.mainView.displayFragment(new EditProfile(p, this), true);
    }

    public ProfileDatabase cGetReccYear() {
        return CC.pd.getReccYear(CC.pd, curr);
    }

    public ProfileDatabase cGetReccMajor() {
        return CC.pd.getReccMajor(CC.pd, curr);
    }

    public ProfileDatabase cGetReccClasses() {
        returnPD();
        return CC.pd.getReccClasses(CC.pd, curr);
    }

    public void toReccRes(String s){
        this.mainView.displayFragment(new ReccResult(curr, s,this), true);
    }

    public void getPD() {
        this.persistenceFacade.getPD(new IPersistenceFacade.DataListener<ProfileDatabase>() {
            @Override
            public void onDataReceived(@NonNull ProfileDatabase data) {
                CC.pd = data;
            }

            @Override
            public void onNoDataFound() {
            }
        });
    }

    public ProfileDatabase returnPD() {
        getPD();
        return CC.pd;
    }
}