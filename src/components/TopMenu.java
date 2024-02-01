package components;

import app.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopMenu extends JPanel
{
    private JLabel jLAdmin;
    private JButton menuButton;
    private JButton refreshButton;
    private JPanel currentPanel;
    private SideMenu sideMenu;
    private MainWindow mainWindow;

    public void setNewPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
    }

    public TopMenu (MainWindow _mainWindow) {

        this.mainWindow = _mainWindow;
        //create Top Panel
        setBackground(new Color(0, 0, 0));
        setBounds(0, 0, 1750, 49);
        setLayout(new BorderLayout(0, 0));
        //create MENU Button
        menuButton = new JButton("");
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //make a transparent button
        menuButton.setOpaque(false);                 //make a component transparent if false
        menuButton.setContentAreaFilled(false);                 // Removes background fill
        menuButton.setBorderPainted(false);                     // Removes the button border

        menuButton.setFont(new Font("Myanmar MN", Font.PLAIN, 12));
        menuButton.setBackground(Color.BLACK);
        add(menuButton, BorderLayout.WEST);
        menuButton.addActionListener(new ActionListener() {
            boolean menuVisible = false;

            public void actionPerformed(ActionEvent e) {

                if (!menuVisible) {
                    // open menu
                    mainWindow.getCurrentPane().add(sideMenu);
                    menuVisible = true;
                } else {
                    // close menu
                    mainWindow.getCurrentPane().remove(sideMenu);
                    menuVisible = false;
                }
                //Revalidate the content pane components to reflect changes
                mainWindow.getCurrentPane().revalidate();
                mainWindow.getCurrentPane().repaint();
            }
        });
        ImageIcon IconMenu = new ImageIcon(MainWindow.class.getResource("/icons/icons8_menu_48px_1.png"));
        menuButton.setIcon(IconMenu);

        sideMenu = new SideMenu(mainWindow);

        refreshButton = new JButton("");
        refreshButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //make a transparent button
        refreshButton.setOpaque(false);                 //make a component transparent if false
        refreshButton.setContentAreaFilled(false);                 // Removes background fill
        refreshButton.setBorderPainted(false);                     // Removes the button border
        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Data reloaded");
                mainWindow.reloadData();
                //TODO refresh func
            }
        });
        refreshButton.setBackground(Color.BLACK);
        add(refreshButton, BorderLayout.EAST);
        ImageIcon IconRefresh = new ImageIcon(MainWindow.class.getResource("/icons/Hopstarter-Soft-Scraps-Button-Refresh.32.png"));
        refreshButton.setIcon(IconRefresh);

        //create label Hello Admin
        jLAdmin = new JLabel("Hello, Admin");
        jLAdmin.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLAdmin.setForeground(new Color(254, 254, 254));
        jLAdmin.setFont(new Font("Malayalam MN", Font.PLAIN, 11));
        add(jLAdmin, BorderLayout.CENTER);
    }
}
