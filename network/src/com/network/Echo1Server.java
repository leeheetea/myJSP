package com.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo1Server {
	public static void main(String[] args) throws Exception {
		BufferedReader inBufferedReader = null;
		ServerSocket serverSocket = new ServerSocket(5070);
		System.out.println("연결 대기중 ...");

		Socket connectionSocket = serverSocket.accept();
		System.out.println("메시지 대기중 ...");
		
		inBufferedReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		String msgString;
		while ( (msgString = inBufferedReader.readLine()) != null) {
			if (msgString.contains("끝")) {
				break;
			}
			System.out.println("읽은 메시지 : " + msgString);
		}
		System.out.println("서버종료");
		inBufferedReader.close();
		connectionSocket.close();
		serverSocket.close();
	}
}
