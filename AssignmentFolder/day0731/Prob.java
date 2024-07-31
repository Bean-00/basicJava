package AssignmentFolder.day0731;

public class Prob {
    public static String encodingString(String decodedString) {
        String encodingString = "";
        for (int i = 0; i < decodedString.length(); i++){
            char UpperWord;
            if (decodedString.charAt(i) == ' ') {
                UpperWord = ' ';
            } else if ((char)(decodedString.charAt(i) + 3) > 123){
                UpperWord = (char)(decodedString.charAt(i) - 22);
            } else {
                UpperWord = (char)(decodedString.charAt(i) + 3);
            }

            encodingString += UpperWord;
        }
        return encodingString;
    }
    public static void main(String[] args) {
        String sourceString  = "everyday we have is one more than we deserve";
        String encodedString = encodingString(sourceString);

        System.out.println("암호화할 문자열: " + sourceString);
        System.out.println("암호화된 문자열: " + encodedString);
    }
}
