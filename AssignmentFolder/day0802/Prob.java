package AssignmentFolder.day0802;

public class Prob {
    private static String[] stringSplit (String str1, String str2){
        String[] result = null;
        result = str1.split(str2);

        return result;
    }

    public static void main(String[] args) {
        String str = "PROD-001#X-note#Samsung#3#6000000";
        String[] strs = stringSplit(str, "#");
        System.out.println("=====문자열 처리 결과=====");
        for (int i = 0; i < strs.length; i++){
            System.out.println(strs[i]);
        }
    }
}