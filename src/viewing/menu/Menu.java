package viewing.menu;

import viewing.fahrauftrag.FahrauftragViewing;
import viewing.fahrer.FahrerViewing;
import viewing.fahrzeug.FahrzeugViewing;
import viewing.sachbearbeiter.SachbearbeiterViewing;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    //constructor-------------------------------------------------------------------------------------------------------
    public Menu() {
        //properties----------------------------------------------------------------------------------------------------
        FahrerImage jbuttonFahrerImage = new FahrerImage();     SachbearbeiterImage jbuttonSachbearbeiterImage = new SachbearbeiterImage();
        FahrzeugImage jbuttonBusImage = new FahrzeugImage();    FahrauftragImage jbuttonFahrauftragImage = new  FahrauftragImage();

        //Jpanel--------------------------------------------------------------------------------------------------------
        JPanel jPanel = new JPanel(new GridLayout(2, 2));

        jPanel.add(jbuttonFahrerImage);   jPanel.add(jbuttonSachbearbeiterImage);
        jPanel.add(jbuttonBusImage);      jPanel.add(jbuttonFahrauftragImage);

        //Tool Tip buttons----------------------------------------------------------------------------------------------
        jbuttonFahrerImage.setToolTipText("Fahrer hinzufuegen");
        jbuttonSachbearbeiterImage.setToolTipText("Sachbearbeiter hinzufuegen");
        jbuttonBusImage.setToolTipText("Fahrzeug hinzufuegen");
        jbuttonFahrauftragImage.setToolTipText("Fahrauftrag erstellen");

        //action listener-----------------------------------------------------------------------------------------------
        jbuttonFahrauftragImage.addActionListener(e -> new FahrauftragViewing());
        jbuttonFahrerImage.addActionListener(e -> new FahrerViewing());
        jbuttonSachbearbeiterImage.addActionListener(e -> new SachbearbeiterViewing());
        jbuttonBusImage.addActionListener(e -> new FahrzeugViewing());

        //rahmen--------------------------------------------------------------------------------------------------------
        this.setTitle("Menu");
        this.add(jPanel);
        this.setSize(470, 492);
        this.setLocation(50,50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //visible-------------------------------------------
        this.setVisible(true);
    }//end of constructor

    //inner classes for pictures----------------------------------------------------------------------------------------
    //fahrer----------------------------------------------
    private class FahrerImage extends JButton {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("fahrer.png");
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }

    //sachbearbeiter---------------------------------------
    private class SachbearbeiterImage extends JButton {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Sachbearbeiter.png");
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }

    //fahrzeug---------------------------------------------
    private class FahrzeugImage extends JButton {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("Fahrzeug.jpg");
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }

    //fahrtauftrag-----------------------------------------
    private class FahrauftragImage extends JButton {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("fahrauftrag.jpg");
            imageIcon.paintIcon(this, g, 0, 0);
        }
    }
}//end of class
