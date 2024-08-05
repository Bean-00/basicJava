package AssignmentFolder.day0805;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class FileController {
    public static void reverseLine(String InputFileName, String OutputFileName) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(InputFileName));
            bw = new BufferedWriter(new FileWriter(OutputFileName));

            Deque<String> stack = new ArrayDeque<String>();
            while (br.readLine() != null) {
                stack.push(br.readLine());
            }
            while (!stack.isEmpty()) {
                bw.write(stack.pop() + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException error) {
            error.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {
        FileController c = new FileController();

        String oldf = "./AssignmentFolder/day0805/files/oldf.txt";
        String newf = "./AssignmentFolder/day0805/files/newf.txt";
        c.reverseLine(oldf, newf);
    }

}
