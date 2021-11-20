package src;

import src.view.ChooseView;
import src.view.IdSelector;

import java.awt.event.ActionEvent;

public class Main {

    public static void main(String[] args) {
        ChooseView view = new ChooseView(new ClientApplication());
        view.mainPage();
    }
}
