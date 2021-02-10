package lambda_practice;

public class LambdaPractice {
    public static void main(String[] args) {
        //with lambda expressions
        Operationable operation;
        operation = (Integer::sum);

        Operationable operationable1 = (int x, int y) -> x*y;
        Operationable operationable2 = (int x, int y) -> x/y;
        Operationable operationable3 = (int x, int y) -> x-y;
        NoParameter noParameter = ()-> 222-1;
        System.out.println(noParameter.doSomething());
        OneParameter oneParameter = n -> n * n;
        System.out.println(oneParameter.doSomething(5));
        //with anonymous classes
        Operationable operation1 = new Operationable() {
            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        };
        int result = operation.calculate(10, 20);
        System.out.println(result);

        Printable printer = System.out::println;
        printer.print("keloke");
    }
}

interface Operationable{
    int calculate(int x, int y);
}
//Функциональынй интерфейс содержит !!! один !!! метод без реализации
interface NoParameter{
    int doSomething();
}

interface OneParameter{
    int doSomething(int n);
}

//Terminal lambda expression do not return any value
interface Printable{
    void print(String s);
}

