package effectiveJava.item1.factoryMethod;

public class Main {

    public static void main(String[] args) {

        Meal meal = MealFactory.createMeal("effectiveJava.item1.factoryMethod.Bread");

        meal.eaten();
    }

}
