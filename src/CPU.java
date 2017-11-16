import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Process;
import models.Schedule;
import scheduleAlgorithm.*;

public class CPU {
    private List <Process> processes;
    private Schedule schedule;

    public CPU() {
        processes = new ArrayList<>();
    }

    public void beginWork(){

        try {
            gainProcesses();
            this.schedule = selectScheduleAlgorithm();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        schedule.printAnswer();
    }

    private void gainProcesses() throws Exception {
        File file = new File("/Users/CCC/course_work/OS/CPU_Schedule_Algorithm/assets/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String property;
        while ((property = br.readLine()) != null){
            String[] each = property.split(" ");
            processes.add(new Process(each[0], Integer.parseInt(each[1]), Integer.parseInt(each[2]), Integer.parseInt(each[3])));
        }
    }

    private Schedule selectScheduleAlgorithm() throws Exception{
        System.out.println("Please select a algorithm by enter a number:");
        System.out.println("First-Come First-Served: 1");
        System.out.println("Shortest Job First: 2");
        System.out.println("Shortest Remaining Time First: 3");
        System.out.println("Priority: 4");
        System.out.println("Round Robin: 5");


        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch (choice){
            case 1:
                return new FirstComeFirstServed(processes);
            case 2:
                return new ShortestJobFirst(processes);
            case 3:
                return new ShortestRemainingTimeFirst(processes);
            case 4:
                return new Priority(processes);
            case 5:
                return new RoundRobin(processes);
            default:
                throw new Exception("Illegal Input!");
        }
    }

}
