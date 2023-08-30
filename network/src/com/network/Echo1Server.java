package com.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo1Server {
	public static void main(String[] args) throws Exception {
		BufferedReader inBufferedReader = null;
		PrintWriter outPrintWriter = null;
		
		ServerSocket serverSocket = new ServerSocket(5070);
		System.out.println("연결 대기중 ...");

		Socket socket = serverSocket.accept();
		System.out.println("메시지 대기중 ...");
		
		inBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outPrintWriter = new PrintWriter(socket.getOutputStream(), true);
		
		String msgString;
		while ( (msgString = inBufferedReader.readLine()) != null) {
			if (msgString.contains("끝")) {
				break;
			}
			System.out.println("읽은 메시지 : " + msgString);
			outPrintWriter.println("응답 메시지");
		}
		System.out.println("서버종료");
		inBufferedReader.close();
		outPrintWriter.close();
		socket.close();
		serverSocket.close();
	}
}
