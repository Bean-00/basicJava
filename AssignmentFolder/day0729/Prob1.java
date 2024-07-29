package AssignmentFolder.day0729;



public class Prob1 {
    public void printSeason(int month) {
        if (month == 3 || month == 4 || month == 5){
            System.out.println("봄에 태어나셨네요.");
        } else if (month == 6 || month == 7 || month == 8){
            System.out.println("여름에 태어나셨네요.");
        } else if (month == 9 || month == 10 || month == 11){
            System.out.println("가을에 태어나셨네요.");
        } else {
            System.out.println("겨울에 태어나셨네요.");
        }

    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("하나의 월만 입력해주세요.");
            System.exit(0);
        }
        int month = Integer.parseInt(args[0]);
        if (month < 1 || month > 12) {
            System.out.println("1월에서 12월까지만 입력해주세요.");
            System.exit(0);
        }
        new Prob1().printSeason(month);
    }
}