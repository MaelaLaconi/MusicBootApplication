package src.view;

import src.mode.Musique;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ParamSelector {

    private String title;


    public ParamSelector(String title) {
        this.title = title;
    }


    public Musique display() {
        JPanel myPanel = new JPanel();
        JTextField id = new JTextField("1");
        myPanel.add(new JLabel("Id"));
        myPanel.add(id);

        JTextField titre = new JTextField("Titre");
        myPanel.add(new JLabel("Titre : "));
        myPanel.add(titre);

        JTextField chanteur = new JTextField("Chanteur");
        myPanel.add(new JLabel("Chanteur : "));
        myPanel.add(chanteur);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new Musique(Integer.parseInt(id.getText()), titre.getText(), chanteur.getText());
        }
        return null;
    }
}
