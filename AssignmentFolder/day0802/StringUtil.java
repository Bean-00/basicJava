package AssignmentFolder.day0802;

public class StringUtil {
    private static String replaceString(String[] str) {
        int maxIndex = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            for (char c : str[i].toCharArray()) {
                if (c == 'a')
                    count++;
            }
            if (max < count) {
                max = count;
                maxIndex = i;
            }
            count = 0;
        }
        return str[maxIndex].replace('a', 'A');
    }

    public static void main(String[] args) {
        String[] arr = {"java program", "array", "java program area", "append"};
        String result =StringUtil.replaceString(arr);
        System.out.println("변경된 문자열: " + result);
    }
}