package StepicCourse;

import java.util.Objects;

public class Phone{
    private String name;
    private float price;
    
    public boolean myequals(Object o){
        if(this == o){
            return true;
        }
        else if (getClass() != o.getClass()){
            return false;
        }
        Phone that = (Phone) o;
        return name.equals(that.name) && price == that.price;
    }
    int hashcode(){
        return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Float.compare(phone.price, price) == 0 && Objects.equals(name, phone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}