package effectiveJava.item1.factoryMethod;

public class MealFactory {

    public static Meal createMeal(String name) {

        Class<?> clz = null;
        try {
            clz = Class.forName(name);
            try {
                return (Meal) clz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // null 예외 고려 X
        return null;
    }

}
