package models;

import java.util.Comparator;

public class Process {
    private String name;
    private int arrivalTime, runningTime, priority, waitingTime;

    public static Comparator<Process> sortByArrivalTime = new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.arrivalTime - o2.arrivalTime;
        }
    };

    public static Comparator<Process> sortByPriority = new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.priority - o2.priority;
        }
    };

    public static Comparator<Process> sortByRunningTime = new Comparator<Process>() {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.runningTime - o2.runningTime;
        }
    };

    public Process(String name, int arrivalTime, int runningTime, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.runningTime = runningTime;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
