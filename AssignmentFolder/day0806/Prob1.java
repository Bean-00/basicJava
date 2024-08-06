package AssignmentFolder.day0806;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class Prob1 {

    public Vector<String> dataChange (String[] strData) {
        Stack<String> list = new Stack<>();
        for (String strWord : strData) {
            char[] resultWord;
            resultWord = strWord.toCharArray();
            Stack<Character> stack = new Stack<Character>();
            for (int i = strWord.length() - 1; i >= 0; i--) {
                stack.push(strWord.charAt(i));
            }
            list.insertElementAt((stack.toString()).replace(",",""), 0);
        }
        return list;
    }

    public static void main(String[] args) {
        Prob1 st = new Prob1();
        String[] strData = {"Java Programming", "JDBC", "Oracle10g", "JSP/Servlet"};
        Vector<String> v = st.dataChange(strData);

        for (int i = 0; i < v.size(); i++) {
            System.out.println(v.elementAt(i));
        }
    }
}

