package jb03.part08;

public class User03 {
    String name;
    int javaLevel;

    public User03() {
        System.out.println("나는 생성자");
        name = "홍길동";
        javaLevel = 0;
    }

    public User03(String str) {
        System.out.println("나는 String을 인자로 받아 name을 초기화하는 생성자");
        name = str;
    }

    public User03(int i) {
        System.out.println("나는 int를 인자로 받아 javaLevel을 초기화하는 생성자");
        javaLevel = i;
    }

    public User03(String str, int i) {
        System.out.println("나는 String, int를 인자로 받아 name, javaLevel을 초기화하는 생성자");
        name = str;
        javaLevel = i;
    }

    public String getName() {
        return name;
    }

    public int getJavaLevel()  {
        return javaLevel;
    }

    public static void main(String[] args) {
        System.out.println("===============");
        User03 user01 = new User03();
        System.out.println("name = " + user01.getName());
        System.out.println("javaLevel = " + user01.getJavaLevel());

        System.out.println("===============");
        User03 user02 = new User03("홍길순");
        System.out.println("name = " + user02.getName());
        System.out.println("javaLevel = " + user02.getJavaLevel());

        System.out.println("===============");
        User03 user03 = new User03("이순신", 200);
        System.out.println("name = " + user03.getName());
        System.out.println("javaLevel = " + user03.getJavaLevel());
    }

}