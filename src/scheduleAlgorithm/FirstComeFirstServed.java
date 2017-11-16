package scheduleAlgorithm;

import models.BurstUnit;
import models.Process;
import models.Schedule;


import java.util.*;

public class FirstComeFirstServed extends Schedule{

    public FirstComeFirstServed(List<Process> processes) {
        super(processes);
    }

    @Override
    public void scheduleAlgorithm(){
        Collections.sort(processes, Process.sortByArrivalTime);

        int currentTime = 0;
        for (int i = 0; i < processes.size(); i++) {
            int startTime = 0, endTime;
            if (currentTime < processes.get(i).getArrivalTime()){
                currentTime = processes.get(i).getArrivalTime();
                processes.get(i).setWaitingTime(0);
            }
            else{
                processes.get(i).setWaitingTime(currentTime - processes.get(i).getArrivalTime());
            }
            startTime = currentTime;
            currentTime += processes.get(i).getRunningTime();
            endTime = currentTime;
            burstUnits.add(new BurstUnit(processes.get(i).getName(), startTime, endTime));   //get a picked process executed
        }

    }
}
