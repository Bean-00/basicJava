package jp03.part06;

import java.io.*;

public class WriteObjectFile01 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("UserInfo.obj"));

        oos.writeObject(new UserVO01(1, "홍길동"));
        oos.writeObject(new UserVO01(2, "홍길순"));
        oos.flush();

        oos.close();
    }
}
