package edu.vassar.cmpu203.schmoodleproto1.Model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Profile extends ProfileDatabase {
    public String name;
    public String pass;
    public String major;
    public int year;
    public Dashboard dash;
    public ClassDatabase classDB;
    public HashMap<String, Integer> weightChart = new HashMap<String, Integer>();



    public Profile() {
    }

    public Profile(String name, String pass, int year, String major, Dashboard dash, ClassDatabase classDB) {
        this.name = name;
        this.pass = pass;
        this.year = year;
        this.major = major;
        this.dash = dash;
        this.classDB = classDB;
    }

    public Profile changeName(Profile p, String newName) {
        p.name = newName;
        return p;
    }

    public Profile changePass(Profile p, String newPass) {
        p.pass = newPass;
        return p;
    }

    public Profile changeYear(Profile p, int newYear) {
        p.year = newYear;
        return p;
    }

    public Profile changeMajor(Profile p, String newMajor) {
        p.major = newMajor;
        return p;
    }

    public Profile changeHM(Profile p, HashMap<String, Integer> newHM) {
        p.weightChart = newHM;
        return p;
    }

    public Dashboard changePin(Dashboard d, int newPin) {
        d.pin = newPin;
        return d;
    }

    public String toString(){
        return this.name;
    }

    public Event eventGet(Dashboard d, int eNum) {
        return d.eventD.list.get(eNum);
    }
}