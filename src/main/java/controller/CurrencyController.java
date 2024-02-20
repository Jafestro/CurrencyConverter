package controller;

import view.CurrencyView;

import java.util.Arrays;

public class CurrencyController {
    private CurrencyView view;

    public CurrencyController(CurrencyView view) {
        this.view = view;
    }

    public void convert() {
        String[] choiceBoxes = view.getChoiceBoxes().split(" ");
        double amount = Double.parseDouble(view.getInputValue());
        double rate1 = view.getRate(choiceBoxes[0]);
        double rate2 = view.getRate(choiceBoxes[1]);
        String result = String.format("%.3f",((amount / rate2) * rate1));
        view.setResult(result);
    }

    public static void main(String[] args) {
        CurrencyView.launch(CurrencyView.class);
    }
}
