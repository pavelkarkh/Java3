package ru.pkarh.java3.l1.task1;

public class Task1 {

    public static <T> T[] swapElements(T[] arr, int indexFirst, int indexSecond) {
        T temp = arr[indexFirst];
        arr[indexFirst] = arr[indexSecond];
        arr[indexSecond] = temp;
        return arr;
    }

}
