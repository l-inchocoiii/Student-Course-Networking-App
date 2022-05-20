package edu.vassar.cmpu203.schmoodleproto1.Model;

import junit.framework.TestCase;
/**
 * Our tests for Profile Database
 */
public class ProfileDatabaseTest extends TestCase {
    ProfileDatabase pd = new ProfileDatabase();
    DashboardDatabase dd = new DashboardDatabase();

    EventDatabase eventDw = new EventDatabase();
    EventDatabase eventDl = new EventDatabase();
    EventDatabase eventDr = new EventDatabase();

    ClassDatabase classDBw = new ClassDatabase();
    ClassDatabase classDBl = new ClassDatabase();
    ClassDatabase classDBr = new ClassDatabase();

    Class cmpu101 = new Class("CMPU101");
    Class cmpu102 = new Class("CMPU102");
    Class cmpu145 = new Class("CMPU145");
    Class cmpu203 = new Class("CMPU203");
    Class engl102 = new Class("ENGL102");

    Event nE = new Event("Team Dinner!", "bring your spoons.");
    Event nE2 = new Event("A Capella Concert!", "bring your pipes");

    Dashboard wolffDash = new Dashboard("Wolff's Dash", eventDw, 1001);
    Dashboard liamDash = new Dashboard("Liam's Dash", eventDl, 1002);
    Dashboard ruiDash = new Dashboard("Your GPA", eventDr, 1003);

    //Test Case Profiles
    Profile wolff = new Profile("wolff", "l", 2024, "CS", wolffDash, classDBw);
    Profile liam = new Profile("liam", "l",2025, "communications", liamDash, classDBl);
    Profile rui = new Profile("rui", "l",2026, "Computer science", ruiDash, classDBr);

    /**
     * This tests our function MakeNewProfile()
     * @param: name, year, major, password
     * @return: profile
     */
    public void testMakeNewProfile() {
        pd.makeNewProfile(pd, "jason", "l", 2022, "CS++");
        assertEquals(pd.list.get(0).name, "jason");
        assertEquals(pd.list.get(0).pass, "l");
        assertEquals(pd.list.get(0).year, 2022);
        assertEquals(pd.list.get(0).major, "CS++");

        pd.makeNewProfile(pd, "rowan", "l", 2023, "CS++");
        assertEquals(pd.list.get(1).name, "rowan");
        assertEquals(pd.list.get(1).pass, "l");
        assertEquals(pd.list.get(1).year, 2023);
        assertEquals(pd.list.get(1).major, "CS++");
    }

    public void testLoginValidator() {
        pd.addProfile(wolff);
        pd.addProfile(liam);
        pd.addProfile(rui);

        assertEquals(pd.loginValidator("wolff", "l").name, "wolff");
        assertEquals(pd.loginValidator("wolff", "l").pass, "l");
        assertEquals(pd.loginValidator("liam", "l").name, "liam");
        assertEquals(pd.loginValidator("liam", "l").pass, "l");
        assertEquals(pd.loginValidator("rui", "l").name, "rui");
        assertEquals(pd.loginValidator("rui", "l").pass, "l");

        assertEquals(pd.loginValidator("chicken", "l"), null);
        assertEquals(pd.loginValidator("rui", "123"), null);
        assertEquals(pd.loginValidator("chicken", "nuggets"), null);
    }

    public void testSearchProfile() {
        pd.addProfile(wolff);
        pd.addProfile(liam);
        pd.addProfile(rui);

        assertEquals(pd.searchProfile("wolff").name, "wolff");
        assertEquals(pd.searchProfile("wolff").pass, "l");
        assertEquals(pd.searchProfile("wolff").year, 2024);
        assertEquals(pd.searchProfile("liam").name, "liam");
        assertEquals(pd.searchProfile("liam").pass, "l");
        assertEquals(pd.searchProfile("liam").year, 2025);
        assertEquals(pd.searchProfile("rui").name, "rui");
        assertEquals(pd.searchProfile("rui").pass, "l");
        assertEquals(pd.searchProfile("rui").year, 2026);

        assertEquals(pd.searchProfile("Methuselah"), null);
        assertEquals(pd.searchProfile("12y849"), null);
    }


}