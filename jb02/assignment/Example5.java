package jb02.assignment;

public class Example5 {
    public static void main(String[] args) {
        String[][] text = new String[9][9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                text[i][j] = Integer.toString((i + 1) * (j + 1));
                System.out.println("text[" + i + "]["+ j +"]: " + (i + 1) + " * " + (j + 1) + " = " + text[i][j]);
            }
        }

    }

}