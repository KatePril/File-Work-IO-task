package app.controller;

import app.model.AppModel;
import app.utils.Constants;
import app.view.AppView;

import static java.lang.String.format;

public class AppController {
    AppModel model = new AppModel();
    AppView view = new AppView();


    public void handleData() {
        int option = view.getOption();
        switch (option) {
            case 0 -> view.getOutput(Constants.CLOSE_APP_MSG);
            case 1 -> {
                executeFirstOption();
                handleData();
            }
            case 2 -> {
                executeSecondOption();
                handleData();
            }
        }
    }

    private void executeFirstOption() {
        String fileName = view.getText(format(Constants.ENTER_FILE_NAME_MSG, "create"));
        String fileText = view.getText(Constants.ENTER_FILE_TEXT);
        view.getOutput(model.executeFileCreation(fileName, fileText));
    }

    private void executeSecondOption() {
        String fileName = view.getText(format(Constants.ENTER_FILE_NAME_MSG, "read"));
        view.getOutput(model.executeFileRead(fileName));
    }
}
