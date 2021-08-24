package com.bala.hackerrank.paypal;

import java.util.*;

public class HurryTaskCounts {
    public static void main(String[] args) {
        int n = 3;
        int taskTime = 25;
        int[][] task = {{2, 8}, {4, 5}, {5, 1}, {3, 5}};
        System.out.println(solve(n, taskTime, task));
    }

    private static int solve(int n, int t, int[][] task) {
        Arrays.sort(task, Comparator.comparingInt(o -> o[0]));
        Queue<Integer> taskTimelist = new LinkedList<>();
        int totalTaskCompleted = 0, sumOfTaskTimeList = 0;
        for (int i = 0; i < n; i++) {
            int currentDistance = task[i][0];
            int currentTaskTime = task[i][1];
            int remainingTime = t;
            remainingTime -= 2 * currentDistance;//return back to initial stage
            if (remainingTime < 0) { //size is not enough for proceeding to the tasks
                break;
            }
            while (sumOfTaskTimeList > remainingTime) {
                Integer poll = taskTimelist.poll();
                sumOfTaskTimeList -= poll;
            }
            if (taskTimelist.isEmpty() && remainingTime > currentTaskTime) {//check the first task time
                sumOfTaskTimeList = getSumOfTaskTimeList(taskTimelist, sumOfTaskTimeList, currentTaskTime);
            } else if ((sumOfTaskTimeList + currentTaskTime) <= remainingTime) {// check whether the current task effort can fit in the remaining time.
                sumOfTaskTimeList = getSumOfTaskTimeList(taskTimelist, sumOfTaskTimeList, currentTaskTime);
            } else {
                Integer lastTaskTime = taskTimelist.peek();
                if (lastTaskTime != null && currentTaskTime < lastTaskTime) {
                    taskTimelist.poll();
                    taskTimelist.add(currentTaskTime);
                    sumOfTaskTimeList = sumOfTaskTimeList - lastTaskTime + currentTaskTime;
                }
            }
            totalTaskCompleted = Math.max(totalTaskCompleted, taskTimelist.size());
        }
        System.out.println("Task Completed " + totalTaskCompleted);
        System.out.println(taskTimelist);
        return totalTaskCompleted;
    }

    private static int getSumOfTaskTimeList(Queue<Integer> taskTimelist, int sumOfTaskTimeList, int currentTaskTime) {
        taskTimelist.add(currentTaskTime);
        sumOfTaskTimeList += currentTaskTime;
        return sumOfTaskTimeList;
    }

    private static int solve3(int n, int t, int[][] task) {
        Arrays.sort(task, Comparator.comparingInt(o -> o[0]));
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int remainingTime = t;
            int taskCompletedPerVisit = 0;
            LinkedList<Integer> integers1 = new LinkedList<>();
            for (int j = i; j < n; j++) {
                int currentDistance = task[j][0];
                int currentTaskTime = task[j][1];
                if(i==0){
                    remainingTime -=2*currentDistance;
                } else {
                    remainingTime -=currentDistance;
                }
                if(remainingTime < 0){
                    break;
                }
                if(remainingTime >= currentTaskTime){
                    remainingTime -=currentTaskTime;
                    integers1.add(currentDistance);
//                    System.out.println("Completed Distance "+ currentDistance+" completed time "+currentTaskTime);
                    taskCompletedPerVisit ++;
                }
            }
            System.out.println(integers1);
            integers.add(taskCompletedPerVisit);
        }
        int max =0;
        for (Integer integer : integers) {
            if (max < integer) {
                max = integer;
            }
        }
        return max;
    }

    private static int solve2(int n, int t, int[][] task) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(task, Comparator.comparingInt(o -> o[0]));
        int pQueueSum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int totalTime = t;
            int distance = 2 * task[i][0];
            int remainingTime = totalTime - distance;
            int currEffort = task[i][1];
            if (remainingTime < 0) {
                break;
            }
            while (pQueueSum > remainingTime) {
                pQueueSum -= pQueue.poll();
            }
            if (pQueue.isEmpty() && remainingTime > currEffort) {
                pQueue.add(currEffort);
                pQueueSum += currEffort;
            } else if (pQueueSum + currEffort <= remainingTime) {
                pQueue.add(currEffort);
                pQueueSum += currEffort;
            } else {
                Integer currMax = pQueue.peek();
                if (currMax != null && currMax > currEffort) {
                    pQueue.poll();
                    pQueue.add(currEffort);
                    pQueueSum = pQueueSum - currMax + currEffort;
                }
            }
            max = Math.max(max, pQueue.size());
        }
        return max;
    }
}
