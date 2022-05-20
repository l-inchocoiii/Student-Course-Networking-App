package edu.vassar.cmpu203.schmoodleproto1.Model;

public class Event extends EventDatabase {
    public String contents;
    public String eTitle;

    public Event() {
    }
    public Event(String eTitle, String contents){
        this.eTitle = eTitle;
        this.contents = contents;
    }

    public void changeTitle(Event e, String newTitle){
        e.eTitle = newTitle;
    }

    public void changeContents(Event e, String newContents){
        e.contents = newContents;
    }
}