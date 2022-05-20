package edu.vassar.cmpu203.schmoodleproto1.Model;

import junit.framework.TestCase;

/**
 * Our tests for Dashboard Database
 */
public class DashboardDatabaseTest extends TestCase {

    /**
     * This tests our function DashLoginValidator()
     * @param: profile, pin, dashboard database
     * @return: dashboard
     */
    public void testDashLoginValidator() {
        ProfileDatabase pd = new ProfileDatabase();
        DashboardDatabase dd = new DashboardDatabase();

        EventDatabase eventDw = new EventDatabase();
        EventDatabase eventDl = new EventDatabase();
        EventDatabase eventDr = new EventDatabase();

        Event nE = new Event("Team Dinner!", "bring your spoons.");
        Event nE2 = new Event("A Capella Concert!", "bring your pipes");

        Event nE3 = new Event("PB Pizza Party", "bring your slices");
        Event nE4 = new Event("Brian's Birthday Bash", "bring your presents");

        Event nE5 = new Event("Office Hours", "5-7pm in Sanders Physics");
        Event nE6 = new Event("Office Hours Cancelled", "broke my spleen");

        ClassDatabase classDBw = new ClassDatabase();
        ClassDatabase classDBl = new ClassDatabase();
        ClassDatabase classDBr = new ClassDatabase();

        Class cmpu101 = new Class("CMPU101");
        Class cmpu102 = new Class("CMPU102");
        Class cmpu145 = new Class("CMPU145");
        Class cmpu203 = new Class("CMPU203");
        Class engl102 = new Class("ENGL102");

        Dashboard wolffDash = new Dashboard("Wolff's Dash", eventDw, 1001);
        Dashboard liamDash = new Dashboard("Liam's Dash", eventDl, 1002);
        Dashboard ruiDash = new Dashboard("Your GPA", eventDr, 1003);

        //Test Case Profiles
        Profile wolff = new Profile("wolff", "l", 2024, "CS", wolffDash, classDBw);
        Profile liam = new Profile("liam", "l",2025, "communications", liamDash, classDBl);
        Profile rui = new Profile("rui", "l",2026, "Computer science", ruiDash, classDBr);

        pd.addProfile(wolff);
        pd.addProfile(liam);
        pd.addProfile(rui);

        eventDw.addEvent(nE);
        eventDw.addEvent(nE2);

        eventDl.addEvent(nE3);
        eventDl.addEvent(nE4);

        eventDr.addEvent(nE5);
        eventDr.addEvent(nE6);

        dd.addDashboard(wolffDash);
        dd.addDashboard(liamDash);
        dd.addDashboard(ruiDash);

        assertEquals(dd.dashLoginValidator(1001), wolff.dash);
        assertEquals(dd.dashLoginValidator(1002), liam.dash);
        assertEquals(dd.dashLoginValidator(1003), rui.dash);
        assertEquals(dd.dashLoginValidator(1004), null);
    }
}