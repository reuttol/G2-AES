package logic;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.ArrayList;

import client.*;
import common.*;
import gui.QuestionRepositoryGUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class constructs the UI for a chat client.  It implements the
 * chat interface in order to activate the display() method.
 * Warning: Some of the code here is cloned in ServerConsole 
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge  
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole extends Application implements ChatIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  public static ArrayList<Question> questions = new ArrayList<Question>();
 
  public static String host;
  public QuestionRepositoryGUI qrg;
  ChatClient client;
  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  public ClientConsole() 
  {
    try 
    {
      client= new ChatClient(host, DEFAULT_PORT, this);
    } 
    catch(IOException exception) 
    {
      System.out.println("Error: Can't setup connection!"
                + " Terminating client.");
      System.exit(1);
    }
  }

  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  public void accept(Object message) 
  {
    client.handleMessageFromClientUI(message);
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  public void display(Object message) 
  {
	  if(message instanceof String)
		  System.out.println(">"+message);
	  if(message instanceof ArrayList)
		  questions=(ArrayList<Question>) message;
  }

  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  public static void main(String[] args) 
  {
    host = "";
    int port = 0;  //The port number

    try
    {
      host = args[0];
    }
    catch(ArrayIndexOutOfBoundsException e)
    {
      host = "localhost";
    }
    ClientConsole chat= new ClientConsole();
    chat.accept("GiveMeQuestions");  //Wait for console data
    try {
		Thread.sleep(2000L);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    launch(args);
  }

	@Override
	public void start(Stage arg0) throws Exception 
	{
		qrg = new QuestionRepositoryGUI();
		qrg.start(arg0);
	}
}
//End of ConsoleChat class
