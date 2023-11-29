package logic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


public class FileSearcher {

    private BufferedReader fileReader = null;
    private File file = null;

    public void setPath(String path) {
        this.file = new File(path);
    }

    public String fileSearch(String pattern, String file) throws IOException {
        this.setPath(file);
        System.out.println(this.file.getAbsolutePath());
        try {
            this.fileReader = new BufferedReader(new FileReader(this.file));
        } catch (FileNotFoundException e) {
            return "File not found";
        }
        int i = 0;
        String toReturn = "";
        String st;
        while ((st = this.fileReader.readLine()) != null) {
            if(st.contains(pattern)) {
                toReturn += "Line " + i + ": " + st + "\n";
            }
            i++;
        }
        return toReturn;
    }

}