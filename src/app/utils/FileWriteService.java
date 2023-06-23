package app.utils;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.String.format;

public class FileWriteService {
    private String fileName;
    private String text;

    public FileWriteService(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
    }

    public String createWriteFile() {
        String filePath = createPath(fileName);
        try (FileOutputStream fout = new FileOutputStream(filePath)) {
            byte[] byteArr = text.getBytes();
            fout.write(byteArr, 0, byteArr.length);
            return Constants.SUCCESSFUL_OPERATION_MSG;
        } catch (IOException e) {
            return format(Constants.ERROR_OPERATION_MSG, e.getMessage());
        }

    }

    private String createPath(String fileName) {
        return Constants.BASE_PATH_OUT + Constants.BASE_PATH_IN
                + fileName + ".txt";
    }
}
