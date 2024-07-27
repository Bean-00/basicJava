package jp01.part09;

import AssignmentFolder.day0726.SortUtil;

import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        String value = new String("1. 홍길동");
        queue.offer(value);
        queue.offer(new String("2. 이순신"));
        queue.offer("3. 주몽");

        String str1 = (String) queue.poll();
        System.out.println(str1);

        String str2 = (String) queue.poll();
        System.out.println(str2);

        while (queue.peek() != null) {
            String str3 = (String) queue.poll();
            System.out.println(str3);
        }
    }
}