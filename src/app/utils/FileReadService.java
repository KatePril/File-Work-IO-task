package app.utils;

import java.io.FileInputStream;
import java.io.IOException;

import static java.lang.String.format;

public class FileReadService {
    private String fileName;

    public FileReadService(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        String filePath = createPath(fileName);
        try(FileInputStream fin = new FileInputStream(filePath)) {
            StringBuilder fileText = new StringBuilder();
            int i;
            while ((i = fin.read()) != -1) {
                char tmp = (char) i;
                fileText.append(tmp);
            }
            return Constants.SUCCESSFUL_OPERATION_MSG + "\n" + fileText;
        } catch (IOException e) {
            return format(Constants.ERROR_OPERATION_MSG, e.getMessage());
        }
    }

    private String createPath(String fileName) {
        return Constants.BASE_PATH_OUT + Constants.BASE_PATH_IN
                + fileName + ".txt";
    }
}
