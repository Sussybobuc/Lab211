import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Function {

    public static void checkInputPath(String path) throws Exception {
        File f = new File(path);
        if(!f.exists()) throw new Exception("Path doesn't exist");
        if (f.isFile()) throw new Exception("Path to file");
        if(f.isDirectory())throw new Exception("Path to Directory");
    }

    static List<String> getAllFileNameJavaInDirectory(String path) throws Exception{
        File f = new File(path);
        if(f.isDirectory()){
            List<String> fileNames = new ArrayList<>();
            File[] files = f.listFiles();
            assert files != null;
            for (File file : files) {
                if (file.isFile() &&
                        file.getName().endsWith(".java")) {
                    fileNames.add(file.getName());
                }
            }
            return fileNames ;
        } else throw new Exception("Not a Directory, please try again.");
    }

    public static File[] getFileWithSizeGreaterThanInput(String path, int size) throws Exception{
        File f = new File(path);
        if(!f.exists()) throw new Exception("Path doesn't exist");
        if(f.isFile()) throw new Exception("Not a directory, please try again.");
        File[] files = f.listFiles(check -> check.length() > size * 1024L);
        if(files == null) throw new Exception("No files found");
        return files;
    }

    public static boolean appendContentToFile(String path, String contentInput) throws Exception{
        File f = new File(path);
        if(!f.exists()) throw new Exception("Path doesn't exist");
        if(!f.isFile()) throw new Exception("Not a directory, please try again.");
        if(!f.getName().endsWith(".txt")) throw new Exception("Not a text file, please try again.");
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        bw.append(contentInput);
        bw.close();
        return true;
    }

    public static int countWord(String path) throws Exception{
        File f = new File(path);
        if(!f.exists()) throw new Exception("Path doesn't exist");
        if(!f.isFile()) throw new Exception("Not a directory, please try again.");
        if(!f.getName().endsWith(".txt")) throw new Exception("Not a text file, please try again.");
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int count = 0;
        while((line = br.readLine()) != null){
            String[] words = line.split("\\s+");
            count += words.length;
        }
        return count;
    }

    public static String inputString(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String result = sc.nextLine();
            if(!result.isEmpty()) return result;
            else {
                sc.nextLine();
                System.out.print("Please enter a valid value: ");
            }
        }
    }

    public static int inputInt()  {
        while (true){
            String result = inputString();
            try {
                int i = Integer.parseInt(result);
                if (i > 0) return i;
                System.out.print("Please enter a valid value: ");
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid value: ");
            }
        }
    }

    public static int inputChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int result = sc.nextInt();
                sc.nextLine();
                if (result >= 1 && result <= 6) {
                    return result;
                } else {
                    System.out.println("Please input a number in the range 1 -> 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a number.");
                sc.next();
            }
        }
    }
    public static int getChoice(){
        return inputChoice();
    }
}
