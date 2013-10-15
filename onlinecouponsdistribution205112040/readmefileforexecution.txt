

 ........................................................serverside implementation...........................................


step 1...
             first create these table in oracle database


create table login(
                       uname number(9) primary key,
                       pass number(9)
                  );

create table extrafood(
                         roll number(9) primary,
                         dept varchar2(39),
                         name varchar2(30),
                         registrationid number(20),
                         amount number(3),
                      );

create table reregistration
                          (
                              roll number(9) primary key,
                              dept varchar2(34),year number(2),
                              sem number(2),mess varchar2(40)
                             

                          );



step 2....
            then run these file on seperate command prompt
        
       compile     c>javac loginserver.java
         
        run        c>java loginserver




        compile     c>javac TCPServermain.java
         
        run        c>java lTCPServermain


        compile     c>javac messserver.java
         
        run        c>java messserver



        compile     c>javac reregistrationServer.java
         
        run        c>java reregistrationServer




   .......................................client side implementation................................................




step 3

           
          compile     c>javac logininmain1.java
         
          run        c>java logininmain1





note=>
       first run the all serverside file in step 2 then run clinet side file both server and clint file should have seperate
       
       command prommnt



