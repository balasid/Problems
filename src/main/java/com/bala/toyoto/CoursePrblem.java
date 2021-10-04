package com.bala.toyoto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CoursePrblem {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int noOfCourse;
        boolean isFirstLineRead = false;
        Map<Integer, List<Integer>> courseDependency = new HashMap<>();
        Map<Integer, Boolean> courseCompleted = new HashMap<>();
        Set<Integer> courseList = new TreeSet<>();
        while ((line = in.readLine()) != null) {
            if (!isFirstLineRead) {
                noOfCourse = Integer.parseInt(line.trim());
                isFirstLineRead = true;
            } else {
                String[] courseDependLine = line.split("\\s");
                Integer courseData = null;
                for (int i = 0; i < courseDependLine.length; i++) {
                    Integer courseInt = Integer.parseInt(courseDependLine[i].trim());
                    if (i == 0) {
                        courseData = courseInt;
                        courseDependency.put(courseInt, new ArrayList<>());
                    } else {
                        List<Integer> integers = courseDependency.get(courseData);
                        integers.add(courseInt);
                    }
                    courseList.add(courseInt);
                    courseCompleted.put(courseInt, false);
                }
            }
        }

        Set<Integer> orderedCourseList = new LinkedHashSet<>();
        for (Integer integer : courseList) {
            computePrerequistiesCourse(courseDependency, orderedCourseList, integer, courseCompleted);
        }
        for (Integer integer : orderedCourseList) {
            System.out.println(integer);
        }
    }

    private static void computePrerequistiesCourse(Map<Integer, List<Integer>> courseDependency, Set<Integer> orderedCourseList, Integer integer, Map<Integer, Boolean> courseCompleted) {
        List<Integer> integers = courseDependency.get(integer);
        if (courseCompleted.get(integer) || integers == null) {
            orderedCourseList.add(integer);
            courseCompleted.put(integer, true);
        } else {
            for (Integer dependentCourse : integers) {
                computePrerequistiesCourse(courseDependency, orderedCourseList, dependentCourse, courseCompleted);
                courseCompleted.put(integer, true);
                orderedCourseList.add(integer);
            }
        }
    }
}
