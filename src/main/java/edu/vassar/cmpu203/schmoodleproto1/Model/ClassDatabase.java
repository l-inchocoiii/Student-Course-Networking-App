package edu.vassar.cmpu203.schmoodleproto1.Model;
import java.util.*;

public class ClassDatabase extends Profile{
    public List<Class> list;

    public ClassDatabase(Class classy) {
        this.list = new ArrayList<>();
        list.add(classy);
    }

    public ClassDatabase() {
        this.list = new ArrayList<>();
    }

    public void addClass(Class c) {
        list.add(c);
    }


    public static Class makeNewClass(ClassDatabase cd, String classtitle) {
        Class newClass = new Class(classtitle);
        cd.addClass(newClass);
        return newClass;
    }
}
