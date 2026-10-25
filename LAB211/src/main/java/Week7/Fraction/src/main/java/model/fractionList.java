package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class fractionList {
    ArrayList<Fraction> fList = new ArrayList<>();
    Random rand = new Random();

    public ArrayList<Fraction> getfList() {
        return fList;
    }

    public void setfList(ArrayList<Fraction> fList) {
        this.fList = fList;
    }

    public List<Fraction> getFractions(int num) {
        for (int i = 0; i < num; i++) {
            fList.add(new Fraction(rand.nextInt(10) + 1, rand.nextInt(10) + 1));
        }
        return fList;
    }

    public ArrayList<Fraction> display() {
        ArrayList<Fraction> list = new ArrayList<>(fList);
        list.sort(Comparator.comparingDouble(Fraction::getNum));
        return list;
    }

    public String format(List<Fraction> fractions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fractions.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(fractions.get(i));
        }
        return "[" + sb + "]";
    }

    public static long gcd(long a, long b){
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public String sumOfFractions() {
        long top = 0, bottom = 1;
        for (Fraction f : fList) {
            long c = f.getNumerator();
            long d = f.getDenominator();

            top = top * d + c * bottom;
            bottom = bottom * d;

            long g = gcd(top, bottom);
            top = top / g;
            bottom = bottom / g;
        }
        return top + "/" + bottom;
    }

}
