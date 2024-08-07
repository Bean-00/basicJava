package AssignmentFolder.day0807;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Vector;

class Score {
    private String name;
    private int kor;
    private int eng;
    private int math;
    private int sum;

    public Score() {

    }

    public Score(String name, int kor, int eng, int math, int sum) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum() {
        this.sum = this.kor + this.eng + this.math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String toString() {
        return name + " " + kor + " " + eng + " " + math + " " + sum;
    }

}

public class Prob2 {
    public Vector getScore(String filename) {
        final int NAME = 0;
        final int KOR = 1;
        final int ENG = 2;
        final int MATH = 3;
        Vector<Score> scores = new Vector();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String str = null;
            String[] strArr = new String[4];
            while ((str = br.readLine()) != null) {
                Score score = new Score();
                strArr = str.split("/");
                score.setName(strArr[NAME]);
                score.setKor(Integer.parseInt(strArr[KOR]));
                score.setEng(Integer.parseInt(strArr[ENG]));
                score.setMath(Integer.parseInt(strArr[MATH]));
                score.setSum();
                scores.add(score);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return scores;
    }

    public static void main(String[] args) {
        Prob2 p2 = new Prob2();
        final String PATH = "AssignmentFolder/day0807/files/";

        Vector scores = p2.getScore(PATH + "data.txt");
        for (int i = 0; i < scores.size(); i++) {
            Score score = (Score)scores.get(i);
            System.out.println(score.getName() + " : "
                    + score.getKor() + " " + score.getEng() + " "
                    + score.getMath() + " " + score.getSum());
        }


    }
}
