package jp02.part02;

public class ExceptionTest03 {
    private int sum;
    private int avg;

    public ExceptionTest03(){
    }

    public void sum (int x, int y) {
        System.out.println("1.==> sum 시작");
        sum = x + y;
        System.out.println("1.==> 합: " + sum);
        System.out.println("1.==> sum 끝");
    }

    public void avg (int z) throws ArithmeticException {
        System.out.println("2.==> avg 시작");
        //z = 0 일 경우 불능
        avg = sum / z;
        System.out.println("2.==> 평균: " + avg);
        System.out.println("2.==> avg 끝");
    }

    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        int j = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        ExceptionTest03 et = new ExceptionTest03();
        et.sum(i, j);
        et.avg(k);

        System.out.println("메인 메서드 종료");
    }
}
