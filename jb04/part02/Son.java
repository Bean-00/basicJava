package jb04.part02;

public class Son extends Iam{
    String school;

    public Son(){
        System.out.println("Son class default constructor");
    }

    public void setSchool(String str) {
        school = str;
    }

    public String getSchool() {
        return school;
    }

    public static void main(String[] args) {
        Son son = new Son();

        son.setName("홍길동");
        son.setAge(50);
        son.setJob("개발자준비중");
        son.setSchool("아이티교육센터");

        System.out.println("name: " + son.getName());
        System.out.println("age: " + son.getAge());
        System.out.println("job: " + son.getJob());
        System.out.println("school: " + son.getSchool());

    }
}