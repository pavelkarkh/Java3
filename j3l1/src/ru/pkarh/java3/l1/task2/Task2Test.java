package ru.pkarh.java3.l1.task2;

import ru.pkarh.java3.l1.task1.Task1Test;

import java.util.ArrayList;

public class Task2Test {

    public static void main(String[] args) {

        Integer arr[] = {1, 2, 3, 4, 5};
        Task1Test.printArray(arr);

        ArrayList<Integer> list;
        list = Task2.transferArrayToList(arr);

        System.out.println(list.getClass());
        System.out.println(list);

    }

}
