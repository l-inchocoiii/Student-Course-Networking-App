package edu.vassar.cmpu203.schmoodleproto1.Model;

import java.util.*;

public class DashboardDatabase extends Profile{
    public List<Dashboard> list;
    public Dashboard dCurr;

    /**
     * @param dash
     */
    public DashboardDatabase(Dashboard dash) {
        this.list = new ArrayList<>();
        list.add(dash);
    }

    public DashboardDatabase() {
        this.list = new ArrayList<>();
    }

    public void addDashboard(Dashboard d) {
        list.add(d);
    }

    public Dashboard dashLoginValidator(int inputPin) {
        for (Dashboard dashboard : this.list) {
            if (dashboard.pin == inputPin) {
                dCurr = dashboard;
                return dCurr;
            }
        }
        return null;
    }
}