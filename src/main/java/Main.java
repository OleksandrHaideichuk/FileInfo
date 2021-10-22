import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {

        // створив папки і файли

        File directory = new File("Folder1");

        File file1 = new File("Folder1/file1.txt");
        File file2 = new File("Folder1/file2.txt");
        File file3 = new File("Folder1/file3.txt");
        File file4 = new File("Folder1/file4.txt");
        try {
            directory.mkdir();
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }

        ArrayList<File> fileList = new ArrayList<>();
        getFiles(new File("Folder1"), fileList);
        for(File file: fileList) {
            System.out.println(file.getName());
        }
    }

    private static void getFiles(File rootFile, List <File> fileList) {
        if (rootFile.isDirectory()) {
            File[] directoryFiles = rootFile.listFiles();
            if (directoryFiles != null) {
                for (File file: directoryFiles) {
                    if (file.isDirectory()) {
                        getFiles(file, fileList);
                    } else{
                        fileList.add(file);

                    }
                }
            }
        }
    }
}
