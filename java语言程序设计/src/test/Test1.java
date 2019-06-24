package test;

import org.junit.Test;

public class Test1
{
    public static void main(String[] args) throws Exception {
        Animal a = new Animal();
        animalCry(a);
        Dog d = new Dog();
    }
    static void animalCry(Animal a) throws Exception {
        a.shout();
    }
    @Test
    public void test1(){
        Animal animal = new Dog();//Upcasting
        animal.f();
    }
}


class Animal{
    public void shout() throws Exception{
        System.out.println("叫");
    }
    public void f(){
        System.out.println("Animal的f()方法");
    }
}
class Dog extends Animal {

    @Override
    public void shout() throws Exception {
        super.shout();
    }
    /**
     * 返回值类型不能够用来区分重载的方法
     */
//    public int f(){
//
//    }

    @Override
    public void f() {
        System.out.println("Dog的f()方法");
    }
}