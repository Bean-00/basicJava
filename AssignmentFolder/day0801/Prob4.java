package AssignmentFolder.day0801;

public class Prob4 {
    public String leftPad (String str, int size, char padChar) {
        StringBuffer resultstr = new StringBuffer();
        resultstr.append(str);
        for (int i = 0; i < size - str.length(); i++) {
            resultstr.insert( 0, padChar);
        }
        return resultstr.toString();
    }

    public static void main(String[] args) {
        Prob4 prob = new Prob4();

        System.out.println(prob.leftPad("ABC", 6, '#'));
        System.out.println(prob.leftPad("ABC", 5, '$'));
        System.out.println(prob.leftPad("ABC", 2, '&'));

    }
}