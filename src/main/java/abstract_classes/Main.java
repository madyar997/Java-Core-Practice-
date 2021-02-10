package abstract_classes;

public class Main {
    public static void main(String[] args) {
        Course course1 = new BaseCourse();
        Course course2 = new OptionalCourse();
        System.out.println(course1.getInformation());
        System.out.println(course2.getInformation());
    }
}

abstract class Course{
    public abstract String getInformation();
}
class BaseCourse extends Course{

    @Override
    public String getInformation() {
        return "Base Course";
    }
}

class OptionalCourse extends Course{

    @Override
    public String getInformation() {
        return "optioinal course";
    }
}