package model;

import java.io.*;
import java.util.HashMap;

/*
TODO:
    loadFile – đọc file ra hashmap – FileReader fReader = new FileReader(path to File)
    addWord(Word w): add 1 từ vô map -> gọi updateDatabase() để ghi ra file
    deleteWord(): delete 1 từ trong map -> gọi updateDatabase() để ghi ra file
    isExistWord()
    searchWord(): chỉ tìm trên map
    updateDatabase() – ghi HashMap ra file
*/
public class WordMap {

    private final HashMap<String, String> wordMap = new HashMap<>();
    private final String fileName;

    public WordMap(String fileName) {
        this.fileName = fileName;
        loadFile();
    }

    public HashMap<String, String> getWordMap() {
        return wordMap;
    }

    public boolean loadFile() {
        File file = new File(fileName);
        try {
            if (!file.exists()) return file.createNewFile();
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    String[] words = line.split(":", 2);
                    if (words.length == 2) wordMap.put(
                            words[0].trim().toLowerCase(),
                            words[1].trim().toLowerCase());
                }
            } return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean updateDB() {
        try (FileWriter fw = new FileWriter(fileName);
             BufferedWriter bw = new BufferedWriter(fw)) {
            {
                for(String word : wordMap.keySet()) {
                    bw.write(word + ": " + wordMap.get(word));
                    bw.newLine();
                }
                return true;
            }
        }catch (IOException e) {
            return false;
        }
    }

    public boolean isWordExist(String eng) {
        return wordMap.containsKey(eng.toLowerCase());
    }

    public boolean addWord(String eng, String vi)  {
        if (eng == null || vi == null || eng.trim().isEmpty() || vi.trim().isEmpty()) {
            return false;
        }
        wordMap.put(eng.trim().toLowerCase(), vi.trim().toLowerCase());
        return updateDB();
    }

    public boolean removeWord(String eng) {
        if (isWordExist(eng)) {
            wordMap.remove(eng.toLowerCase());
            return updateDB();
        }
        return false;
    }
    public String searchWord(String eng) {
        return wordMap.get(eng.toLowerCase());
    }


}
