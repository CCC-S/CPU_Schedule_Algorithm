package scheduleAlgorithm;

import models.BurstUnit;
import models.Process;
import models.Schedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestJobFirst extends Schedule {

    public ShortestJobFirst(List<Process> processes) {
        super(processes);
    }

    @Override
    public void scheduleAlgorithm(){
        //Collections.sort(processes, Process.sortByRunningTime);
        Collections.sort(processes, Process.sortByArrivalTime);

        List<Process> arrivedProcess = new ArrayList<>();
        int numOfFinished = 0;

        int currentTime = 0;
        int startTime, endTime;

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

            currentTime += arrivedProcess.get(0).getRunningTime();
            endTime = currentTime;

            burstUnits.add(new BurstUnit(arrivedProcess.get(0).getName(), startTime, endTime));

            arrivedProcess.get(0).setWaitingTime(currentTime - arrivedProcess.get(0).getArrivalTime() - arrivedProcess.get(0).getRunningTime());
            arrivedProcess.remove(arrivedProcess.get(0));
            numOfFinished += 1;

        }

    }
}
