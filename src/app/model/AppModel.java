package app.model;

import app.utils.FileReadService;
import app.utils.FileWriteService;

public class AppModel {

    public String executeFileCreation(String fileName, String fileText) {
        FileWriteService service = new FileWriteService(fileName, fileText);
        return service.createWriteFile();
    }

    public String executeFileRead(String fileName) {
        FileReadService service = new FileReadService(fileName);
        return service.readFile();
    }
}
