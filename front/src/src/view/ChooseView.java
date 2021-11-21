package src.view;


import src.ClientApplication;
import src.mode.Musique;

import javax.swing.*;
import java.awt.event.ActionEvent;


import java.io.IOException;

public class ChooseView {
    private JPanel myPanel ;
    private JTextField text;
    private ClientApplication application;
    private JFrame frame;
    public ChooseView(ClientApplication appli) {
        myPanel = new JPanel();
        application = appli;
    }

    public void mainPage(){
        frame = new JFrame("Gestion des musiques");
        text = new JTextField("");

        myPanel.add(Box.createVerticalStrut(15)); // a spacer

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
                    updateLook("La musique "+ musique.toJSON()+ " a bien été ajouée");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

        myPanel.add(rechercher);
        rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){

                try {
                    IdSelector view = new IdSelector("Id de la musique à rechercher", "Merci de renseigner l'id");
                    String id = view.display(e);
                    updateLook("Résultat de la recherche : "+application.getAMusic(Integer.parseInt(id)));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        myPanel.add(supp);
        supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    IdSelector view = new IdSelector("Id de la musique à supprimer", "Merci de renseigner la musique a supprimer");
                    String res = view.display(e);
                    application.deleteMusic(Integer.parseInt(res));
                    updateLook("La musique avec commme id "+res+" a bien été supprimée");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        myPanel.add(modif);
        modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    ParamSelector paramSelector = new ParamSelector("Renseignements sur la musique à modifier");
                    Musique musique = paramSelector.display();
                    application.updateMusic(musique);
                    updateLook("La musique "+musique.toJSON() +" a bien été modifiée");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        frame.setContentPane(myPanel);


        text.setEditable(false);

        myPanel.add(Box.createHorizontalStrut(40)); // a spacer
        myPanel.add(text);
        frame.setSize(600,300);

        frame.setVisible(true);

    }


    public void updateLook(String modif){
        this.text.setText(modif);
        frame.revalidate();
        frame.repaint();
    }
}