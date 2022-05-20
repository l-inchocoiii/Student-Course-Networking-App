package edu.vassar.cmpu203.schmoodleproto1.Model;

public class Dashboard extends DashboardDatabase {
    public String dTitle;
    public int pin;
    public EventDatabase eventD;

    public Dashboard(){
    }

    public Dashboard(String dTitle, EventDatabase eventD, int pin){
        this.dTitle = dTitle;
        this.eventD = eventD;
        this.pin = pin;
    }

}