package kds.com.kdmsettlement.models;

import java.util.ArrayList;
import java.util.List;

public class YearlyMilestone {
    private int year;
    private List<String> eventNames;

    public YearlyMilestone(int year, List<String> eventNames) {
        this.year = year;
        this.eventNames = eventNames;
    }

    public YearlyMilestone(int year, String event) {
        this.year = year;
        eventNames = new ArrayList<String>() {{
            add(event);
        }};
    }

    public YearlyMilestone() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getEventNames() {
        return eventNames;
    }

    public void setEventNames(List<String> eventNames) {
        this.eventNames = eventNames;
    }

    public String getEventString() {
        String toReturn = "";
        for(int x = 0; x < eventNames.size(); x++) {
            toReturn += eventNames.get(x);
            if(x + 1 < eventNames.size()) {
                toReturn += ",";
            }
        }
        return toReturn;
    }
}
