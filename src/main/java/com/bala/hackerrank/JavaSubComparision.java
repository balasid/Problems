package com.bala.hackerrank;

import java.util.TreeMap;
import java.util.TreeSet;

public class JavaSubComparision {
    public static String getSmallestAndLargest(String s, int k) {
        TreeSet<String> strings = new TreeSet<>();
        int length = s.length();
        String substring = "";
        for (int i = 0; i < length; i++) {
            if (length - i >= k) {
                substring = s.substring(i, i + k);
                strings.add(substring);
            }
        }

        System.out.println("****");
        System.out.println(strings);
        return strings.first() + "\n" + strings.last();
    }

    public static void main(String[] args) {

        String s = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
        int k = 30;

        System.out.println(getSmallestAndLargest(s, k));
        StringBuilder stringBuilder = new StringBuilder(s);
        String s1 = stringBuilder.reverse().toString();
        if (s.equals(s1)) {
            System.out.println("yes");
        }
    }
}
