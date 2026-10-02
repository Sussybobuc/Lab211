
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author ASUS
 */
public class StringAnalysis {

    public static HashMap <String, List<Integer>> getNumber(String input){
        HashMap<String, List<Integer>> map = new HashMap<>();
        List<Integer> pSqrt = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        String[] num = input.replaceAll("\\D+", "-").split("-");
        for (String s : num){
            if(s.isEmpty()) continue;
            int n = Integer.parseInt(s);
            all.add(n);
            if(n % 2 == 0) even.add(n);
            else odd.add(n);
            if (Math.sqrt(n) == (int) Math.sqrt(n)) pSqrt.add(n);
        }
        map.put("pSqrt", pSqrt);
        map.put("odd", odd);
        map.put("even", even);
        map.put("all", all);
        return map;
    }
    
    public static HashMap <String, StringBuilder> getCharacter(String input){
    HashMap<String, StringBuilder> map = new HashMap<>();
    
    String all = input.replaceAll("\\d+", "");
    String special = input.replaceAll("\\w", "");
    String upper = input.replaceAll("[^A-Z]", "");
    String lower = input.replaceAll("[^a-z]", "");
    
    map.put("all" , new StringBuilder(all));
    map.put("up" , new StringBuilder(upper));
    map.put("low" , new StringBuilder(lower));
    map.put("special" , new StringBuilder(special));
    return map;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        String input = sc.nextLine();
        HashMap<String,List<Integer>> num = getNumber(input);
        HashMap<String,StringBuilder> words = getCharacter(input);
        System.out.println("-----Result Analysis------");
        
        System.out.println("Perfect Square Numbers: " + num.get("pSqrt"));
        System.out.println("Odd Numbers: " + num.get("odd"));
        System.out.println("Even Numbers: " + num.get("even"));
        System.out.println("All Numbers: " + num.get("all"));
        System.out.println("Uppercase Characters: " + words.get("up"));
        System.out.println("Lowercase Characters: " + words.get("low"));
        System.out.println("Special Characters: " + words.get("special"));
        System.out.println("All Characters:\n" + words.get("all"));
    }
}
