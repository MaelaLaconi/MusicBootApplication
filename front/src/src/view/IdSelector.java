package src.view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class IdSelector {
    private String title;
    private String label;

    public IdSelector(String title, String label) {
        this.title = title;
        this.label = label;
    }

    public String display(ActionEvent e) {
        JPanel myPanel = new JPanel();
        JTextField delete = new JTextField("1");
        myPanel.add(new JLabel(label));
        myPanel.add(delete);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return delete.getText();

        }
        return "";
    }
}
