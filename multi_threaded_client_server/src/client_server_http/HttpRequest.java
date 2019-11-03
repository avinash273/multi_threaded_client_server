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
import java.util.*;

final class HttpRequest implements Runnable {
	final static String CRLF = "\r\n";
	//Declaring Socket
	Socket socket;
	
	//For runnable class, also this call calls processRequest()
	public void run() {
		try {
			processRequest();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//Constructor for HttpRequest
	public HttpRequest(Socket socket) throws Exception {
		this.socket = socket;
	}
	
	//This  function returns content type like HTML, JPG, GIF
	public String contentType(String html_data) {
		if (html_data.endsWith(".gif"))
			return "image/gif";
		else if (html_data.endsWith(".html"))
			return "text/html";
		else if (html_data.endsWith(".jpeg") || html_data.endsWith(".jpg"))
			return "image/jpeg";
		else
			return html_data;
	}
	
	
	public void sendBytes(FileInputStream html_body, DataOutputStream os) throws IOException {
		//Function sendBytes makes a temp memory block before it writes output data stream
		int i;
		byte[] memory = new byte[2048];
		while ((i = html_body.read(memory)) != -1) {
			os.write(memory,0,i);
		}
	}

	public void processRequest() throws Exception {
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		InputStream is = socket.getInputStream();
		//This function is for processing sockets output and input data streams
		//Buffer Reading variable
		BufferedReader buffer_holder = new BufferedReader(new InputStreamReader(is));
		//Reads Line  from buffer and holds the request
		String http_request = buffer_holder.readLine();
		System.out.println("GET Request: "+ buffer_holder.readLine());
		//To check  and  divert to default index.html if no page is called
		if (((http_request.contains("html")) || (http_request.contains("jpg")) || (http_request.contains("gif"))|| (http_request.contains("txt"))) != true) {
			http_request = "GET /index.html HTTP/1.1";
			System.out.println("GET Request Was Empty Diverting To Default Page(Link): "+http_request);
		}
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Client Server Info: ");
		System.out.println("-----------------------------------------------------------------------------------");
		
		//Read from buffer line by line until EOF
		String head = "";
		do {
			System.out.println(head);
		}while ((head = buffer_holder.readLine()).length() != 0);
		System.out.println("-----------------------------------------------------------------------------------");

		//Tokenizing client request
		StringTokenizer tokenize = new StringTokenizer(http_request);
		tokenize.nextToken();
		String html_data = tokenize.nextToken();
		System.out.println("File Requested By Client: "+html_data);
		//Adding dot to  check  in folder code is run
		html_data = "." + html_data;
		
		FileInputStream html_body = null;
		int fileExists = 1;
		try {
			html_body = new FileInputStream(html_data);
		} catch (FileNotFoundException e) {
			fileExists = 0;
		}
		
		//If file exists then return OK else  404 not found
		String statusLine, contentTypeLine, entityBody = null;
		if (fileExists == 0) {
			statusLine = "HTTP/1.1 404 Not Found\n";
			contentTypeLine = "HTTP/1.1 404 Not Found or 400 Bad Request\n";
			entityBody = "<HTML>" + "<HEAD><TITLE>404 Not Found</TITLE></HEAD>" + "<BODY><font size=\"6\">404 Not Found</font></BODY></HTML>";
			System.out.println("Content Type: " + contentTypeLine);
			System.out.println("-----------------------------------------------------------------------------------");
		}
		else {
			contentTypeLine = contentType(html_data) + CRLF;
			statusLine = "HTTP/1.1 200 OK\n";
			System.out.println("Content Type:"+contentType(html_data));
			System.out.println("-----------------------------------------------------------------------------------");
		}
		
		//write status and CLRF to data output stream
		os.writeBytes(statusLine);
		os.writeBytes(CRLF);

		//sendBytes write HTML if file exists
		if (fileExists == 1) {
			sendBytes(html_body, os);
		}
		else {
			os.writeBytes(entityBody);
		}
		
		//closing sockets and clients
		html_body.close();
		os.close();
		buffer_holder.close();
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
