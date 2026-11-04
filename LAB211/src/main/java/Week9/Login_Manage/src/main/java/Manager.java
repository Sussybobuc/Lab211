import java.util.Locale;
import java.util.Random;
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
        checkAccountNumber();
        checkPassword();
        System.out.print(getMessages("captcha"));
        String captcha = generateCaptcha();
        System.out.println(captcha);
        checkCaptcha(captcha);
    }

    public void checkAccountNumber(){
        String VALID_ACC = "[\\d]{10}";
        while (true){
            System.out.print(getMessages("acc") + ' ');
            String result = DataInput.InputString();
            if (result.matches(VALID_ACC)) return;
            else System.out.println(getMessages("errInputAcc"));
        }
    }

    public void checkPassword(){
        String VALID_PASS = "([0-9]+[A-Za-z]+)|([A-Za-z]+[0-9]+)";
        while (true){
            System.out.print(getMessages("pass"));
            String result = DataInput.InputString();
            if (result.matches(VALID_PASS) && result.length() >= 8 && result.length() <= 31) return;
            else System.out.println(getMessages("errInputPass"));
        }
    }

    public String generateCaptcha(){
        Random rand = new Random();
        char[] chars = new char[6];
        for (int i = 0; i < 6; i++){
            int nextChar = rand.nextInt(2) + 1;
            if (nextChar == 1) chars[i] = (char) ('A' + rand.nextInt(26));
            else chars[i] = (char) ('0' + rand.nextInt(10));
        }
        return new String(chars);
    }

    public void checkCaptcha(String captcha){
        while (true){
            System.out.print(getMessages("inputCaptcha") + ' ');
            String result = DataInput.InputString();
            if (result.matches(captcha)) return;
            else System.err.println(getMessages("errCaptcha"));
        }
    }
}
