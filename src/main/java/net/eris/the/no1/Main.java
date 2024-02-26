package net.eris.the.no1;

import net.eris.the.common.LinkedListInterface;

public class Main {
    public static void main(String[] args) {
        LinkedListInterface<String> myLinkedList = new MyLinkedList<>();

        // 6개를 동시에 추가
        myLinkedList.add("1st");
        myLinkedList.add("2nd");
        myLinkedList.add("3rd");
        myLinkedList.add("4th");
        myLinkedList.add("5th");
        myLinkedList.add("6th");
        System.out.println(myLinkedList);

        // 맨앞 제거
        myLinkedList.delete(0);
        System.out.println(myLinkedList);

        // 맨뒤 제거
        System.out.println(myLinkedList.getSize());
        myLinkedList.delete(4);
        System.out.println(myLinkedList);
    }
}