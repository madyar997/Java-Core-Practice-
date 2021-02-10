package lambda_practice;

public class LambdaAndVariablesExample {
    //можем менять значение переменных на уровне класса
    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {
        int x1 = 12;
        int y1 = 15;
        Operation op = ()->{
            x = 30;
            return x + y;
        };
        System.out.println(x1);
        x1 = x1+10;
        System.out.println(x1);

        System.out.println(op.calculate());

    }
}

//Lambda and local variables
//lambda can be using variables that has been instantiated on a privace level above, for example
//in classes or in methods where do lambda invoked
interface Operation {
    int calculate();
}
