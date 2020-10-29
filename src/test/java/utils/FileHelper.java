package utils;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileHelper {

    public static List<String> readMenuFile(File showMenuFile) throws IOException{

            return FileUtils.readLines(showMenuFile,StandardCharsets.UTF_8);

    }
//    public static List<String> readValidFile(File VALID_USER_FILE) throws IOException {
//        return FileUtils.readLines(VALID_USER_FILE, StandardCharsets.UTF_8);
//    }
}
