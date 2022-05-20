package edu.vassar.cmpu203.schmoodleproto1.Model;

import com.google.android.gms.common.util.CollectionUtils;

import java.util.*;

public class ProfileDatabase {
    public List<Profile> list;
    public Profile curr;

    public ProfileDatabase(String name, String pass, int year, String major, Dashboard dash, ClassDatabase classDB) {
        this.list = new ArrayList<>();
        Profile prof = new Profile(name, pass, year, major, dash, classDB);
        list.add(prof);
    }

    public ProfileDatabase() {
        this.list = new ArrayList<>();
    }

    public void addProfile(Profile p) {
        list.add(p);
    }

    public static Profile makeNewProfile(ProfileDatabase pd, String pName, String pPass, int pYear, String pMajor) {

        EventDatabase eventD = new EventDatabase();
        ClassDatabase pclassDB = new ClassDatabase();

        Dashboard pDash = new Dashboard("", eventD, 0);

        Profile prof = new Profile(pName, pPass, pYear, pMajor, pDash, pclassDB);
        HashMap<String, Integer> newWeightChart = new HashMap<String, Integer>();
        for (int i = 0; i < pd.list.size(); i++) {
            newWeightChart.put(pd.list.get(i).name, 0);
        }
        prof.weightChart = newWeightChart;
        pd.addProfile(prof);

        return prof;
    }

    public Profile loginValidator(String lName, String lPass) {
        for (Profile profile : this.list) {
            if ((profile.name.compareTo(lName) == 0) && (profile.pass.compareTo(lPass) == 0)) {
                //if (profile.name.compareTo(lName) == 0) {
                curr = profile;
                return curr;
            }
        }
        return null;
    }

    public Profile searchProfile(String iName) {
        Profile sResult;
        for (Profile profile : this.list) {
            if (profile.name.compareTo(iName) == 0) {
                sResult = profile;
                return sResult;
            }
        }
        return null;
    }

    public ProfileDatabase getReccYear(ProfileDatabase currpd, Profile currprof) {
        //initialize resulting Profile Collection
        ProfileDatabase reccresult = new ProfileDatabase();
        //year function
        for (int i = 0; i < currpd.list.size(); i++) {
            if (currprof.name.compareTo(currpd.list.get(i).name) == 0) {
                continue;
            } else if (currprof.year == currpd.list.get(i).year) {
                reccresult.list.add(currpd.list.get(i));
            }
        }
        return reccresult;
    }

    public ProfileDatabase getReccMajor(ProfileDatabase currpd, Profile currprof) {
        //initialize resulting Profile Collection
        ProfileDatabase reccresult = new ProfileDatabase();
        //major function
        for (int i = 0; i < currpd.list.size(); i++) {
            if (currprof.name.compareTo(currpd.list.get(i).name) == 0) {
                continue;
            } else if ((currprof.major.compareTo(currpd.list.get(i).major)) == 0) {
                reccresult.list.add(currpd.list.get(i));
            }
        }
        return reccresult;
    }

    public ProfileDatabase getReccClasses(ProfileDatabase currpd, Profile currprof) {
        //in itialize resulting Profile Collection
        ProfileDatabase reccresult = new ProfileDatabase();

        //class function, just ordering hashmap by weight
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(currprof.weightChart.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        for (Map.Entry<String, Integer> en : temp.entrySet()) {
            for (int i = 0; i < currpd.list.size(); i++) {
                if (en.getKey().compareTo(currpd.list.get(i).name) == 0) {
                    reccresult.addProfile(currpd.list.get(i));
                }
            }
        }
        Collections.reverse(reccresult.list);
        return reccresult;
    }

    public ProfileDatabase modWeights(Profile cp, ProfileDatabase pd, String s) {
        for (int i = 0; i < pd.list.size(); i++) {
            for (int j = 0; j < pd.list.get(i).classDB.list.size(); j++) {
                if (pd.list.get(i).name.compareTo(cp.name) == 0) {
                    continue;
                } else if (s.compareTo(pd.list.get(i).classDB.list.get(j).classy) == 0) {
                    //update weight value for current profile
                    //if (cp.weightChart.get(pd.list.get(i).name) != null) {
                        int num = cp.weightChart.get(pd.list.get(i).name);
                        cp.weightChart.put(pd.list.get(i).name, num + 1);
                    //}
                    //replace instead of put?
                    //update weight value for compared profile from the profile database
                    //if (pd.list.get(i).weightChart.get(cp.name) != null) {

                        int num2 = pd.list.get(i).weightChart.get(cp.name);
                        pd.list.get(i).weightChart.put(cp.name, num2 + 1);
                    //}
                }
            }
        }
        return pd;
    }
}