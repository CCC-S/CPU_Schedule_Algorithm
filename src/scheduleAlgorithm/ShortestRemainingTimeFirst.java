package scheduleAlgorithm;

import models.BurstUnit;
import models.Process;
import models.Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestRemainingTimeFirst extends Schedule {

    public ShortestRemainingTimeFirst(List<Process> processes) {
        super(processes);
    }

    @Override
    public void scheduleAlgorithm(){
        Collections.sort(processes, Process.sortByArrivalTime);

        List<Process> arrivedProcess = new ArrayList<>();

        int numOfFinished = 0;
        int currentTime = 0;
        int startTime;
        int endTime;

        int[] arrivalTime = new int[processes.size()];
        //int[] endTime = new int[processes.size()];

        for (int i = 0; i < processes.size(); i++) {
            arrivalTime[i] = processes.get(i).getArrivalTime();
            processes.get(i).setWaitingTime(processes.get(i).getRunningTime());
        }


        while (numOfFinished < processes.size()){
            for (int i = arrivedProcess.size()+numOfFinished; i < processes.size(); i++) {
                if (processes.get(i).getArrivalTime() <= currentTime) {
                    arrivedProcess.add(processes.get(i));
                }
            }

            /**
             * When those arrived process were all finished, skipping the time of idle and moving to the next process.
             */
            if (arrivedProcess.size() == 0){
                currentTime = processes.get(numOfFinished).getArrivalTime();
                continue;
            }

            Collections.sort(arrivedProcess, Process.sortByRunningTime);

            startTime = currentTime;
            int runningTimeForTheFirstProcess = (arrivedProcess.size()+numOfFinished) == processes.size() ?
                    arrivedProcess.get(0).getRunningTime():Math.min(arrivedProcess.get(0).getRunningTime(), arrivalTime[arrivedProcess.size()+numOfFinished]-currentTime);
            currentTime += runningTimeForTheFirstProcess;
            endTime = currentTime;

            burstUnits.add(new BurstUnit(arrivedProcess.get(0).getName(), startTime, endTime));

            arrivedProcess.get(0).setRunningTime(arrivedProcess.get(0).getRunningTime() - runningTimeForTheFirstProcess);
            if (arrivedProcess.get(0).getRunningTime() == 0){
                arrivedProcess.get(0).setWaitingTime(currentTime - arrivedProcess.get(0).getWaitingTime() - arrivedProcess.get(0).getArrivalTime());
                arrivedProcess.remove(arrivedProcess.get(0));
                numOfFinished += 1;
            }
        }


    }
}
