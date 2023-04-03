package ma.fstt.model;


import ma.fstt.trackingl.HelloApplication;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Menu extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Menu( ){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 153, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("Livreur");
        btnNewButton.setBackground(new Color(204, 153, 153));
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                try {
                    HelloApplication frameClient = new HelloApplication();
                    frameClient.setVisible(true);}
                catch (Exception e1) {
                    e1.printStackTrace();
                }
                dispose();

            }
        });
        btnNewButton.setBounds(152, 69, 131, 43);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Commande");
        btnNewButton_1.setBackground(new Color(204, 153, 153));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Commande frameCommande = new Commande();
                    frameCommande.setVisible(true);}
                catch (Exception e1) {
                    e1.printStackTrace();
                }
                dispose();
            }
        });
        btnNewButton_1.setBounds(152, 132, 131, 46);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Produit");
        btnNewButton_2.setBackground(new Color(204, 153, 153));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Produit frameProduit = new Produit();
                    frameProduit.setVisible(true);}
                catch (Exception e1) {
                    e1.printStackTrace();
                }
                dispose();
            }
        });
        btnNewButton_2.setBounds(152, 196, 131, 41);
        contentPane.add(btnNewButton_2);

        JLabel lblNewLabel = new JLabel("Gestion de stock : Glovo");
        lblNewLabel.setBackground(new Color(204, 153, 153));
        lblNewLabel.setBounds(141, 22, 198, 24);
        contentPane.add(lblNewLabel);


    }
}
