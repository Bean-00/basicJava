package AssignmentFolder.day0806;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCalculator {
    public void addCalculateResult(String inputFileName) {
//        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println("str: " + str);
                num.add(Integer.parseInt(str));
            }
        } catch (IOException e) {
            throw new RuntimeException("file Not Found");
        }

        int plusSum = 0;
        int multiplySum = 1;

        for (int number : num) {
            System.out.println(number);
            plusSum += number;
            multiplySum *= number;
        }


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFileName, true))) {
            bw.write("\n" + String.valueOf(plusSum) + "\n" + String.valueOf(multiplySum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) throws Exception {
        final String FILE_PATH = "/Users/bean/bitcamp/basicJavaSyntax/AssignmentFolder/day0806/files/";

        FileCalculator fc = new FileCalculator();
        fc.addCalculateResult(FILE_PATH + "test.dat");

    }
}