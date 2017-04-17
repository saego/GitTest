import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Created by Saego on 11.04.2017.
 */
public class Searcher {
    private String searchDirectory;
    private String extension;
    private File target = new File("SearchResult.txt");
    private PrintWriter pw = new PrintWriter(new FileWriter(target));

    private Searcher(String searchDirectory, String extension) throws IOException {
        this.searchDirectory = searchDirectory;
        this.extension = extension;
    }

    private boolean isExist(){
        File sDirectory;
        pw.println("Found files:");
        return (sDirectory = new File(this.searchDirectory)).exists() && sDirectory.isDirectory();
    }

    private void fileWalker(File file, SearchCommand command) throws IOException {
        File []folders = file.listFiles();
        assert folders != null;
        for (File folder:
             folders) {
            if (folder.isDirectory()){
                fileWalker(folder, command);
            }
            else {
                fillActions();
                chooseFilter(command);
            }
        }
    }

    private void compareFullName(SearchCommand value, File file) throws IOException {
        Pattern pattern = Pattern.compile(".+\\." + value.getValue());
        Matcher matcher = pattern.matcher(file.getName());
        //boolean found = Pattern.matches(file.getName(), name);
        if (matcher.matches()){
            pw.println(file.getAbsolutePath());
            System.out.printf("File: [%s]\n", file.getAbsolutePath());
            pw.flush();
        }
    }

    private Map <String, Filter> filterActions = new HashMap<String, Filter>();
    public void fillActions(){
        this.filterActions.put("N", new FilterByName());
        this.filterActions.put("E", new FilterByExtend());
        this.filterActions.put("F", new FilterByFullCompare());
        this.filterActions.put("help", new Help());
    }

    public void chooseFilter(SearchCommand command){
        if (filterActions.containsKey(command.getKey())){
            this.filterActions.get(command.getKey()).filterKey(command);
        }
        else {
            System.out.println("Error input");
            this.filterActions.get("help").filterKey(command);
        }
    }

    public static void main(String []args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input directory");
        String directory = scanner.nextLine();
        System.out.println("Input key and type of key");
        String extension = scanner.nextLine();
        Searcher searcher = new Searcher(directory, extension);
        if (searcher.isExist()){
            searcher.fileWalker(new File(directory));
        }
        else {
            System.out.println("Directory wasn't found");
        }
    }

    private class FilterByName implements Filter {
        public void filterKey(SearchCommand key) {

        }

        public String commandName() {
            return "Get all files by name";
        }
    }

    private class FilterByExtend implements Filter {
        public void filterKey(SearchCommand key) {

        }

        public String commandName() {
            return "Get all files by extend";
        }
    }

    private class FilterByFullCompare implements Filter {
        public void filterKey(SearchCommand key) {

        }

        public String commandName() {
            return "Get all files by full compare";
        }
    }

    private class Help implements Filter {
        public void filterKey(SearchCommand key) {

        }

        public String commandName() {
            return "HELP";
        }
    }
}
