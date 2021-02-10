package dynamic_static_binding;

public class Main {
    public static void main(String[] args) {
        Insurance current = new CarInsurance();

        // Динамическое связывание на основе объекта
        int premium = current.premium();

        // Статическое связывание на основе класса
        String category = current.category();

        System.out.println("premium : " + premium);
        System.out.println("category : " + category);
    }
}

class Insurance{
    public static final int LOW = 100;

    public int premium(){
        return LOW;
    }

    public static String category(){
        return "dynamic_static_binding.Insurance";
    }

}

class CarInsurance extends Insurance{
    public static final int HIGH = 200;

    public int premium(){
        return HIGH;
    }

    public static String category(){
        return "Car dynamic_static_binding.Insurance";
    }

}