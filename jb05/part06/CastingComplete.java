package jb05.part06;

class Super {
    public void a() {
        System.out.println("Super: a()");
    }
}

class Sub extends Super {
    public void a() {
        System.out.println("overriding된 Sub: a()");
    }
    public void b() {
        System.out.println("Sub: b()");
    }
}

public class CastingComplete {
    public static void main(String[] args) {
        System.out.println("\n여기는 Super s1 = new Super()부분");
        Super s1 = new Super();
        s1.a();

        System.out.println("\n여기는 Sub s2 = new Sub()부분");
        Sub s2 = new Sub();
        s2.a();
        s2.b();

        System.out.println("\n여기는 Super s3 = new Sub()부분");
        Super s3 = new Sub();
        s3.a();
        // 해당 경우는 에러 s3.b();

        System.out.println("\n s3는 b()에 접근 불가하다.");
        System.out.println("casting 연산자를 이용 Sub sub = (Sub)s3 명시적 형변환");
        Sub sub = (Sub)s3;
        sub.b();

//        Sub s4 = new Super();
    }
}