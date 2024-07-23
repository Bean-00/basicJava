package jb03.part04;

public class MethodSyntaxTestApp {
    public static void main(String[] args) {
        MethodSyntax methodSyntax = new MethodSyntax();

        System.out.println("\n=========================");
        methodSyntax.browserOn();

        System.out.println("\n=========================");
        boolean result = methodSyntax.documentWork();
        System.out.println("doc작업 유무: " + result);

        System.out.println("\n=========================");
        int value = methodSyntax.sum(1,1);
        System.out.println("계산 결과값: " + value);
        //System.out.println("계산 결과값: " + methodSyntax.sum(1,1);

        System.out.println("\n=========================");
        System.out.println("Field 정보 name: " + methodSyntax.getName());

        System.out.println("\n=========================");
        System.out.println("Field 정보 add: " + methodSyntax.getAdd());

        System.out.println("\n=========================");
        String[] info = methodSyntax.getAllIngormation();
        System.out.println("Field 정보 모두 출력");

        for(int i = 0; i < info.length; i++) {
            System.out.println((i+1) + ". " + info[i]);
        }

    }
}