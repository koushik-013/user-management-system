package user.management.system;


import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    JLabel heading;

    splash (){



        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/gif.gif"));
        Image i2= i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);

        JLabel heading = new JLabel("User Management System");
        heading.setBounds(295,20,1000,60);
        heading.setFont(new Font("Raleway", Font.BOLD, 50));
        image.add(heading);



        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(3000);
            setVisible(false);
            new login();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
             new splash();
    }
}
