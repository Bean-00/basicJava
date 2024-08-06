package AssignmentFolder.day0806;

public class Prob2 {
    String toEncoding(String decodedStr) {
        String encodedStr = "홍길";
        StringBuilder sb = new StringBuilder(16);
        byte[] temp = decodedStr.getBytes();
        StringBuilder resultsb = null;

        char[] decodedArray = decodedStr.toCharArray();

        for (int i = 0; i < decodedArray.length; i++) {
            for (char alphabet : decodedArray) {
                if (alphabet > 127) {
                    byte[] tempAlpha = Character.toString(alphabet).getBytes();
                    System.out.println(Integer.toHexString(tempAlpha[0]));
                    for (byte b : tempAlpha) {
                        System.out.println("b " + Integer.toHexString(b));
//                        resultsb.append(Integer.toHexString(b).replace("ffffff", " "));
                    }
                    System.out.println(resultsb);
                } else {
                    sb.append(alphabet);
                }
            }
            resultsb.append(sb);
        }
        return resultsb.toString();

    }

    public static void main(String[] args) {
        Prob2 p = new Prob2();
        String value = "홍";
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println("인 " + Integer.toHexString(bytes[i]));
        };
        System.out.println(p.toEncoding("홍"));



    }
}