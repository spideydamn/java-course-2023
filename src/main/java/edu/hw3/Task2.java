package edu.hw3;

import java.util.LinkedList;
import java.util.Stack;

public class Task2 {
    private Task2() {}

    public static String[] clusterize(String brackets) {
        if (brackets == null) {
            return null;
        }

        Stack<Integer> stackOfBrackets = new Stack<>();
        LinkedList<Integer[]> ansQueue = new LinkedList<>();

        int lenAns = 0;

        int len = brackets.length();
        int lastOpenBrackets = -1;
        for (int i = 0; i < len; ++i) {
            if (brackets.charAt(i) == '(') {
                stackOfBrackets.add(i);
            } else if (!stackOfBrackets.isEmpty()) {
                lastOpenBrackets = stackOfBrackets.getLast();
                stackOfBrackets.pop();
                if (stackOfBrackets.isEmpty()) {
                    ansQueue.addLast(new Integer[]{lastOpenBrackets, i + 1});
                    ++lenAns;
                }
            } else {
                return null;
            }
        }

        if (!stackOfBrackets.isEmpty()) {
            return null;
        }

        String[] ans = new String[lenAns];
        int i = 0;
        Integer[] args;

        while (!ansQueue.isEmpty()) {
            args = ansQueue.pollFirst();
            ans[i] = brackets.substring(args[0], args[1]);
            ++i;
        }

        return ans;
    }
}
