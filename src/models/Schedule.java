package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Schedule {
    public List<Process> processes;
    public List<BurstUnit> burstUnits;

    public Schedule(List<Process> processes) {
        this.processes = processes;
        this.burstUnits = new ArrayList<>();
    }

    public abstract void scheduleAlgorithm();

    public void printAnswer(){
        scheduleAlgorithm();
        System.out.println("Gantt Chart:");
        int currentTime = 0;
        System.out.print(currentTime);

        for (BurstUnit burstUnit : burstUnits) {
            System.out.printf("-");
            if (currentTime < burstUnit.getBeginTime()){
                System.out.printf("idle-%d-",burstUnit.getBeginTime());
            }
            System.out.printf("%s-%d",burstUnit.getName(),burstUnit.getEndTime());
            currentTime = burstUnit.getEndTime();
        }
        System.out.printf("\n");

        System.out.println("Waiting Time:");
        double totalWaitingTime = 0;
        for (Process process : processes) {
            System.out.printf("%s: %d\n",process.getName(), process.getWaitingTime());
            totalWaitingTime += process.getWaitingTime();
        }
        System.out.printf("Average Waiting Time: %.2f\n", totalWaitingTime/processes.size());
    }
}
