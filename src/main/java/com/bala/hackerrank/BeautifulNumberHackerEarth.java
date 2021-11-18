package com.bala.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BeautifulNumberHackerEarth {

    static long[] result = new long[1000001];
    static Map<Long, Integer> beautifulNum = new HashMap<>();

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        preProcess();
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);
            long out_ = solve(l, r);
            wr.write(out_ + "\n");
        }
        wr.close();
        br.close();
    }*/

    public static void main(String[] args) {
        preProcess();
        for (int i = 0; i < 50; i++) {
            System.out.println(result[i]);
        }
        int l = 257, r = 1113; //output = 79702
//        int l = 7, r = 7;
        long out_ = solve(l, r);
        System.out.println("Beautiful Number between " + l + " & " + r + " is " + out_);
    }

    static void preProcess() {
        IntStream.rangeClosed(1, 1000000).forEach(value -> {
            int data = 0;
            if (isBeautiful(value)) {
                data = value;
            }
            result[value] = data + result[value - 1];
        });
    }

    private static long squareAndAdd(long num) {
        long sum = 0;
        Integer integer = beautifulNum.get(num);
        if (integer != null) {
            return integer;
        }
        while (num > 0) {
            long i = num % 10;
            sum += (i * i);
            num = num / 10;
        }
        while (sum > 9) {
            sum = squareAndAdd(sum);
        }
        return sum;
    }

    static boolean isBeautiful(long n) {
        long i = squareAndAdd(n);
        if (i == 1 || i == 7) {
            return true;
        }
        return false;
    }

    static long solve(int l, int r) {
        return result[r] - result[l - 1];
    }
}
