package com.bala.hackerrank;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> output = new LinkedList<>();
        List<List<Integer>> arr = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        int i = 0;
        for (List<Integer> query : queries) {
            Integer integer = query.get(0);
            int idx = ((query.get(1) ^ lastAnswer) % n);
            System.out.println("Iteration "+(i+=1));
            if (integer == 1) {
                arr.get(idx).add(query.get(2));
                System.out.println(arr);
            } else if (integer == 2) {
                List<Integer> integers = arr.get(idx);
                lastAnswer = integers.get(query.get(2) % integers.size());
                output.add(lastAnswer);
            }
        }
        return output;
    }


}

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.stream(new Integer[]{1, 0, 5}).collect(toList()));
        lists.add(Arrays.stream(new Integer[]{1, 1, 7}).collect(toList()));
        lists.add(Arrays.stream(new Integer[]{1, 0, 3}).collect(toList()));
        lists.add(Arrays.stream(new Integer[]{2, 1, 0}).collect(toList()));
        lists.add(Arrays.stream(new Integer[]{2, 1, 1}).collect(toList()));
        List<Integer> integers = DynamicArray.dynamicArray(2, lists);
        System.out.println(integers);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = DynamicArray.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
