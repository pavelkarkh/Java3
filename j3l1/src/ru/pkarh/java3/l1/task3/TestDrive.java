package ru.pkarh.java3.l1.task3;

public class TestDrive {

    private final static float APPLE_WEIGHT = 1.0f;
    private final static float ORANGE_WEIGHT = 1.5f;

    public static void main(String[] args) {

        Box<Orange> boxWithOranges = new Box<>();
        boxWithOranges.addFruit(new Orange(ORANGE_WEIGHT));
        boxWithOranges.addFruit(new Orange(ORANGE_WEIGHT));
        //boxWithOranges.addFruit(new Orange(ORANGE_WEIGHT));
        boxWithOranges.showBox();

        Box<Apple> boxWithApples = new Box<>();
        boxWithApples.addFruit(new Apple(APPLE_WEIGHT));
        boxWithApples.addFruit(new Apple(APPLE_WEIGHT));
        boxWithApples.addFruit(new Apple(APPLE_WEIGHT));
        boxWithApples.showBox();

        System.out.println("\nСравниваем две коробки. Они равны? - " + boxWithOranges.compareBox(boxWithApples));

        Box<Orange> boxWithOranges2 = new Box<>();
        boxWithOranges2.addFruit(new Orange(ORANGE_WEIGHT));
        boxWithOranges2.addFruit(new Orange(ORANGE_WEIGHT));
        boxWithOranges2.addFruit(new Orange(ORANGE_WEIGHT));
        boxWithOranges2.showBox();

        boxWithOranges.addAll(boxWithOranges2);
        boxWithOranges.showBox();
    }

}
