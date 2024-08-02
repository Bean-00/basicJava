package AssignmentFolder.day0802;

import java.util.Vector;

public class ArrayCopy {
    
    public Vector<String> moveToVector (String []datas) {
        Vector<String> vector = new Vector<>();
        for (String data : datas) {
            vector.insertElementAt(data, 0);
        }
        return vector;
    }

    public static void main(String[] args) {
        ArrayCopy ac = new ArrayCopy();
        String datas[] = {"1", "2", "3", "4", "5"};
        System.out.println(ac.moveToVector(datas));
    }
}