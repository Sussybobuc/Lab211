package controller;

import model.Fraction;
import model.fractionList;
import view.ConsoleForm;

import java.util.List;

public class ManageFraction {
    ConsoleForm consoleForm = new ConsoleForm();
    fractionList fractionList = new fractionList();

    public void execute() {
            int num = consoleForm.InputNumber();
            List<Fraction> fractions = fractionList.getFractions(num);
            String displayFractions = fractionList.format(fractionList.display());
            consoleForm.displayFraction(displayFractions);
            consoleForm.displaySum(fractionList.sumOfFractions());
    }
}
