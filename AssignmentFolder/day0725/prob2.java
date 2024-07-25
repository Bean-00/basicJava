package AssignmentFolder.day0725;

public class prob2 {
    public static void main(String[] args) {
        int n = 15;
        int sum = 0;
        int term = 1;

        int sum2 = 0;
        int term2 = 1;

        double fomulaSum = n * (Math.pow(n, 2) + 5) / 6;

        for (int j = 0; j < 15; j++) {
            term += j;
            sum += term;
            System.out.println("sum: " + sum);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                term2++;
            }
            sum2 += term2;
            System.out.println("sum2: " + sum2);
        }

//        fomulaSum = (2 ^ n) - 1;

        System.out.println(n + "번째까지의 합: " + fomulaSum);
        System.out.println(n + "번째까지의 합: " + sum);
        System.out.println(n + "번째까지의 합: " + sum2);

    }
}