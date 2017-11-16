package models;

public class BurstUnit {
    private String name;
    private int beginTime;
    private int endTime;

    public BurstUnit(String name, int beginTime, int endTime) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
