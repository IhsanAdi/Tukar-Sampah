package com.kreatify.tukarsampah;

public class Event {

    String event_title;
    String event_category;
    Integer event_pic;

    public Event(){

    }

    public Event(String event_title, String event_category, Integer event_pic) {
        this.event_title = event_title;
        this.event_category = event_category;
        this.event_pic = event_pic;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_category() {
        return event_category;
    }

    public void setEvent_category(String event_category) {
        this.event_category = event_category;
    }

    public Integer getEvent_pic() {
        return event_pic;
    }

    public void setEvent_pic(Integer event_pic) {
        this.event_pic = event_pic;
    }
}
