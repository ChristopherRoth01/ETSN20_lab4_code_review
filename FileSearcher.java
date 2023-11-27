import java.io.FileNotFoundException;
import java.io.FileReader;


class FileSearcher {

    private FileReader fileReader = null;
    public FileSearcher() {

    }

    public String fileSearch(String pattern, String file) throws FileNotFoundException {
        try {
            this.fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            return "File not found";
        }
        
        return "File found";
        
    }
    public boolean isValidLocation(String location) {
        String regex = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9_.-]+)+\\\\?";
        return location.matches(regex);
    }

}