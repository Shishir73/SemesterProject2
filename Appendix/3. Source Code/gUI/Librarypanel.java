package gUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Librarypanel extends JPanel {

   private JLabel title;
   private JButton user;
   private JButton administrator;
  
   
   
   public Librarypanel()
   {
      createComponents();
      AddComponentsToPanel();
      
      
      setSize(600, 600);
      
   }
   
   public void createComponents()
   {
      title=new JLabel("Library system");
      user=new JButton("User");
      administrator=new JButton("Administrator");
     
      
   }
   public void AddComponentsToPanel()
   {
      setLayout(new BorderLayout());
      title.setFont(new Font("Tahona", Font.PLAIN, 60));
      
      JPanel panelTitle=new JPanel();
      panelTitle.add(title,new BorderLayout().CENTER);
      
      JPanel buttons=new JPanel(new GridLayout(5,1,20,30));
      buttons.add(user);
      buttons.add(administrator);
     
      
      JPanel bt=new JPanel();
      bt.add(buttons,new BorderLayout().CENTER);
      
      JPanel all=new JPanel(new GridLayout(2,1));
      
      all.add(panelTitle);
      all.add(bt);
      
      add(all);
   }
   public void addActionListener(ActionListener listener)
   {
      user.addActionListener(listener);
      administrator.addActionListener(listener);
     
      
   }
   
   
}