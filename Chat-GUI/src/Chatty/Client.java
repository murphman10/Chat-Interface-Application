/**************************
 * Asa Murphy
 * 4/01/2019
 * Chat Application
 * CS 3354 Object Oriented
 **************************/

package Chatty;

import java.util.ArrayList;

/***********************************************************************************************************************
 * Class Name: Client
 * Access Level: Public
 *
 * The Client class contains half of the connection components to the server. It also contains the conditions for
 * passing messages between the two.
 **********************************************************************************************************************/

public class Client
{
    public String name;
    public ArrayList<String> msgs;
    public ChatBox cb;

    public Client(String name) //constructor
    {
        this.name = name;
        msgs = new ArrayList<String>();
        cb = new ChatBox(this);

        send(" joined the ChatBox");

    }

    public void send(String text) //used for the send button action listener.
    {

        msgs.add(name + ": " + text +"\n");

    }

    public boolean hasMessage() //a check for if there are any messages.
    {
        if (msgs.size() > 0)
        {
            return true;
        }else
         return false;
    }

    public String getMessage() // if there is a message, this method is used to retrieve it.
    {
        String ret = msgs.get(0);
        msgs.remove(0);
        msgs.trimToSize();
        return ret;
    }

    public void display(String msg) //displays message
    {

        cb.writeBox(msg);
    }

}
