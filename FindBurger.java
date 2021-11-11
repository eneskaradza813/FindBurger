package findburger;

import java.awt.*;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;

public class FindBurger extends JFrame{

    JLabel label0 = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel[] choiceLabel = new JLabel[3];
    ImageIcon burger = new ImageIcon("burger.gif");
    JButton newButton = new JButton();
    int burgerLocation;
    Random myRandom = new Random();
    
    public static void main(String[] args) {
       new FindBurger().show();
        
    }

    public FindBurger() throws HeadlessException {
        setTitle("Find the Burger");
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm(e);
            }
            
});
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        choiceLabel[0] = label0;
        choiceLabel[1] = label1;
        choiceLabel[2] = label2;
        for(int i = 0; i < 3; i++){
            gridConstraints = new GridBagConstraints();
            choiceLabel[i].setPreferredSize(new Dimension(burger.getIconWidth(), burger.getIconHeight()));
            choiceLabel[i].setOpaque(true);
            choiceLabel[i].setBackground(Color.red);
            gridConstraints.gridx = i;
            gridConstraints.gridy = 0;
            gridConstraints.insets = new Insets(10, 10, 10, 10);
            getContentPane().add(choiceLabel[i], gridConstraints);
            choiceLabel[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    labelMouseClicked(e);
                }
                
});
        }
        newButton.setText("Play Again");
        gridConstraints = new GridBagConstraints();
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 1;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        getContentPane().add(newButton, gridConstraints);
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newButtonActionPerformed(e);
            }
        });
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        newButton.doClick();
        
    }
    void labelMouseClicked(MouseEvent e){
        Component clickedComponent = e.getComponent();
        int choice;
        for(choice = 0; choice < 3; choice++){
            if(clickedComponent == choiceLabel[choice]){
                break;
            }
        }
        choiceLabel[choice].setBackground(Color.WHITE);
        if(choice == burgerLocation){
            choiceLabel[choice].setIcon(burger);
            newButton.setEnabled(true);
        }
    }
    public void newButtonActionPerformed(ActionEvent e){
        for(int i = 0; i < 3; i++){
            choiceLabel[i].setIcon(null);
            choiceLabel[i].setBackground(Color.red);
        }
        burgerLocation = myRandom.nextInt(3);
        newButton.setEnabled(true);
    }
    public void exitForm(WindowEvent e){
        System.exit(0);
    }
    
}
