import java.util.Locale;
import java.util.ResourceBundle;

public class Manager {
    private Locale locale;

    public String getMessages(String messages){
        ResourceBundle mess = ResourceBundle.getBundle("mess", locale);
        return mess.getString(messages);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    void login(Locale locale){
        setLocale(locale);

    }

    public String checkAccountNumber(){
        String VALID_ACC = "[\\d]{10}";
        while (true){
            System.out.print(getMessages("acc") + ' ');
            String result = DataInput.InputString();
            if (result.matches(VALID_ACC)) return result;
            else System.out.println("errInputAcc");
        }
    }

    public String checkPassword(){
        String VALID_PASS = "([0-9]+[A-Za-z]+)|([A-Za-z]+[0-9]+)";
        while (true){
            System.out.print(getMessages("pass"));
            String result = DataInput.InputString();
            if (result.matches(VALID_PASS) && result.length() >= 8 && result.length() <= 31) return result;
            else System.out.println(getMessages("errInputPass"));
        }
    }

}
