package scheduleAlgorithm;

import models.BurstUnit;
import models.Process;
import models.Schedule;

import java.util.Collections;
import java.util.List;

public class Priority extends Schedule{

    public Priority(List<Process> processes) {
        super(processes);
    }

    @Override
    public void scheduleAlgorithm() {
        Collections.sort(processes, Process.sortByPriority);
        Collections.sort(processes, Process.sortByArrivalTime);

        int currentTime = 0;
        int startTime, endTime;
        for (Process process : processes) {
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
                process.setWaitingTime(0);
            } else {
                process.setWaitingTime(currentTime - process.getArrivalTime());
            }
            startTime = currentTime;
            currentTime += process.getRunningTime();
            endTime = currentTime;
            burstUnits.add(new BurstUnit(process.getName(), startTime, endTime));
        }
    }
}
