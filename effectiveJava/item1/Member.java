package effectiveJava.item1;

public class Member {

    private final String name;
    private final String age;
    private final String address;


    private Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public Member(String name, String age) {
        this(name, age, "기본");
    }

    public Member(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static Member createMemberWithNameAndAddr(String name, String address) {
        return new Member(name, null, address);
    }

    @Override
    public String toString() {
        return "Member{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            ", address='" + address + '\'' +
            '}';
    }

    public static class Builder {

        private String name;
        private String age;
        private String address;

        public Builder() {

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Member build() {
            return new Member(this);
        }

    }
}
