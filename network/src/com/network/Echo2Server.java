package com.network;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo2Server extends Thread {
	
	protected static boolean isCount = true;
	protected Socket socket = null;
	

	public Echo2Server(Socket accept) {
		socket = accept;
		start();
	}
	
	public void run() {
		BufferedReader bufferedReader;
		System.out.println("스레드가 실행 중 ...");
		
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputString;
			while( (inputString = bufferedReader.readLine()) != null) {
				System.out.println("받은 메시지 : " + inputString);
			}
			bufferedReader.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(5000);
		System.out.println("서버 소켓 생성 중 ...");
		
		while (isCount) {
			System.out.println("연결 대기 중 ...");
			new Echo2Server(serverSocket.accept());
		}
		serverSocket.close();
		
	}
}
