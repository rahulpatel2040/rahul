import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.lang.*;
import java.util.Scanner;

class logininmain1 extends JFrame implements ActionListener
 {
               int f=0; 
               myclientapp2  main2;
               JButton b1,b2;
               JTextField tx1,tx2;
               JLabel label1,label2;
               private JPasswordField jPasswordField1;

     String modifiedSentence="yes",modifiedSentence1;
     DataOutputStream outToServer,outToServer1;    
     DataOutputStream suname=null,spass=null;
     String tb1,tb2,tb3,tb4;
     BufferedReader inFromServer; 

  public void show4(String suname,String spass)
   {

        try
         {  
                String sentence,sentence1;
                String modifiedSentence;     
                Socket clientSocket = new Socket("localhost", 4004); 
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes(suname+ '\n');
                outToServer.writeBytes(spass+ '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println("registration no:"+modifiedSentence);  
           if( modifiedSentence.startsWith("Welcome"))
            {
                	f=1; 
                        main2.setVisible(true);
                        main2.getContentPane().setBackground(Color.CYAN);

               Toolkit kit =main2.getToolkit();
	       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 	       GraphicsDevice[] gs = ge.getScreenDevices();
	       Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        main2.setSize(Math.min(max_width, 800), Math.min(max_height, 500));
  	        main2.setLocation((int) (max_width -main2.getWidth()) / 2, (int) (max_height - main2.getHeight() ) / 2);
 

                   main2.show1();
             }
            else if(modifiedSentence.startsWith("Sorry"))
             {
             	f=1;
                          JOptionPane.showConfirmDialog(null,"INVALID USERNAME AND PASSWORD ","Status",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
                          tx1.setText(" ");jPasswordField1.setText(" ");
outToServer.flush();
             }
        else 
            {
                JOptionPane.showConfirmDialog(null,"Sorry there is some problem :","Status",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
                tx1.setText(" ");jPasswordField1.setText(" ");
                outToServer.flush();
            }clientSocket.close();
 
        }catch(Exception ex){}
  }
public void logininmain3()
      {
                                   
                     setLayout(null);
                     setBackground(Color.cyan);
                     setSize(400,300);
                     setVisible(true);
 
     
            label1=new JLabel("User Name:");
                    label1.setSize(120,90);
                    label1.setLocation(40,30);
                    add(label1); 
                tx1=new JTextField(20);
                     tx1.setToolTipText("Valid Roll number");
                     tx1.setSize(125,25);
                     tx1.setLocation(138,60);
                     add(tx1); 
                    
         label2=new JLabel("Password:");
                    label2.setSize(125,90);
                    label2.setLocation(40,80);
        
                jPasswordField1=new JPasswordField(); 
                       jPasswordField1.setToolTipText("Roll number Should be valid");                    
                       jPasswordField1.setSize(120,25);
                       jPasswordField1.setLocation(138,110);
                      add( jPasswordField1); 
               
                    add(label2);            
                     
                b1=new JButton("Login");
                 b1.setToolTipText("User Name and passwod will your roll number");   
                 b1.setSize(140,35);
                 b1.setLocation(230,160);
                 b1.addActionListener(this); 
                 add(b1);
                 setDefaultCloseOperation(EXIT_ON_CLOSE);
                  main2=new myclientapp2();
                 main2.setSize(600,600);
               
  
    
   }
public void actionPerformed(ActionEvent e)
     {
                if(e.getSource()==b1)
                    {
                                try{
                           
                                        show4(tx1.getText(),String.valueOf(jPasswordField1.getPassword())); 
                                        if(f==0) 
                                         {
                                             JOptionPane.showConfirmDialog(null,"Error:","Status",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
                                         }
                                          
                                 }catch(Exception e1){}
                    } 
    }
 
public static void main(String arg[])
      {
               
                 logininmain1 l1=new logininmain1();
                 l1.logininmain3();

           
                    l1.getContentPane().setBackground(Color.GRAY);
              


                 Toolkit kit =l1.getToolkit();
	         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	         GraphicsDevice[] gs = ge.getScreenDevices();
	         Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        l1.setSize(Math.min(max_width, 400), Math.min(max_height, 300));
  	        l1.setLocation((int) (max_width - l1.getWidth()) / 2, (int) (max_height - l1.getHeight() ) / 2);
 
            }
}



class myclientapp2 extends JFrame implements ActionListener
{
    
         extrafoodRegistration ex; 
         JButton b1,b2;
         login lo; 
         JLabel label1,label2;
  public void show1()
  {

                     setLayout(null);
                   //setBackground(Color.cyan);
                  setSize(900,500);
                Font f=new Font("courier",Font.ITALIC|Font.BOLD,25);

                  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      
       label1=new JLabel("ONLINE FOOD COUPONS DISTRIBUTION");
                  label1.setFont(f);
                  label1.setSize(490,250);
                  label1.setLocation(240,-45);
                  add(label1);           
            
                JLabel footer=new JLabel("By Rahul kumar patel"); 
                footer.setSize(150,50);
                footer.setLocation(746,420);
                add( footer);
                   b1=new JButton("RE_REGISTRATION");
               b1.setToolTipText("For new Re-registration");
               b1.setSize(140,35);
               b1.setLocation(40, 377);
               b1.addActionListener(this); 
               add(b1);
            b2=new JButton("EXTRAFOOD");
               b2.setToolTipText("Registration for Extra Food's");
               b2.setSize(140,30);
               b2.setLocation(40, 300);
               b2.addActionListener(this); 
             
               add(b2);
               lo=new login("Re-registrationForm");
               lo.setSize(780,450);
               ex=new extrafoodRegistration("EXTRAFOOD's");  
               ex.setSize(950,500);  

                Toolkit kit =ex.getToolkit();
  	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice[] gs = ge.getScreenDevices();
	        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        ex.setSize(Math.min(max_width, 400), Math.min(max_height, 300));
  	        ex.setLocation((int) (max_width - ex.getWidth()) / 2, (int) (max_height - ex.getHeight() ) / 2);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
  
 }
public void actionPerformed(ActionEvent e)
{
                if(e.getSource()==b1)
                 {
                                      
                                         lo.getContentPane().setBackground(Color.CYAN);
                                         lo.setVisible(true);


                Toolkit kit =lo.getToolkit();
 	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 	        GraphicsDevice[] gs = ge.getScreenDevices();
	        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        lo.setSize(Math.min(max_width, 800), Math.min(max_height, 500));
  	        lo.setLocation((int) (max_width - lo.getWidth()) / 2, (int) (max_height - lo.getHeight() ) / 2);
 
           }   
        else if(e.getSource()==b2)
           {
               
                              ex.getContentPane().setBackground(Color.GRAY);
                              ex.setVisible(true);
                                              
                 Toolkit kit =ex.getToolkit();
 	         GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 	         GraphicsDevice[] gs = ge.getScreenDevices();
	         Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                 Dimension d = kit.getScreenSize();
 	         int max_width = (d.width - in.left - in.right);
	         int max_height = (d.height - in.top - in.bottom);
	         ex.setSize(Math.min(max_width, 800), Math.min(max_height, 500));
  	         ex.setLocation((int) (max_width - ex.getWidth()) / 2, (int) (max_height - ex.getHeight() ) / 2);

                                     
       }  
  }
}

class login extends JFrame implements ActionListener,ItemListener
{ 

       String Name=" "; 
       Choice choice;
       JTextField tx1,tx2,tx3,tx4;
       JLabel l1,l2,l3,l4,head;
       JButton b1,b2;
      
       JComboBox com=new JComboBox();

 login(String title)
    {
     
          super(title);   
           try{       
         
                 Container contentPane=getContentPane();
                 contentPane.setLayout(null);
                 setBackground(Color.gray);
               
                choice=new Choice();
       head=new JLabel("WELCOME TO NITT HOTEL OFFICE");
              
                    head.setSize(420, 200);
                    head.setLocation(330,2);
                    add(head);
              
                l1=new JLabel("ROLL NUMBER ");
                l1.setBounds(90,120,120,135);      
                contentPane.add(l1);
                                      
                   
              l3=new JLabel("Department");      
                 l3.setSize(120, 200);
                 l3.setLocation(480,68);
                 add(l3);
             tx3=new JTextField(60);      
                 tx3.setSize(150, 30);
                 tx3.setLocation(580, 160);
                 add(tx3);
             tx1=new JTextField(60);      
                 tx1.setSize(150, 30);
                 tx1.setLocation(210, 160);
                 add(tx1);
            
              l2=new JLabel("YEAR ");      
                 l2.setSize(120, 200);
                 l2.setLocation(90,140);
                 add(l2);
             tx2=new JTextField(60);      
                 tx2.setSize(150, 30);
                 tx2.setLocation(210, 230);
                 add(tx2);
             l4=new JLabel("SEMESTER ");      
                 l4.setSize(130, 200);
                 l4.setLocation(470, 150);
                 add(l4);
             l2=new JLabel("MESS NAME ");      
                 l2.setSize(120, 200);
                 l2.setLocation(80,220);
                 add(l2);
             
             tx4=new JTextField(60);      
                 tx4.setSize(150, 30);
                 tx4.setLocation(580, 240);
                 add(tx4);
                 
                        choice.add("MegaMess-2");
                        choice.add("MegaMess-1");                      
                        choice.addItemListener(this);
                        choice.setBounds(210,315,150,60);      
            contentPane.add(choice);
                
                 
     

     
          
           b1=new JButton("Submit");
              b1.setSize(90,30);
              b1.setLocation(580,362);
              add(b1);b1.setOpaque(false); 

            b1.addActionListener(this);

           
           setDefaultCloseOperation(EXIT_ON_CLOSE);

    }catch(Exception e){}

   }
  public void itemStateChanged(ItemEvent event) 
  {
      
         	Name=(String)choice.getSelectedItem();
         	System.out.println("Welcome "+Name+" to CodeCall!");
  }
public void insertRecord(String roll,String dept,String year,String sem,String mess)
    {

           
           try
             {
                System.out.println("in try"); 
  
                String sentence,sentence1;
                String modifiedSentence,modifiedSentence1;     
                Socket clientSocket = new Socket("localhost", 4005); 
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.writeBytes(roll + '\n');
                outToServer.writeBytes(dept + '\n');
                outToServer.writeBytes(year + '\n');
                outToServer.writeBytes(sem+ '\n');
                outToServer.writeBytes(mess+'\n');
                modifiedSentence=inFromServer.readLine();
                System.out.println("all write"+modifiedSentence); 

              if(modifiedSentence.equals("ok"))
                {

                                JOptionPane.showConfirmDialog(null,"Successfully Saved","STATUS",JOptionPane.INFORMATION_MESSAGE);
                                tx1.setText(" ");tx2.setText(" ");tx3.setText(" ");tx4.setText(" ");
                }
              else
               {                
                    JOptionPane.showConfirmDialog(null,"Sorry Wrong input","STATUS",JOptionPane.INFORMATION_MESSAGE);
                    tx1.setText(" ");tx2.setText(" ");tx3.setText(" ");tx4.setText(" ");
              
               }clientSocket.close();
           }catch(Exception ex){}
  }







 public void actionPerformed(ActionEvent e)
 {
           int result;

          if(e.getSource()==b2)
          {
               JOptionPane.showConfirmDialog(null,"YOU WANT SUBMIT NOW","YOU WANT SUBMIT NOW",JOptionPane.YES_NO_OPTION);
          }
      else if(e.getSource()==b1)
           {
                     try{
                           
                               
                               System.out.println(tx1.getText());
                               System.out.println(tx3.getText());
                               System.out.println(tx2.getText());

                               System.out.println(tx4.getText());
                               System.out.println(Name);
                                                     
                              insertRecord(tx1.getText(),tx3.getText(),tx2.getText(),tx4.getText(),Name);    
                              
                        }catch(Exception e1){}
       
        
            //  JOptionPane.showConfirmDialog(null,"YOU WANT SUBMIT IT NOW","Status",JOptionPane.YES_NO_OPTION);
           } 
      
  }
     
}
class extrafoodRegistration extends JFrame implements ActionListener
 { 
      coupons cop;
      extrafood ex;
      JButton b1,b2;
      JLabel veg,nonveg,l1,l2;
   extrafoodRegistration(String title)
   {
            
                  super(title);   
                  setLayout(null);
                  setBackground(Color.CYAN);
                  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          Font f=new Font("courier",Font.ITALIC|Font.BOLD,15);
            veg=new JLabel("Vegiterian Item");
                veg.setFont(f);
                veg.setSize(140,40); 
                veg.setLocation(100,100);
                add(veg);

          nonveg=new JLabel("NonVegiterian Item");
                nonveg.setFont(f);
                nonveg.setSize(180,60); 
                nonveg.setLocation(510,100);
                add(nonveg);
            
        l2=new JLabel(new ImageIcon("3.png"));
                //nonveg.setFont(f);
                l2.setSize(190,150); 
                l2.setLocation(110,170);
                add(l2);
        
   
            l1=new JLabel(new ImageIcon("2.png"));
                //nonveg.setFont(f);
                l1.setSize(190,150); 
                l1.setLocation(510,170);
                add(l1);
        
                 
              b1=new JButton("REGISTRATIOON");
              b1.setToolTipText("Registration for extrafoods,"+"\n"+"you must have to register");        
              b1.setSize(130,18);
              b1.setLocation(530,10);
              add(b1);
              b1.addActionListener(this);

           
            b2=new JButton("COUPONS");
              b2.setToolTipText("you can take coupons for extrafoods");   
                
              b2.setSize(130, 18);
              b2.setLocation(660,10);
              add(b2);
              b2.addActionListener(this);
              ex=new extrafood("REGISTRATION FORM");  
              ex.setSize(770,450);               
              cop=new coupons("Coupons");  
              cop.setSize(700,500);               

   }
public void actionPerformed(ActionEvent e)
{
           int result;

          if(e.getSource()==b2)
           {
                    cop.getContentPane().setBackground(Color.CYAN);
                    cop.setVisible(true);
                 
               Toolkit kit =cop.getToolkit();
	       GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 	       GraphicsDevice[] gs = ge.getScreenDevices();
	       Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        cop.setSize(Math.min(max_width, 800), Math.min(max_height, 500));
  	        cop.setLocation((int) (max_width -cop.getWidth()) / 2, (int) (max_height -cop.getHeight() ) / 2);
 




           }
      else if(e.getSource()==b1)
             {
                                           ex.getContentPane().setBackground(Color.CYAN);
                                           ex.setVisible(true);

                Toolkit kit =ex.getToolkit();

   	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 	        GraphicsDevice[] gs = ge.getScreenDevices();
	        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	 

                Dimension d = kit.getScreenSize();
	        int max_width = (d.width - in.left - in.right);
	        int max_height = (d.height - in.top - in.bottom);
	        ex.setSize(Math.min(max_width, 800), Math.min(max_height, 500));
  	        ex.setLocation((int) (max_width -ex.getWidth()) / 2, (int) (max_height -ex.getHeight() ) / 2);
 


    
          
             }
        } 
}
class extrafood extends JFrame implements ActionListener
{
               
    String modifiedSentence;
    DataOutputStream outToServer,outToServer1;    
    DataOutputStream name=null,roll=null,dept=null,amount=null;
       String tb1,tb2,tb3,tb4;int a;
 BufferedReader inFromServer; 
        JTextField tx1,tx2,tx3,tx4;
        JLabel l1,l2,l3,l4;
        JButton b1,b2;
public void show(String roll,String dept,String username,String upwd)
 {

        try
         {  
              String sentence,sentence1;
              String modifiedSentence;     
              Socket clientSocket = new Socket("localhost", 4003); 
              DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
              BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
              outToServer.writeBytes(roll + '\n');
              outToServer.writeBytes(dept + '\n');
              outToServer.writeBytes(username + '\n');
              outToServer.writeBytes(upwd+ '\n');
             a=Integer.parseInt(roll);
              modifiedSentence = inFromServer.readLine(); 

              if(modifiedSentence.equals("ok"))
                {

                      JOptionPane.showConfirmDialog(null,"Your registration Id:"+2*a,"STATUS",JOptionPane.OK_CANCEL_OPTION);
                       tx1.setText(" ");tx2.setText(" ");tx3.setText(" ");tx4.setText(" ");
                }
              else
               {                
                    JOptionPane.showConfirmDialog(null,"Sorry Wrong input","STATUS",JOptionPane.INFORMATION_MESSAGE);
                    tx1.setText(" ");tx2.setText(" ");tx3.setText(" ");tx4.setText(" ");
              
               }
               clientSocket.close();
 
        }catch(Exception ex){}
}
extrafood(String title)
    {
            
                  super(title);   
                  setLayout(null);
                  //setBackground(Color.RED);
              l1=new JLabel("ROLL NUMBER");      
                 l1.setSize(120,50);
                 l1.setLocation(60, 130);
                 add(l1);
              tx1=new JTextField(60);      
                 tx1.setSize(150, 30);
                 tx1.setLocation(190, 140);
                 add(tx1);
              l4=new JLabel("Department");      
                 l4.setSize(120, 200);
                 l4.setLocation(418, 50);
                 add(l4);
             tx3=new JTextField(60);      
                 tx3.setSize(150, 30);
                 tx3.setLocation(550, 137);
                 add(tx3);
           
             


              l2=new JLabel("NAME");      
                 l2.setSize(120, 50);
                 l2.setLocation(70,205);
                 add(l2);
             tx2=new JTextField(60);      
                 tx2.setSize(150, 30);
                 tx2.setLocation(190, 210);
                 add(tx2);
              l3=new JLabel("AMOUNT");      
                 l3.setSize(120, 200);
                 l3.setLocation(418,127);
                 add(l3);
               tx4=new JTextField(60);      
                 tx4.setSize(150,30);
                 tx4.setLocation(550, 205);
                 add(tx4);
   
           b1=new JButton("Submit");
  
              b1.setToolTipText("All field are Required before submission");

              b1.setSize(90,30);
              b1.setLocation(350,340);
              add(b1);
            b1.addActionListener(this);

           
           b2=new JButton("Cancel");
              b2.setToolTipText("page will terminate");
              b2.setSize(90, 30);
              b2.setLocation(520, 340);
              add(b2);
              b2.addActionListener(this);


}
public void actionPerformed(ActionEvent e)
 {

        if(e.getSource()==b2)
          {
                 int a=JOptionPane.showConfirmDialog(null,"ARE YOU SURE ","Status",JOptionPane.WARNING_MESSAGE);
                          System.out.println(a);
                if(a==0)
                          setVisible(false);
          }
      else if(e.getSource()==b1)
         {
 
               try{
                            if(tx1.getText()!=" " && tx2.getText()!=" "||tx3.getText()!=" "&&tx4.getText()!=" ")
                                show(tx1.getText(),tx3.getText(),tx2.getText(),tx4.getText());    
                            else
                            JOptionPane.showConfirmDialog(null,"Sorry all field are mendetry","Status",JOptionPane.ERROR_MESSAGE);

               
                 }catch(Exception e1){}
         }
  }
}

class coupons extends JFrame implements ActionListener
{ 
        JTextField tx1,tx2,tx3,tx4;
        JLabel l1,l2,l3,l4;
        JButton b1,b2;


public void couponsthread(String regis,String amount)
  {

        try
          {  
    
               String sentence,sentence1;
               String modifiedSentence,modifiedSentence1;     
               Socket clientSocket = new Socket("localhost", 4002); 
               DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
               BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

               outToServer.writeBytes(regis + '\n');
               outToServer.writeBytes(amount+ '\n');
               modifiedSentence=inFromServer.readLine();  
               if(modifiedSentence.equals("ok"))
                {

                                 JOptionPane.showConfirmDialog(null,"SUCCESSFULLY UPDATED","STATUS",JOptionPane.INFORMATION_MESSAGE);
                                 tx1.setText(" ");
                                 tx2.setText(" ");
                                 tx4.setText(" ");
                }
          else if(modifiedSentence.equals("on"))
               {                
                              JOptionPane.showConfirmDialog(null,"SORRY INVALID OPETRATION","STATUS",JOptionPane.ERROR_MESSAGE);
                              tx1.setText(" ");tx2.setText(" ");tx4.setText(" ");
              
               }
         
 else if(modifiedSentence.equals("in"))
               {                
                              JOptionPane.showConfirmDialog(null,"SORRY INSUFFICIENT BALANCE","STATUS",JOptionPane.WARNING_MESSAGE);
                              tx1.setText(" ");tx2.setText(" ");tx4.setText(" ");
              
               }
                 clientSocket.close();
    }catch(Exception ex){}
}

coupons(String title)
    {
            
                  super(title);   
                  setLayout(null);
                  setBackground(Color.YELLOW);
              l1=new JLabel("REGISTRATION ID");      
                 l1.setSize(120,50);
                 l1.setLocation(70, 130);
                 add(l1);
              tx1=new JTextField(60);      
                 tx1.setSize(150, 30);
                 tx1.setLocation(200, 140);
                 add(tx1);
              l2=new JLabel("NAME");      
                 l2.setSize(120, 50);
                 l2.setLocation(80,205);
                 add(l2);
             tx2=new JTextField(60);      
                 tx2.setSize(150, 30);
                 tx2.setLocation(200, 210);
                 add(tx2);
              l3=new JLabel("AMOUNT");      
                 l3.setSize(120, 200);
                 l3.setLocation(70,190);
                 add(l3);
               tx4=new JTextField(60);      
                 tx4.setSize(150,30);
                 tx4.setLocation(200, 275);
                 add(tx4);
   
           b1=new JButton("Submit");
              b1.setSize(90,30);
              b1.setLocation(380,370);
              add(b1);b1.setOpaque(false); 

            b1.addActionListener(this);

           
           b2=new JButton("Cancel");
              b2.setSize(90, 30);
              b2.setLocation(530, 370);b2.setOpaque(false); 

              add(b2);
              b2.addActionListener(this);




                 
   }
public void actionPerformed(ActionEvent e)
   {
           int result;
        if(e.getSource()==b2)
          {
              int a=JOptionPane.showConfirmDialog(null,"Are you Sure","STATUS",JOptionPane.YES_NO_OPTION);
                  if(a==0)
                  setVisible(false); 
         }
      else if(e.getSource()==b1)
         {
                         
                                couponsthread(tx1.getText(),tx4.getText());
         }
    }
}
