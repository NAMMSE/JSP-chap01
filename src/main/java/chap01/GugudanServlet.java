package chap01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/gugudan")
public class GugudanServlet extends HttpServlet {

	/*
	 	/chap01/servlet/gugudan으로 접속하는 클라이언트에게 예쁜 구구단 표를 응답하는 서블릿을 만들어보세요
	 */
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("EUC-KR"); // 한글 출력하는 인코딩
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>Gugudan</title></head><body>");
		out.print("<h3 style=\"font-size:30px; font-family:\'궁서체\';text-align:center;\">구구단</h3>");
		out.print("<table border=\"3\">");
		for(int i=1;i<10;i++){
		out.print("<tr style=\"background:teal; width: 60px; height: 60px; font-size:20px; margin:5px; \">");
			for(int j=2;j<10;j++) {
		out.print("<td style=\" margin:10px;width: 100px; height: 100px; padding:5px;\">");
		out.print(String.format("%d * %d = %d ",j, i, i*j));
		out.print("</td>");
			}
		out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body></html>");
		
		
		
		// 강사님 코드
		
		out.print("<html><head><title>Gugudan</title>");
		out.print("<meta charset=\"EUC-KR\">");
		out.print("<style>");
		out.print("table{background-color:black; color:white;}"
				+ "td {border:solid white 3px;}");
		out.print("</style>");
		out.print("</head><body>");
		out.print("<table>");
		for(int gop = 0; gop<=9;gop++) {
			out.print("<tr>");
			for(int dan=2;dan<=9;dan++) {
				if(gop == 0) {
					out.print(String.format("<th>%d 단</th>", dan));
				}else {
					out.print(String.format("<td>%d X %d = %d</td>", dan, gop, dan*gop));
				}
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body></html>");
	}
}
