package types_inheritance;

import java.lang.reflect.ParameterizedType;

public class Main {
    public static void main(String[] args) {
        Book book = new ProgrammerBook();
        ProgrammerBook programmerBook = new ProgrammerBook();
        //переменной супркласса присваивается объект подкласса подкласса - разрешенное приведение
        Book goodBook = programmerBook;

        //переменной подкласа присваевается обьект суперкласса, возмонжости класса
        // расширяются поэтому нужно приветси тип
        ProgrammerBook goodProgrBook = (ProgrammerBook) book;

        Book simpleBook = null;
//        ProgrammerBook simpleProgrBook = (ProgrammerBook) simpleBook; //error. Class Cast Exception
        ProgrammerBook simpleProgrBook = null;
        if(simpleBook instanceof ProgrammerBook){
            simpleProgrBook = (ProgrammerBook) simpleBook;
        }
    }
}
class Book{
    public Book(){
        System.out.println("book");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
class ProgrammerBook extends Book{
    public ProgrammerBook(){
        System.out.println("Progr book");
    }
}

