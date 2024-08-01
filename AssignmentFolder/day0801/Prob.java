package AssignmentFolder.day0801;

public class Prob {
    static void makeTree(int height) {
        int star = 1;
        int blank = height - 1;
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j <= blank; j++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= star; z++) {
                System.out.print("*");
            }
            System.out.println("");
            star += 2;
            blank--;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("하나의 숫자를 입력해주세요");
            System.exit(0);
        }
        makeTree(Integer.parseInt(args[0]));
    }
}