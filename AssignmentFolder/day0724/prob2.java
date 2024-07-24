package AssignmentFolder.day0724;

public class prob2 {
    public static void main(String[] args) {
        int limit = 50;
        int num = 2;
        int countDivided = 0;

        while (num <= limit) {
            for (int i = 2; i <= num; i++) {
                if (num % i == 0) {
                    countDivided++;
                }
            }
            if (countDivided == 1)
                System.out.println(num);
            countDivided = 0;
            num++;
        }

    }
}