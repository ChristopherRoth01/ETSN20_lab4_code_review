import java.io.IOException;

import logic.FileSearcher;


public class Main {

    private Main() {
    }

    public static void main(String[] args) {
        FileSearcher fileSearcher = new FileSearcher();
        fileSearcher.setPath("res/test.txt");
        String pattern = "Duis";
        String file = "res/test.txt";
        try {
            System.out.println(fileSearcher.fileSearch(pattern, file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}