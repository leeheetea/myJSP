package com.network;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5070);
			Socket connectionSocket = server.accept();
			InputStream is = connectionSocket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			String str = (String) ois.readObject();
			System.out.println("받은 문자열: " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
