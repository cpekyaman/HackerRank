package com.hackerrank.javacl.advanced;

/**
 * Created by raistlin on 9/4/2017.
 */
public class FactoryPattern {
    public static void main(String[] args) {
        System.out.println(new FoodFactory().getFood("cake").getType());
        System.out.println(new FoodFactory().getFood("caKe").getType());
        System.out.println(new FoodFactory().getFood("pizzA").getType());
        System.out.println(new FoodFactory().getFood("Pizza").getType());

    }
}


interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        String input = order.toLowerCase();
        String className = input.substring(0, 1).toUpperCase() + input.substring(1);
        try {
            return (Food) FoodFactory.class.getClassLoader().loadClass(FoodFactory.class.getPackage().getName() + "." + className).newInstance();
        } catch (ClassNotFoundException e) {
            // do nothing
        } catch (IllegalAccessException e) {
            // do nothing
        } catch (InstantiationException e) {
            // do nothing
        }
        return null;
    }
}