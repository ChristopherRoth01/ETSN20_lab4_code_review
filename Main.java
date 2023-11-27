import java.io.IOException;


public class Main {

    private Main() {
    }

    public static void main(String[] args) {
        FileSearcher fileSearcher = new FileSearcher("res/test.txt");
        String pattern = "Lorem";
        String file = "res/test.txt";
        try {
            System.out.println(fileSearcher.fileSearch(pattern, file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}