import java.io.*;
import java.net.*;
import java.sql.*;
class reregistrationServer implements Runnable
{

    public void messServer()
      {
               Thread th=new Thread(this);
               th.start();
      } 
public void run()
  {
                String roll,dept,mess,year,sem;
                String capitalizedSentence;
      while(true)
           {
           
                try
               {
                       ServerSocket welcomeSocket = new ServerSocket(4005);
                       Socket connectionSocket;
                       connectionSocket= welcomeSocket.accept();
                       BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                              
                       DataOutputStream outToClient=new  DataOutputStream(connectionSocket.getOutputStream()); 
                       
            System.out.println(".........................Re-regisration details Status:");    
             
                       roll=inFromClient.readLine(); 
                       dept=inFromClient.readLine();
                       year=inFromClient.readLine(); 
                       sem=inFromClient.readLine(); 
                       mess=inFromClient.readLine(); 
                      
                       System.out.println("Roll numbser : " +roll);
                       System.out.println("Depar " +dept);
                       System.out.println("year   : " +year);
                       System.out.println("semester  " +sem);
                       System.out.println("From mess" +mess);
                   
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
                       Connection con = DriverManager.getConnection("jdbc:odbc:database","system","patel");


                       PreparedStatement stmt= con.prepareStatement("insert into reregistration values(?,?,?,?,?)");

                     stmt.setInt(1,Integer.parseInt(roll)); 
                     stmt.setString(2,dept); 
                     stmt.setInt(3,Integer.parseInt(year)); 
                     stmt.setInt(4,Integer.parseInt(sem));
                     stmt.setString(5,mess); 
                     int rs=stmt.executeUpdate();
                     if(rs!=0)
                      {
                                   System.out.println("successfully updated");     
                                   outToClient.writeBytes("ok");
                                   outToClient.flush();
                    
                      }
                   else
                     {
                                       System.out.println("Not updated");
                                       outToClient.writeBytes("no"); 
                                       outToClient.flush();
                     }       
                  con.close();
                 }catch(Exception e){}
         }   
 }
public static void main(String argv[]) throws Exception
      {
               reregistrationServer t1=new reregistrationServer();
                t1.messServer();
     }
}

