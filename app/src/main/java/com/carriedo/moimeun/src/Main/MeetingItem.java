package com.carriedo.moimeun.src.Main;

public class MeetingItem {
    String meeting_title;
    String meeting_person_count;

    public MeetingItem(String meeting_title, String meeting_person_count) {
        this.meeting_title = meeting_title;
        this.meeting_person_count = meeting_person_count;
    }

    public String getMeeting_title() {
        return meeting_title;
    }

    public void setMeeting_title(String meeting_title) {
        this.meeting_title = meeting_title;
    }

    public String getMeeting_person_count() {
        return meeting_person_count;
    }

    public void setMeeting_person_count(String meeting_person_count) {
        this.meeting_person_count = meeting_person_count;
    }
}
