/**************************
 * Asa Murphy
 * 4/01/2019
 * Chat Application
 * CS 3354 Object Oriented
 **************************/

package Chatty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***********************************************************************************************************************
 * Class Name: ChatBox
 * Access Level: Public
 *
 * The ChatBox class is the class that creates the GUI to be used by the user of the program. It implements Swing
 * components like JFrame, JPanel, JTextArea, JScrollPane and JButton. This class also has a constructor that implements
 * the GUI for the Client side.
 **********************************************************************************************************************/

public class ChatBox
{   JFrame frame = new JFrame("ChatBox");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JTextArea input = new JTextArea();
    JButton button = new JButton("Send");

    int width = 600;
    int height = 900;

    JTextArea text = new JTextArea();
    JScrollPane scroll = new JScrollPane(text);

    public ChatBox(Client c) //constructor for the GUI
    {
        frame.setSize(width, height);
        frame.setTitle(c.name);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        input.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        scroll.setPreferredSize(new Dimension(width - 40, height - 150));
        panel1.add(scroll);

        frame.add(panel1, BorderLayout.CENTER);

        panel2.setLayout(new BorderLayout());
        panel2.add(input, BorderLayout.CENTER);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.send(input.getText());
                input.setText(null);

                Server.getHostServer().update();
            }
        });
        button.setSize(150,150);
        panel2.add(button, BorderLayout.EAST);
        frame.add(panel2, BorderLayout.SOUTH);

    }

    public void writeBox(String w)
    {
        text.append(w);
    }

}
