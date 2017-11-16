package scheduleAlgorithm;

import models.BurstUnit;
import models.Process;
import models.Schedule;

import java.util.Collections;
import java.util.List;

public class RoundRobin extends Schedule {

    public RoundRobin(List<Process> processes) {
        super(processes);
    }

    @Override
    public void scheduleAlgorithm(){
        int slice = 2;

        Collections.sort(processes, Process.sortByArrivalTime);
        int currentTime = 0;
        int numOfFinished = 0;
        int startTime, endTime;

        int[] arrayOfEndTime = new int[processes.size()];   //save the end of the time of each slice for computing waiting time

        while (numOfFinished < processes.size()){
            for (int i=0;i<processes.size();i++) {
                if (processes.get(i).getRunningTime() > 0 && processes.get(i).getArrivalTime() <= currentTime){

                    startTime = currentTime;

                    processes.get(i).setWaitingTime(currentTime - arrayOfEndTime[i] + processes.get(i).getWaitingTime());
                    processes.get(i).setRunningTime(processes.get(i).getRunningTime() - slice);
                    currentTime += 2;

                    if (processes.get(i).getRunningTime() <= 0){
                        currentTime -= Math.abs(processes.get(i).getRunningTime());
                        numOfFinished += 1;
                    }
                    arrayOfEndTime[i] = currentTime;
                    endTime = currentTime;

                    //System.out.printf("here");

                    burstUnits.add(new BurstUnit(processes.get(i).getName(), startTime, endTime));   //get a picked process executed
                }
                else if (numOfFinished == i){
                    currentTime += 1;
                }
            }
            //System.out.println("numOfFinished = " + numOfFinished);
        }


    }
}
