package ch13;


interface Edible{
    String howToEat();
}
abstract class Animal{
    public abstract String sound();
}
class Chiken extends Animal implements Edible{

    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }

    @Override
    public String sound() {
        return "Chicken: cock-a-doodle-doo";
    }
}
class Tiger extends Animal{
    @Override
    public String sound() {
        return "Tiger: RRAAOORR";
    }
}
abstract class Fruit implements Edible{

}
class Apple extends Fruit{

    @Override
    public String howToEat() {
        return "Apple: Make apple cider";
    }
}
class Orange extends Fruit{

    @Override
    public String howToEat() {
        return "Orange: Make Orange juice";
    }
}
public class TestEdible {
    public static void main(String[] args) {
        Object[] objects = {
                new Apple(),
                new Chiken(),
                new Orange(),
                new Tiger()
        };
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Edible) {
                System.out.println(((Edible) objects[i]).howToEat());
            }
            if (objects[i] instanceof Animal) {
                System.out.println(((Animal) objects[i]).sound());
            }
        }
    }
}
