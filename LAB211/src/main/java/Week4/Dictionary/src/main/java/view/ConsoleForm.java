package view;

import model.WordMap;


public class ConsoleForm {

    public boolean addWord(WordMap map) {
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String eng = DataInput.inputString();

        if (map.isWordExist(eng)){
            System.out.println("Word already exists. Do you want to update it? (Y/N): ");
            boolean choice = DataInput.inputYN();
            if (!choice){
                System.out.println("Cancelled.");
                return false;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vi = DataInput.inputString();
        return map.addWord(eng,vi);
    }

    public boolean removeWord(WordMap map) {
        System.out.println("------------ Delete ----------------");
        System.out.print("Enter English: ");
        String eng = DataInput.inputString();
        return map.removeWord(eng);
    }

    public String translate(WordMap map) {
        System.out.println("------------- Translate ------------");
        System.out.print("Enter English: ");
        String eng = DataInput.inputString();
        return map.searchWord(eng);
    }
}
