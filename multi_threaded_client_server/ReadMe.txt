------------------------------------------------------------------------------------------------
Read Me File
------------------------------------------------------------------------------------------------
 *CSE-5344-COMPUTER NETWORKS
 *Done By:
 *Avinash Shanker
------------------------------------------------------------------------------------------------

************************************************************************
**** Note All the requirements are done and tested perfectly************
************************************************************************

How To Run:
1. My Code in written in Java, Eclipse IDE is used to write the code
2. There are two ways to run the code: From Command Line, browser or From Eclipse IDE
3. No external packages are required

------------------------------------------------------------------------------------------------
First Way, to run From Mac Terminal or Command Prompt
------------------------------------------------------------------------------------------------

1. Download the File and open two terminals. Say Terminal1(T1) and Terminal2(T2)
2. Navigate to /client_server_http/src/client_server_http
3. To compile the code ~$javac *.java
4. If the code compiles successfully, it will generate  3 java  .class files. Namely HttpRequest.class, WebClient.class, WebServer.class
5. Navigate one step back ~$cd .. or ~$cd /client_server_http/src
6. From T1 run the server ~$java client_server_http.WebServer <Port No>
7. Eg: ~$java client_server_http.WebServer 8083
8. If No port is given, default port is 8080 eg: ~$java client_server_http.WebServer

Now, server is running. Let's start client.

9. Open T2, Navigate to ~$cd /client_server_http/src
10.  Run java client_server_http.WebClient <Hostname> <PortNo> <FilePath>      ----Any of the argument can be skipped but in order only.
11. Eg: ~$java client_server_http.WebClient 127.0.0.1 8083 /threaded.html
12. If No arguments are passed, run as ~$java client_server_http.WebClient

------------------------------------------------------------------------------------------------
Second and Easiest way, is to Run from Browser
------------------------------------------------------------------------------------------------
1. Repeat steps 1to5 from above
2. From T1 run on default 8080 server ~$java client_server_http.WebServer <Port No>
3. Eg: ~$java client_server_http.WebServer
4. Open browser and paste below link, default page will open and guide you to test all operations specified in requirements.
5. http://127.0.0.1:8080/
6. Operations Like multithreading, 404 Not Found, File path download can be performed.

------------------------------------------------------------------------------------------------
References:
Code skeleton is taken from the material provided by Prof for the project
https://www.youtube.com/watch?v=vCDrGJWqR8w&t=648s
https://www.youtube.com/watch?v=orumeqLbrRY
https://www.programcreek.com/java-api-examples/?class=java.net.Socket&method=getOutputStream
https://docs.oracle.com/javase/tutorial/networking/sockets/readingWriting.html
https://www.youtube.com/watch?v=R-KWeKTVCJo
https://stackoverflow.com/questions/11862890/c-how-to-execute-a-http-request-using-sockets
http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html
https://stackoverflow.com/questions/34586733/sending-a-value-from-server-to-client-with-sockets
https://github.com/samruddhikapileshwar/
https://crunchify.com/java-stringtokenizer-and-string-split-example/
https://www.geeksforgeeks.org/java-gq/exception-handling-2-gq/
https://github.com/snehagundurao1612/
https://www.youtube.com/watch?v=LJjIaCKuzoc
https://stackoverflow.com/questions/1096621/read-string-line-by-line

