package AssignmentFolder.day0730;

class Person {
    String name;
    int age;

    void print() {
        System.out.print("이  름 : " + this.name + "  나 이: " + this.age);
    }
}

class Student extends Person {
    int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    void print() {
        super.print();
        System.out.println("  학   번: " + this.id);
    }


}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    @Override
    void print() {
        super.print();
        System.out.println("  담당과목: " + this.subject);
    }
}

class Employee extends Person {
    String dept;

    public Employee(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    void print() {
        super.print();
        System.out.println("  부   서: " + this.dept);
    }
}

public class Prob {

    public static void main(String[] args) {
        Student s = new Student("홍길동", 20, 200201);
        Teacher t = new Teacher("이순신", 30, "JAVA");
        Employee e = new Employee("유관순", 40, "교무과");

        s.print();
        t.print();
        e.print();
    }

}
