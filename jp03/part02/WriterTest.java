package jp03.part02;

import java.io.*;

public class WriterTest {
    public static void main(String[] args) {

        try {
            InputStream inputStream = System.in;
            Reader reader = new InputStreamReader(inputStream);

            OutputStream outputStream = System.out;

            Writer writer = new OutputStreamWriter(outputStream);

            System.out.println("입력을 기다립니다.");

            while(true) {
                int i = reader.read();
                writer.write(i);
                writer.flush();

                if ((char)i == 'x') {
                    break;
                }
            }
            //w.flush

            //Stream close()
            reader.close();
            writer.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
