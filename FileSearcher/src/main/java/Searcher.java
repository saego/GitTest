import java.io.*;
import java.util.Scanner;
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
        return (sDirectory = new File(this.searchDirectory)).exists() && sDirectory.isDirectory();
    }

    private void fileWalker(File file) throws IOException {
        File []folders = file.listFiles();
        assert folders != null;
        for (File folder:
             folders) {
            if (folder.isDirectory()){
                fileWalker(folder);
            }
            else {
                compareFullName(extension, folder);
            }
        }
    }

    private void compareFullName(String name, File file) throws IOException {
        boolean found = Pattern.matches(file.getName(), name);
        if (found){
            pw.println(file.getAbsolutePath());
            System.out.printf("File: [%s]\n", file.getAbsolutePath());
            pw.flush();
        }
    }

    public static void main(String []args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input directory");
        String directory = scanner.nextLine();
        System.out.println("Input extension");
        String extension = scanner.nextLine();
        Searcher searcher = new Searcher(directory, extension);
        if (searcher.isExist()){
            searcher.fileWalker(new File(directory));
        }
        else {
            System.out.println("Directory wasn't found");
        }
    }
}
