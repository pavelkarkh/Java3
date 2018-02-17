package ru.pkarh.java3.l1.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> box;
    private float fruitWeight;

    Box() {
        fruitWeight = 0;
        box = new ArrayList<>();
    }

    public ArrayList<T> getBox() {
        return box;
    }

    public void addFruit(T fruit) {
        box.add(fruit);
        if (fruitWeight == 0) {
            fruitWeight = fruit.getWeight();
        }
    }
    
    public float getWeight() {
        return fruitWeight * box.size();
    }

    public boolean compareBox(Box<?> otherBox) {
        return getWeight() == otherBox.getWeight();
    }

    public void addAll(Box<T> otherBox) {
        box.addAll(otherBox.getBox());
        if (fruitWeight == 0) {
            ArrayList<T> list = otherBox.getBox();
            fruitWeight = list.get(0).getWeight();
        }
    }

    public void showBox() {
        System.out.println();
        System.out.println("Count fruit: " + box.size());
        System.out.println("Fruit weight: " + fruitWeight);
        System.out.println("Box weight: " + getWeight());
    }
}
