package controller;

import model.WordMap;
import view.ConsoleForm;
import view.Menu;

import java.io.IOException;

public class WordManagement {
    String fileName = "Dictionary.txt";
    WordMap wordMap = new WordMap(fileName);
    ConsoleForm consoleForm = new ConsoleForm();

    public void execute(){
        while (true) {
            int choice = Menu.getChoice();
            switch (choice) {
                case 1:
                    boolean success = consoleForm.addWord(wordMap);
                    if (success) System.out.println("Successful");
                    else System.out.println("Failed");
                    break;
                case 2:
                    boolean rmv = consoleForm.removeWord(wordMap);
                    if (rmv) System.out.println("Successful");
                    else System.out.println("Does not exist in the db key");
                    break;
                case 3:
                    String vietWord = consoleForm.translate(wordMap);
                    if (vietWord != null) System.out.println("Vietnamese: " + vietWord);
                    else System.out.println();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
