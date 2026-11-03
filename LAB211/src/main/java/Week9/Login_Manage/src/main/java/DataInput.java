import java.util.Scanner;

public class DataInput {
    public static Scanner sc = new Scanner(System.in);
    static Manager mess = new Manager();
    public static int InputInt(){
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println(mess.getMessages("errInputInt"));
                System.out.println(mess.getMessages("retryInput"));
            }
        }
    }

    public static int InputIntLimit(int min, int max){
        while (true) {
            int result = InputInt();
            if(result >= min && result <= max) return result;
            else System.err.println(mess.getMessages("errInputMenu" + ' ' + min + ' ' + max));
        }
    }

    public static String InputString(){
        while (true){
            String result = sc.nextLine().trim();
            if(result.isEmpty()){
                System.err.println(mess.getMessages("errInputString"));
                System.out.println(mess.getMessages("retryInput"));
            } else return result;
        }
    }
}
