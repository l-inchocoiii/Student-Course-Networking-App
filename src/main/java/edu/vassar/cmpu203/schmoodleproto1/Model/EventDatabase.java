package edu.vassar.cmpu203.schmoodleproto1.Model;

import java.util.*;
public class EventDatabase extends Dashboard{
    public List<Event> list;

    public EventDatabase(Event event) {
        this.list = new ArrayList<>();
        list.add(event);
    }

    public EventDatabase() {
        this.list = new ArrayList<>();
    }

    public void addEvent(Event e) {
        list.add(e);
    }

    public static Event makeNewEvent(EventDatabase ed, String newTitle, String newContents) {
        Event newEvent = new Event(newTitle, newContents);
        ed.addEvent(newEvent);
        return newEvent;
    }
}