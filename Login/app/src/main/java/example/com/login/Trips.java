package example.com.login;

import java.util.ArrayList;

public class Trips {

    String date;
    ArrayList<Activity> activities = new ArrayList<>();
    String uderid;
    String tripType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    public String getUderid() {
        return uderid;
    }

    public void setUderid(String uderid) {
        this.uderid = uderid;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }
}
