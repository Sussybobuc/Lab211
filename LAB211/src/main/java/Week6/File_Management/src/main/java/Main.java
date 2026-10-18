import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        while (true) {

            System.out.println("\n============ File Processing ============");
            System.out.println("1. Check Path");
            System.out.println("2. Get file name with type java");
            System.out.println("3. Get file with size greater than input");
            System.out.println("4. Write more content to file");
            System.out.println("5. Read file and count characters");
            System.out.println("6. Exit");
            System.out.println("Please choose one option:");
            int choice = Function.getChoice();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Path: ");
                        String path = Function.inputString();
                        Function.checkInputPath(path);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 2:
                    try {
                        System.out.print("Enter Path: ");
                        String path = Function.inputString();
                        List<String> fileName = Function.getAllFileNameJavaInDirectory(path);
                        if (!fileName.isEmpty()) {
                            for (String s : fileName) {
                                System.out.println(s);
                            }
                            System.out.printf("Result %d file!", fileName.size());
                        } else System.out.println("Result 0 file!");
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 3:
                    try {
                        System.out.print("Enter Size(Integer): ");
                        int size = Function.inputInt();
                        System.out.print("Enter Path: ");
                        String path = Function.inputString();

                        File[] i = Function.getFileWithSizeGreaterThanInput(path, size);
                        for (File f : i) {
                            System.out.println(f.getName());
                        }
                        System.out.printf("Result %d files!", i.length);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 4:
                    try {
                        System.out.print("Enter Content: ");
                        String content = Function.inputString();
                        System.out.print("Enter Path: ");
                        String path = Function.inputString();

                        boolean success = Function.appendContentToFile(path,content);
                        if(success) System.out.println("Write done");
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 5:
                    try {
                        System.out.print("Enter Path: ");
                        String path = Function.inputString();
                        int words = Function.countWord(path);
                        System.out.printf("Total : %d", words);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                case 6: System.exit(0);
            }
        }
    }
}

