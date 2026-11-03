import java.util.Arrays;
import java.util.List;

public class Menu {
    static List<String> options = Arrays.asList(
            "--------Login Program-------",
            "1. Vietnamese",
            "2. English",
            "3. Exit",
            "Please choose one option.");
    public static int getChoice(){
        options.forEach(System.out::println);
        return DataInput.InputIntLimit(1,3);
    }
}
