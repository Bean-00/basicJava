package AssignmentFolder.day0807;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Grade {
    public void printALL(String type, String grade) {
        System.out.println("모두의 " + type + grade + "점 입니다.");
    }
    public void printGrade() {
        try (BufferedReader br = new BufferedReader
                (new FileReader("AssignmentFolder/day0807/files/score.txt"))){
            String fileLine;
            String[] fileInfo = new String[2];
            int sum = 0;
            int checkline = 0;

            while ((fileLine = br.readLine()) != null) {
                fileInfo = fileLine.split(",");
                System.out.println(fileInfo[0] + "의 점수는 " + fileInfo[1] + " 입니다.");
                sum += Integer.parseInt(fileInfo[1]);
                checkline++;
            }
            printALL("총점은 " , Integer.toString(sum));
            printALL("평균은 " , Integer.toString(sum/checkline));


        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    public static void main(String[] args) {
        new Grade().printGrade();
    }
}
