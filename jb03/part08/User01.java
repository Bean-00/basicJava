package jb03.part08;

public class User01 {
    String name = "홍길동";
    int javaLevel = 0;

    public User01() {
        System.out.println("Constructor Method");
    }

    public String getName() {
        return name;
    }

    public int getJavaLevel()  {
        return javaLevel;
    }

    public static void main(String[] args) {
        System.out.println("===============");
        User03 user = new User03();
        System.out.println("===============");

        System.out.println("name: " + user.getName());
        System.out.println("javaLevel: " + user.getJavaLevel());
    }

}