package effectiveJava.item1;

public class Main {

    public static void main(String[] args) {

        Member m1 = new Member("kim sang hoon", "29살");
        Member m2 = new Member("kim sang hoon", "29살", "제주도");

        System.out.println(m1.toString());
        System.out.println(m2.toString());

        Member m3 = new Member.Builder().
            setAddress("제주도").
            setName("김상훈").
            setAge("29살").
            build();

        System.out.println(m3);
    }

}
