/***************************
 * Asa Murphy
 * 4/01/2019
 * Chat Application
 * CS 3354 Object Oriented
 **************************/

package Chatty;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/***********************************************************************************************************************
 * Class Name: Server
 * Access Level: Public
 *
 * The Server class contains the part of the connections between the Server and Client
 **********************************************************************************************************************/

public class Server
{
    ArrayList<Client> clients;

    private static Server instance;

    public Server() //Constructor
    {
        clients = new ArrayList<Client>();
        this.instance = this;
    }

    public void connect(Client c)
    {
        clients.add(c);
    }

    public static Server getHostServer() { return instance; }

    public void run()
    {
        while(true)
        {
            //loop clients - check if they have messages - get messages - send messages
             if(clients.get(0).hasMessage())
             {
                 System.out.println(" client 0 got a message");
                 broadcast(clients.get(0).getMessage());
             }
             if(clients.get(1).hasMessage())
             {
                 System.out.println(" client 1 got a message");
                 broadcast(clients.get(1).getMessage());
             }
            if(clients.get(2).hasMessage())
            {
                System.out.println(" client 2 got a message");
                broadcast(clients.get(2).getMessage());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void update()
    {
        //loop clients - check if they have messages - get messages - send messages
            if(clients.get(0).hasMessage())
            {
                System.out.println(" clinet 0 got a message");
                broadcast(clients.get(0).getMessage());
            }
            if(clients.get(1).hasMessage()){
                System.out.println(" clinet 1 got a message");
                broadcast(clients.get(1).getMessage());
            }
            if(clients.get(2).hasMessage()){
                System.out.println(" clinet 2 got a message");
                broadcast(clients.get(2).getMessage());
            }
    }

    public void broadcast(String text)
    {
        for(int i = 0; i < clients.size(); i++)
            clients.get(i).display(text);
    }
}
