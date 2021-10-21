import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

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
        System.out.println(directory.getAbsolutePath());
    }
    /* скопіював код з посилання яке ти кидав, намагався зрозуміти як привязати це ( інші варіанти теж пробував)
    до папки яку я створив */

    public Set<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        Set<String> fileList = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path Folder1 : stream) {
                if (!Files.isDirectory(Folder1)) {
                    fileList.add(Folder1.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }

}
