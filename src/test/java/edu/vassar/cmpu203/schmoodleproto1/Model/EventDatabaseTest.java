package edu.vassar.cmpu203.schmoodleproto1.Model;

import junit.framework.TestCase;

/**
 * Our tests for Event Database
 */

public class EventDatabaseTest extends TestCase {


    ProfileDatabase pd = new ProfileDatabase();
    DashboardDatabase dd = new DashboardDatabase();

    EventDatabase eventDw = new EventDatabase();
    EventDatabase eventDl = new EventDatabase();
    EventDatabase eventDr = new EventDatabase();

//    Event nE = new Event("Team Dinner!", "bring your spoons.");
//    Event nE2 = new Event("A Capella Concert!", "bring your pipes");
//
//    Event nE3 = new Event("PB Pizza Party", "bring your slices");
//    Event nE4 = new Event("Brian's Birthday Bash", "bring your presents");
//
//    Event nE5 = new Event("Office Hours", "5-7pm in Sanders Physics");
//    Event nE6 = new Event("Office Hours Cancelled", "broke my spleen");

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

    /**
     * This tests our function MakeNewEvent()
     * @param: profile, title, contents
     * @return: event
     */

    public void testMakeNewEvent() {
        pd.addProfile(wolff);
        pd.addProfile(liam);
        pd.addProfile(rui);

        eventDw.makeNewEvent(eventDw, "Team Dinner!", "bring your spoons.");
        eventDw.makeNewEvent(eventDw, "A Capella Concert!", "bring your pipes");

        eventDl.makeNewEvent(eventDl, "PB Pizza Party", "bring your slices");
        eventDl.makeNewEvent(eventDl, "Brian's Birthday Bash", "bring your presents");

        eventDr.makeNewEvent(eventDr, "Office Hours", "5-7pm in Sanders Physics");
        eventDr.makeNewEvent(eventDr, "Office Hours Cancelled", "broke my spleen");

        assertEquals(wolff.dash.eventD.list.get(0).eTitle, "Team Dinner!");
        assertEquals(wolff.dash.eventD.list.get(0).contents, "bring your spoons.");
        assertEquals(wolff.dash.eventD.list.get(1).eTitle, "A Capella Concert!");
        assertEquals(wolff.dash.eventD.list.get(1).contents, "bring your pipes");

        assertEquals(liam.dash.eventD.list.get(0).eTitle, "PB Pizza Party");
        assertEquals(liam.dash.eventD.list.get(0).contents, "bring your slices");
        assertEquals(liam.dash.eventD.list.get(1).eTitle, "Brian's Birthday Bash");
        assertEquals(liam.dash.eventD.list.get(1).contents, "bring your presents");

        assertEquals(rui.dash.eventD.list.get(0).eTitle, "Office Hours");
        assertEquals(rui.dash.eventD.list.get(0).contents, "5-7pm in Sanders Physics");
        assertEquals(rui.dash.eventD.list.get(1).eTitle, "Office Hours Cancelled");
        assertEquals(rui.dash.eventD.list.get(1).contents, "broke my spleen");




    }
}