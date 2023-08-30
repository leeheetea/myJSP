package com.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressTest {
	
	public static void main(String[] args) {
		InetAddress addr1 = null;
		InetAddress addr2 = null;
		System.out.println("호스트 이름을 입력하세요 : ");
		Scanner in = new Scanner(System.in);
		String url = in.nextLine();
		
		try {
			addr1 = InetAddress.getByName(url);
			addr2 = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		System.out.print(url + "의 IP주소 :");
		System.out.println(addr1);
		System.out.println(addr1.getHostAddress());
		
		System.out.print("로컬의 IP주소 :");
		System.out.println(addr2.getHostAddress());
		

	}

}
