
package etykieta.zegarek2;
/**
 * author pawelstradomski
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EtykietaZegarek2 extends JFrame
{
    EtykietaZegarek2()
    {
        super("Etykieta i Zegarek");
        this.setBounds(600, 300, 200, 200);
        this.setDefaultCloseOperation(3);
        initComponent();
    }
    public void initComponent()
    {
        this.getContentPane().add(panel);
        panel.add(etykieta);
        panel.add(czas);
        ActionListener stoper = new Zegar();
        Timer zegar = new Timer(1000, stoper);
        zegar.start();
//        pack();
    }
    private class Zegar implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
           czas.setText(pobierzCzas());
        }
       
    }
    public String pobierzCzas()
    {
        GregorianCalendar kalendarzyk = new GregorianCalendar();
        String h = "" + kalendarzyk.get(Calendar.HOUR_OF_DAY);
        String min = "" + kalendarzyk.get(Calendar.MINUTE);
        String sec = "" + kalendarzyk.get(Calendar.SECOND);
        
        if(Integer.parseInt(h)<10)
            h = "0"+h;
        if(Integer.parseInt(min)<10)
            min = "0"+min;
        if(Integer.parseInt(sec)<10)
            sec = "0"+sec;
        return h+":"+min+":"+sec;
                    
    }
    
    
    JPanel panel = new JPanel();
    JLabel etykieta = new JLabel("czas");
    JLabel czas = new JLabel(pobierzCzas());

    
    public static void main(String[] args) {
     
        new EtykietaZegarek2().setVisible(true);
    }
    
}
