package jp02.part05;

class A {
    public void abc (String message) {
        System.out.println(":: " + this.getClass().getName() + "start..");
        System.out.println("::abc() " + message);
        System.out.println(":: " + this.getClass().getName() + "end..");
    }
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        System.out.println("1.=================");
        A a = new A();
        a.abc("Hello");

        System.out.println("2.=================");
        new A().abc("Hello");

        //=======================아래의 코드를 이해
//        public class B extends A {
//            public void def (String message) {
//                System.out.println(":: HI" + message);
//            }
//        }
//        new B().abc("Hello");
//        new B().def("Hello");
        //위의 코드를 이해한다면 아래의 코드는 anonymous
        System.out.println("3.===============");
        new A() {
            public void def (String message) {
                System.out.println(":: " + this.getClass().getName() + "start..");
                System.out.println("::def() " + message);
                System.out.println(":: " + this.getClass().getName() + "end..");
            }
        }.abc("Hello");

        System.out.println("4.===============");
        new A() {
            public void def (String message) {
                System.out.println(":: " + this.getClass().getName() + "start..");
                System.out.println("::def() " + message);
                System.out.println(":: " + this.getClass().getName() + "end..");
            }
        }.def("Hello");
    }
}
