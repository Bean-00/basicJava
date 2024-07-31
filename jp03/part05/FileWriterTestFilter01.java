package jp03.part05;

import java.io.*;

public class FileWriterTestFilter01 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = null;
        BufferedWriter bw = null;
        String fileName = "";
        String copyFileName = "";

        int readCount = 0;

        System.out.println("copy할 file 이름을 입력하세요: ");

        fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();

        br = new BufferedReader(new FileReader(fileName));

        copyFileName = fileName + "_copy";

        bw = new BufferedWriter(new FileWriter(copyFileName));

        String source = null;
        while ((source = br.readLine()) != null) {
            bw.write(source);
            readCount++;
        }
        bw.flush();


        br.close();
        br.close();

        System.out.println("===============================");
        System.out.println("======>> read count(횟수): " + readCount);
        System.out.println("===============================");
    }
}
