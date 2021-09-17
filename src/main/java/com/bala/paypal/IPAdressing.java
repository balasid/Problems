package com.bala.paypal;

import java.util.ArrayList;
import java.util.List;

public class IPAdressing {
    public static void main(String[] args) {
        String ip = "25525511135";
        int n = ip.length();
        List<String> possibleIPs = new ArrayList<>();
        for (int i = 1; i < n && i < 4; i++) {
            String firstPart = ip.substring(0, i);
            if (!isValid(firstPart)) {
                continue;
            }
            for (int j = 1; i + j < n && j < 4; j++) {
                String secondPart = ip.substring(i, i + j);
                if (!isValid(secondPart)) {
                    continue;
                }
                for (int k = 1; i + j + k < n && k < 4; k++) {
                    String thirdPart = ip.substring(i + j, i + j + k);
                    String fourthPart = ip.substring(i + j + k);
                    if (!isValid(thirdPart) || !isValid(fourthPart)) {
                        continue;
                    }
                    possibleIPs.add(firstPart + "." + secondPart + "." + thirdPart + "." + fourthPart);
                }
            }
        }
        System.out.println(possibleIPs);
    }

    private static boolean isValid(String partOfIP) {
        int length = partOfIP.length();
        if (length > 3) {
            return false;
        }
        if (partOfIP.startsWith("0") && length > 1) {
            return false;
        }
        int ipInt = Integer.parseInt(partOfIP);
        return ipInt >= 0 && ipInt <= 255;
    }
}
