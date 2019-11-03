/*
 *CSE-5344-COMPUTER NETWORKS
 *Done By:
 *Avinash Shanker
 *1001668570
 *References at the end of code
*/

package client_server_http;

import java.io.*;
import java.net.*;

public class WebClient {
	public static void main(String arg[]) throws IOException {
		//Code to check  if from command line how many parameters are passed
		//take action according to the number of parameters
		int port_no = 8080;
		String server_name = "127.0.0.1";
		String file_temp ="";
		String file_path ="GET /index.html HTTP/1.0\\r\\n\\r\\n";
		
		if(arg.length == 0) {
			server_name = "127.0.0.1";
			port_no = 8080;
			file_path = "GET /index.html HTTP/1.0\r\n\r\n";
		}
		else if (arg.length == 1) {
			server_name = arg[0];
			port_no = 8080;
			file_path = "GET /index.html HTTP/1.0\r\n\r\n";
		}
		else if (arg.length == 2) {
			server_name = arg[0];
			port_no = Integer.parseInt(arg[1]);
			file_path = "GET /index.html HTTP/1.0\r\n\r\n";
		}
		else {
			server_name = arg[0];
			port_no = Integer.parseInt(arg[1]);
			file_temp = arg[2];
			file_path = "GET " + file_temp + " HTTP/1.0\r\n\r\n";
			System.out.println("Command Line: "+file_path);
			
		}
		//socket to connect to server to specified port
		Socket socket = new Socket(server_name, port_no);
		PrintStream printstream = new PrintStream(socket.getOutputStream());
		InputStreamReader is = new InputStreamReader(socket.getInputStream());
		BufferedReader buffer = new BufferedReader(is);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Client Logs:");
		System.out.println("Server: "+server_name);
		System.out.println("Port No: "+port_no);
		//print from stream containing file path value
		printstream.println(file_path);
		System.out.println("-----------------------------------------------------------------------------------");
		String contents = null;
		do {
			contents = buffer.readLine();
			System.out.println(contents);
		} while (contents != null);
		printstream.flush();
		//Closing socket
		socket.close();
	}

}

/* References
 * Code skeleton is taken from the material provided by Prof for the project
 * https://www.youtube.com/watch?v=vCDrGJWqR8w&t=648s
 * https://www.youtube.com/watch?v=orumeqLbrRY
 * https://www.programcreek.com/java-api-examples/?class=java.net.Socket&method=getOutputStream
 * https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
 * https://www.youtube.com/watch?v=R-KWeKTVCJo
 * https://stackoverflow.com/questions/11862890/c-how-to-execute-a-http-request-using-sockets
 * http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html
 * https://stackoverflow.com/questions/34586733/sending-a-value-from-server-to-client-with-sockets
 * https://github.com/samruddhikapileshwar/
 * https://crunchify.com/java-stringtokenizer-and-string-split-example/
 * https://www.geeksforgeeks.org/java-gq/exception-handling-2-gq/
 * https://github.com/snehagundurao1612/
 * https://www.youtube.com/watch?v=LJjIaCKuzoc
 * https://stackoverflow.com/questions/1096621/read-string-line-by-line
 */

