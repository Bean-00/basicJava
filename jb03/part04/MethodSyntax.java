package jb03.part04;

public class MethodSyntax {
    String name = "홍길동";
    String add = "한양";

    public void browserOn(){
        System.out.println("브라우저를 켜다");
    }

    public boolean documentWork() {
        System.out.println("document 작업을 하고 작업완성 유무를 boolean return");
        return true;
    }

    public int sum(int a, int b) {
        System.out.println("<<" + a + ">>" + "<<" + b + ">>값을 받아 합 return");
        return (a + b);
    }

    public String getName() {
        System.out.println("이름을 전달합니다");
        return name;
    }

    public String getAdd() {
        System.out.println("주소를 전달합니다");
        return add;
    }

    public String[] getAllIngormation() {
        String[] str = {name, add};
        //String[] str = {"홍길동, "한양"};
        return str;
    }
}