package com.uit.khaph.uitocm;

public class Meeting {
    public String userName;
    public String information;
    public String date;
    public String className;
    public String meetingName;
    public String isEnd;


    public Meeting() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Meeting(String userName,String meetingName, String information, String date, String className, String isEnd) {
        this.userName = userName;
        this.meetingName = meetingName;
        this.information = information;
        this.date = date;
        this.className = className;
        this.isEnd = isEnd;
    }

    public String getMeetingName(){
        return this.meetingName;
    }

    public String getInformation(){
        return this.information;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getDate(){
        return this.date;
    }

    public String getClassName(){ return this.className; }

    public String getIsEnd(){return this.isEnd;}
}
