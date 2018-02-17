package ru.pkarh.java3.l1.task1;

public class Task1Test {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printArray(array);

        Integer[] newArray;
        newArray = Task1.swapElements(array, 2, 5);
        printArray(newArray);

    }

    public static <T> void printArray(T[] arr) {
        if (arr.length > 0) {
            System.out.println(arr.getClass());
            System.out.print("[");
            for (int i=0; i< arr.length; i++){
                if (i != (arr.length - 1)) {
                 System.out.print(arr[i] + ", ");
                } else {
                    System.out.print(arr[i]);
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
