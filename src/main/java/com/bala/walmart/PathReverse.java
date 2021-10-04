package com.bala.walmart;

import java.util.Stack;

/**
 * case1 :
 * path = "/usr/admin/home/desktop/downloads/apps/desktop/system/../../user/.";
 * output = /usr/admin/home/desktop/downloads/apps/user
 * <p>
 * case2 :
 * * path = "/usr/./../";
 * case3 :
 * * path = "/./usr/../"
 * case4 :
 * * path = "/./../usr/./" -> /usr
 * case4 :
 * * path = "/usr/admin/home/desktop/../downloads/apps/./.." -> /usr
 */
public class PathReverse {
    public static void main(String[] args) {
        String path = "/usr/admin/home/desktop/../downloads/apps/./..";
        Stack<String> pathStack = new Stack<>();
        String[] split = path.split("/");
        for (String splitPath : split) {
            if (splitPath.trim().isEmpty()) {
                continue;
            }
            if (splitPath.equals("..")) {
                if (!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            } else if (!splitPath.equals(".")) {
                pathStack.push(splitPath);
            }
        }
        String output = "";
        while (!pathStack.isEmpty()) {
            String pop = pathStack.pop();
            pop += output;
            output = "/" + pop;
        }
        if (output.isEmpty()) {
            output += "/";
        }
        System.out.println(output);

    }
}
