package edu.vassar.cmpu203.schmoodleproto1.Model;

import junit.framework.TestCase;

/**
 * Our tests for Class Database
 */

public class ClassDatabaseTest extends TestCase {

    /**
     * This tests our function makeNewClass()
     * @param: profile, string
     * @return: class
     */
    public void testMakeNewClass() {
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

        classDBw.addClass(cmpu101);
        assertEquals(wolff.classDB.list.get(0).classy, "CMPU101");
        classDBw.addClass(cmpu102);
        assertEquals(wolff.classDB.list.get(1).classy, "CMPU102");
        classDBw.addClass(cmpu145);
        assertEquals(wolff.classDB.list.get(2).classy, "CMPU145");
        classDBw.addClass(cmpu203);
        assertEquals(wolff.classDB.list.get(3).classy, "CMPU203");
        classDBw.addClass(engl102);
        assertEquals(wolff.classDB.list.get(0).classy, "ENGL102");
    }
}