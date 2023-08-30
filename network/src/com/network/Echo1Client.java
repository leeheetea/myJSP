package com.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Echo1Client {

	public static void main(String[] args) throws Exception {
		Socket socket = null;
		PrintWriter printWriter = null;
		
		socket = new Socket();
		System.out.println("서버와 연결 시도 ...");
		socket.connect(new InetSocketAddress("127.0.0.1", 5070), 3000);
		System.out.println("서버와의 연결이 성공했습니다.");
		
		printWriter = new PrintWriter(socket.getOutputStream(), true);
		Scanner scanner = new Scanner(System.in);
		System.out.print("보낼 메시지를 입력하세요 : ");
		String inputString;
		while((inputString = scanner.nextLine()) != null) {
			if(inputString.contains("끝")) {
				break;
			}
			printWriter.println(inputString);
			System.out.println("보낼 메시지가 더 있나요?");
		}
		
		System.out.println("클라이언트 종료");
		socket.close();
		printWriter.close();
		scanner.close();
		;
	}
}
