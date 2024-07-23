package jb03.part08;

public class User02 {
    String name;
    int javaLevel;

    public User02() {
        System.out.println("Constructor Method");
        name = "홍길동";
        javaLevel = 0;
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