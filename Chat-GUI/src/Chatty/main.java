/**************************
 * Asa Murphy
 * 4/01/2019
 * Chat Application
 * CS 3354 Object Oriented
 **************************/

package Chatty;

/***********************************************************************************************************************
 * Class Name: Main
 * Access Level: Public
 *
 * The Main class is the driver class that calls all the instances of the client class and calls for the connection
 * between the client and servers and lastly, run the program.
 **********************************************************************************************************************/

public class main
{
    public static void main(String[] args)
    {
        Server s = new Server();
        Client a = new Client("Asa");
        s.connect(a);
        Client p = new Client("Paul");
        s.connect(p);
        Client d = new Client("Deontee");
        s.connect(d);
        s.run();

    }

}
