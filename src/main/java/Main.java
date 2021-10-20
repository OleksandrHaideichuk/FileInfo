import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

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
//E:/Codding/Java cod/FileIScan/Folder1