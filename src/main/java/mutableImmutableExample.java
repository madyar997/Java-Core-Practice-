public class mutableImmutableExample {
    public static void main(String[] args) {
        String s = "I love JAVA";
        String s1 = s;

        System.out.println(s);
        System.out.println(s1);

        s1 = "I love Python";
        System.out.println(s);
        System.out.println(s1);
    }
}
