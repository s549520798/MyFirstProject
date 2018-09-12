package language_basic.exceptions;

import java.io.*;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;


    public ListOfNumbers() {
        this.list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() {
        // The FileWriter constructor throws IOException, which must be caught.
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            for (int i = 0; i < SIZE; i++) {
                // The get(int) method throws IndexOutOfBoundsException, which must be caught.
                out.println("Value at: " + i + " = " + list.get(i));
            }
        } catch (IndexOutOfBoundsException | IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    /*
    try-with-resources 会自动将try（）中的资源回收， try后面必须跟 实现的 java.lang.AutoCloseable 和 java.io.Closeable
    接口的资源
     */
    public static String readFirstLineFormFilw(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine();
        }
    }
}
