package Patterns;

import java.util.Scanner;

public class MyFactoryExample {
    public static void main(String[] args) {
//        PizzaFactory
    }
}
interface Pizza{}
class MargaritaPizza implements Pizza{}
class AlCaponePizza implements Pizza{}
class HAwaiianPizza implements Pizza{}

enum PizzaType{
    MARGARITA,
    AL_CAPONE,
    HAWAIIAN
}

class PizzaFactory{
    private Pizza pizza = null;
    public Pizza getPizza(PizzaType type){
        switch(type){
            case HAWAIIAN -> {
                pizza = new HAwaiianPizza();
            }
            case AL_CAPONE -> {
                pizza = new AlCaponePizza();
            }
            case MARGARITA -> {
                pizza = new MargaritaPizza();
            }
        }
        warmPizza(pizza);
        cutPizza(pizza);
        return pizza;
    }

    private void warmPizza(Pizza pizza){
        System.out.println("Pizza is warm");
    }

    private void cutPizza(Pizza pizza){
        System.out.println("Pizza is cutted into pieces");
    }
}

class PizzaShop{
    private PizzaFactory factory;

    public PizzaShop(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza makePizza(PizzaType type){
        return factory.getPizza(type);
    }

    public void runPizzeria(){
        UserDialog userDialog = new UserDialog();

    }
}

class UserDialog{

    public void start(){
        System.out.println("Выберите тип пиццы");

    }
}