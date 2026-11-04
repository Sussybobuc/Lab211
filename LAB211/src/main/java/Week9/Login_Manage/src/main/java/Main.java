import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        Locale vi = new Locale("vi");
        Locale en = new Locale("en");
        while (true){
            switch (Menu.getChoice()){
                case 1:
                    manager.login(vi);
                    break;
                case 2:
                    manager.login(en);
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
