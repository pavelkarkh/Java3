package ru.pkarh.java3.l1.task2;

import java.util.ArrayList;

public class Task2 {

    public static <T> ArrayList<T> transferArrayToList(T[] arr) {

        ArrayList<T> list = new ArrayList<>();

        if (arr.length > 0) {

            /*
            * вместо цикла можно использовать
            * list.addAll(arr)
            *
            * */

            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
        }

        return list;
    }
}
