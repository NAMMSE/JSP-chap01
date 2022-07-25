package chap01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 그 외의 설정들은 JSP의 <%@ %>이 담당한다

@WebServlet("/servlet/basic")
public class ServletBasic extends HttpServlet{

	// 원하는 메서드를 추가할 수 있는 곳. JSP의 <%! %>
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest  : 사용자의 요청 정보 객체
		// HttpServletResponse : 처리가 끝난 후 응답할 객체 
		
		// 사용자가 요청을 보내면 처리해주는 부분. JSP 의 <% %>
		
		// JSP페이지의 out 내장객체
		PrintWriter out = resp.getWriter(); // resp에 응답할 내용들을 담아둔 후 메서드가 끝날 때 사용자의 웹 브라우저에 반환한다
		// 웹 컨테이너에 이 메서드를 실어놓고 요청 시 전부 반환하는 개념
		
		// 자바 스크립트는 사용자의 페이지에서 동작하지만 서버측에서는 접근할 수가 없기 때문에 서버측에서도 프로그래밍 할 언어가 필요하다 그게 저 JSP로 resp에 담는 것
		
		// 자바를 통해 여러 처리를 진행한 후, 처리 결과물을 사용해 페이지를 만들어 응답할 수 있다.
		// 주로 서버측에 저장된 DB또는 파일의 데이터를 이요하여 처리를 진행한다.
		
		// JSP에서 1차 자바코드로 변환한형태
		out.print("<html>");
		out.print("<head>");
		out.print("<title>My Servlet Page</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div style=\"width: 100px; height: 100px; background: red; \"></div>");
		out.print("<script>for (i=0;i<100;i++) {console.log(i*i);}</script>"); // 이 포문은 자바가 아니라 사용자의 웹 페이지에서 실행되는 포문
		out.print("</body>");
		out.print("</html>");
	}
}
