package src;

import src.view.ChooseView;

public class Main {

    public static void main(String[] args) {
        ChooseView view = new ChooseView(new ClientApplication());
        view.mainPage();
    }
}
