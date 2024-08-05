package AssignmentFolder.day0805;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCompareUtil {
    public static List<String> compareFile (String fstFileName, String sndFileName) {

        List<String> fstStrList = readStringByFile(fstFileName);
        List<String> sndStrList = readStringByFile(sndFileName);
        List<String> result = new ArrayList<>();

        int index = 0;

        for(String fstStr : fstStrList) {
            String sndStr = sndStrList.get(index);
            if(!fstStr.equals(sndStr)) {
                result.add(appendLineNumToStr(sndStr, index + 1));
            }
            index++;
        }
        return result;
    }

    private static List<String> readStringByFile(String fileName) {
        List<String> strList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String str;
            while ((str = br.readLine()) != null) {
                strList.add(str);
            }

        } catch (IOException e) {
            throw new RuntimeException("file Not Found");
        }

        return strList;
    }

    private static String appendLineNumToStr (String str, int lineNum) {
        StringBuilder sb = new StringBuilder();

        sb.append("Line ")
          .append(lineNum)
          .append(":")
          .append(str);

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        final String PATH = "/Users/bean/bitcamp/basicJavaSyntax/AssignmentFolder/day0805/files/";

        FileCompareUtil util = new FileCompareUtil();
        System.out.println(util.compareFile(PATH + "fstFile1.txt", PATH + "scdFile1.txt"));
        System.out.println("Successful!!");
    }
}
