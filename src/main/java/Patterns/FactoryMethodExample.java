package Patterns;

public class FactoryMethodExample {
    public static void main(String[] args) {

    }
}

class Coffee {
    public void grindCoffe(){
        System.out.println("coffee is grinding");
    }
    public void makeCoffee(){
        System.out.println("coffee is making");
    }

    public void pourIntoCup(){
        System.out.println("coffee is pouring into cup");
    }
}

class Amerikano extends Coffee{}
class Cappuccino extends Coffee{}
class CaffeLatte extends Coffee{}
class Espresso extends Coffee{}

enum CoffeeType {
    AMERIKANO,
    CAPPUCCINO,
    CAFFE_LATTE,
    ESPRESSO
}

class CofeeShop {
    private final SimpleCoffeeFactory coffeeFactory;

    CofeeShop(SimpleCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee(CoffeeType type){
        Coffee coffee = coffeeFactory.createCoffee(type);
        coffee.grindCoffe();
        coffee.makeCoffee();
        coffee.pourIntoCup();
        System.out.println("Ваш кофе готов приходите еще");
        return coffee;
    }
}

class SimpleCoffeeFactory{
    public Coffee createCoffee(CoffeeType type){
        Coffee coffee = null;
        switch(type){
            case AMERIKANO:
                coffee = new Amerikano();
                break;
            case ESPRESSO:
                coffee = new Espresso();
                break;
            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
            case CAFFE_LATTE:
                coffee = new CaffeLatte();
                break;
        }
        return coffee;
    }
}