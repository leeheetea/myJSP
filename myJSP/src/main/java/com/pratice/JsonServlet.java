package com.pratice;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// API URL 설정
		int page = 1; // 기본값 설정

//		 클라이언트에서 전달된 page 값을 가져옵니다.
		String pageParam = request.getParameter("pageno");
		if (pageParam != null && !pageParam.isEmpty()) {
			try {
				page = Integer.parseInt(pageParam);
			} catch (NumberFormatException e) {
				// 잘못된 형식의 페이지 번호가 전달될 경우 기본값 사용
			}
		}
		
		String apiUrl = "https://sample.bmaster.kro.kr/contacts?pageno=" + page;

		// API에 연결하여 데이터 가져오기
		URL url = new URL(apiUrl);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		// 데이터 읽기
		InputStream inputStream = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(inputStream);
		StringBuilder data = new StringBuilder();
		int c;
		while ((c = reader.read()) != -1) {
			data.append((char) c);
		}
		reader.close();

		// JSON 파싱
		JsonObject jsonObject = JsonParser.parseString(data.toString()).getAsJsonObject();

		// JSON 데이터에서 필요한 정보 추출
		JsonArray contactsArray = jsonObject.getAsJsonArray("contacts");

		// JsonArray 반복하여 각 요소에 접근
		for (JsonElement contactElement : contactsArray) {
			JsonObject contactObject = contactElement.getAsJsonObject();
			String name = contactObject.get("name").getAsString();
			String tel = contactObject.get("tel").getAsString();
			String address = contactObject.get("address").getAsString();
			String photo = contactObject.get("photo").getAsString();
		}

		// JsonArray 반복하여 각 요소에 접근
		StringBuilder tableBuilder = new StringBuilder();

		// HTML 테이블 시작 및 헤더 작성
		tableBuilder.append("<table border='1'>");
		tableBuilder.append("<thead>");
		tableBuilder.append("<tr>");
		tableBuilder.append("<th>Name</th>");
		tableBuilder.append("<th>Tel</th>");
		tableBuilder.append("<th>Address</th>");
		tableBuilder.append("<th>Photo</th>");
		tableBuilder.append("</tr>");
		tableBuilder.append("</thead>");
		tableBuilder.append("<tbody>");

		for (JsonElement contactElement : contactsArray) {
			JsonObject contactObject = contactElement.getAsJsonObject();
			String name = contactObject.get("name").getAsString();
			String tel = contactObject.get("tel").getAsString();
			String address = contactObject.get("address").getAsString();
			String photo = contactObject.get("photo").getAsString();

			tableBuilder.append("<tr>");
			tableBuilder.append("<td>").append(name).append("</td>");
			tableBuilder.append("<td>").append(tel).append("</td>");
			tableBuilder.append("<td>").append(address).append("</td>");
			tableBuilder.append("<td><img src='").append(photo).append("' alt='Photo' width='100'></td>");
			tableBuilder.append("</tr>");
		}

		tableBuilder.append("</tbody>");
		tableBuilder.append("</table>");

		// 응답 생성
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<html><body>");
		response.getWriter().println(tableBuilder.toString());
		response.getWriter().println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
