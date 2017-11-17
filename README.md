# Overview

This project implements 5 CPU shedule algorithms:

1. First-Come First-Served
2. Shortest Job First
3. Shortest Remaining Time First
4. Priority
5. Round Robin

# Introduction of each file

### Main.java

The entry point of the program. It creates a new CPU object and begain the work.

### CPU.java

The CPU class contain three methods:

1. public void beginWork()
2. private void gainProcesses()
3. private Schedule selectScheduleAlgorithm()

The latter two are called by the first. Besides, at the end of _beginWork_, it prints the _Gatte Graph_ and _Waiting Time_.
PS: In fact, it is not the CPU's work to collecte the infomation of processes.


## models/

### Schedule.java

A abstract class from where all other schedule algorithms inherit.
It draws the graph and computes the waiting time.
It leaves the mothed _public abstract void scheduleAlgorithm()_ to be overrided by its subclasses.

### Process.java

It contains all the necessary infomation for a process and defines some ordering rules.

### BurstUnit.java

It represent every unit in the Gatte Graph so that simplifies the process of drawing the Gatte Graph. To illustrate, the executing process would record the infomation of its burst period and add in into an _Arraylist<E>_, once the CPU decides to select another process to be extcuted. Thus, drawing the graph simplly equals extracting units from the _Arraylist<E>_.

## scheduleAlgorithm/

This directory includes 5 forementioned schedule algorithms




