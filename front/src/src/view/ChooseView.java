package src.view;


import src.ClientApplication;
import src.mode.Musique;

import javax.swing.*;
import java.awt.event.ActionEvent;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class ChooseView {
    private JPanel myPanel ;
    private JTextField text;
    private ClientApplication application;

    public ChooseView(ClientApplication appli) {
        myPanel = new JPanel();
        application = appli;
    }

    public void mainPage(){
        JFrame frame = new JFrame("Gestion des musiques");
        JTextField text = new JTextField("ici mon texteeeeeeeeeeeee");

        // javax.swing.GroupLayout layout = new javax.swing.GroupLayout(myPanel);
        //myPanel.setLayout(layout);

        myPanel.add(Box.createVerticalStrut(15)); // a spacer

        // layout settings goes here
        //frame.add(myPanel);
        JButton ajouter = new JButton("Ajouter musique");
        JButton rechercher = new JButton("Rechercher musique");
        JButton supp = new JButton("Supprimer musique");
        JButton modif = new JButton("Modifier musique");

        myPanel.add(ajouter);
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    ParamSelector paramSelector = new ParamSelector("Renseignements sur la musique à créer");
                    Musique musique = paramSelector.display();
                    application.addMusic(musique);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        myPanel.add(rechercher);
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                IdSelector view = new IdSelector("IBSN du livre à rechercher", "Merci de renseigner le livre a rechercher");
                String id = view.display(e);
                try {
                    setText(application.getABook(Integer.parseInt(id)));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(myPanel);
            }
        });

        myPanel.add(supp);
        supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                IdSelector view = new IdSelector("Id de la musique à supprimer", "Merci de renseigner la musique a supprimer");
                String res = view.display(e);

                try {
                    application.deleteMusic(Integer.parseInt(res));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });

        myPanel.add(modif);
        modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    ParamSelector paramSelector = new ParamSelector("Renseignements sur la musique à modifier");
                    Musique musique = paramSelector.display();
                    application.updateLivre(musique);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                SwingUtilities.updateComponentTreeUI(frame);
            }
        });
        frame.setContentPane(myPanel);


        text.setEditable(false);

        myPanel.add(Box.createHorizontalStrut(40)); // a spacer
        myPanel.add(text);
        frame.setSize(600,300);

        frame.setVisible(true);


        //int result = JOptionPane.showConfirmDialog(null, myPanel,
        //"Gestion des livres", JOptionPane.NO_OPTION);
    }


    public void setText(String text) {
        this.text = new JTextField(text);
    }
}