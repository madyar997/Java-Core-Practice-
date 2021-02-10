package StepicCourse;
import java.util.Objects;

public class EqualsANdHashCodePractice {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.hashCode());
    }
}

class ComplexNumber{
    int re;
    int im;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return re == that.re && im == that.im;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}

