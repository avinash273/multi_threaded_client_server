/*
 *CSE-5344-COMPUTER NETWORKS
 *Done By:
 *Avinash Shanker
 *1001668570
 *References at the end of code
*/

package client_server_http;

import java.net.*;

public class WebServer {
	public static void main(String arg[]) throws Exception {
		//Setting Default port to 8080
		int port_no = 8080;	
		//From command line if port if not give use 8080
		if(arg.length == 0) {
			port_no = 8080;
		}
		else {
			port_no = Integer.parseInt(arg[0]);
		}
		
		ServerSocket socket = new ServerSocket(port_no);
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Server Logs:");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Server Ready On Port: " + port_no);
		
		//Keep the sever open
		do {
			//Create and accept socket connection
			Socket socket_client = socket.accept();
			HttpRequest http = new HttpRequest(socket_client);
			Thread thread = new Thread(http);
			//Each request is allocated a new thread.
			//Multithreading
			thread.start();
			//Comment to keep the socket in Listening loop.
			//socket.close();
		} while (true);
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

