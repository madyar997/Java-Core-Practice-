package interfaces_practice;

public class Main {
    public static void main(String[] args) {
        Square square = () -> 2*2;
        Square.RedSquare square1 = () -> 2*4;
    }
}

interface Square{
    double PI = 3.141559;//по умолчаннию поля final static
    double square(); // по умолчанию public
    interface RedSquare{
        double square();
    }
}
//Свойства интерфейсов
// 1) можно обьявлять интерфейсные ссылки
//2) Интерфейсные ссылки должны ссылаться на обьекты классов, реализующих данный интерфейс