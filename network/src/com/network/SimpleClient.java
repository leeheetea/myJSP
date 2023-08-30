package com.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
	
	public static void main(String[] args) {
		try (Socket client = new Socket("localhost", 5070);
			OutputStream os = client.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
				){
			oos.writeObject("안녕, 서버야");
			oos.flush();
		}
		 catch (IOException e) {
			e.printStackTrace();
		}
	}

}
