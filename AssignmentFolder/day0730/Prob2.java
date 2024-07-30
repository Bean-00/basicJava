package AssignmentFolder.day0730;

class Student2 {
    String name;
    int age;
    int id;

    public Student2(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    void print() {
        System.out.print("이  름 : " + this.name + "  나 이: " + this.age);
        System.out.println("  학   번: " + this.id);
    }


}

class Teacher2 {
    String name;
    int age;
    String subject;

    public Teacher2 (String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    void print() {
        System.out.print("이  름 : " + this.name + "  나 이: " + this.age);
        System.out.println("  담당과목: " + this.subject);
    }
}

class Employee2 {
    String name;
    int age;
    String dept;

    public Employee2 (String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    void print() {
        System.out.print("이  름 : " + this.name + "  나 이: " + this.age);
        System.out.println("  부   서: " + this.dept);
    }
}

public class Prob2 {

    public static void main(String[] args) {
        Student2 s = new Student2("홍길동", 20, 200201);
        Teacher2 t = new Teacher2("이순신", 30, "JAVA");
        Employee2 e = new Employee2("유관순", 40, "교무과");

        s.print();
        t.print();
        e.print();
    }

}
