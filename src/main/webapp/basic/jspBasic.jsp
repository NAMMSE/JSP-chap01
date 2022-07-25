<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.ArrayList, java.util.List" %> <%-- jsp import --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP Basic</title>
</head>
<body>
	
	<h3># JSP의 처리 순서</h3>
	
	<ol>
		<li>JSP > .java(Servlet) > Compile > .class > add to Tomcat > execute > response반환 </li>
		<li>JSP로 코드를 작성한다.</li>
		<li>JSP코드는 자바 코드 형태로 1차 변환된다. (Servlet 형태로 변환)</li>
		<li>컴파일 후 실행 가능한 형태로 웹 컨테이너(Tomcat)에 등록된다</li>
		<li>요청을 받으면 웹 컨테이너가 해당 프로그램(JSP)을 실행해 생성되는 HTML 코드를 응답한다 (JSP는 실행하면 HTML코드를 생성하는 프로그램이다.)</li>
		<li> html 주석안에 jsp주석넣는 형태의 주석은 컴파일 될때는 주석으로 인식하지 않고 HTML로 처리될 때 주석으로 인식한다</li>
	</ol>
	
	
	
	<%-- JSP Script --%>
	
	<%-- 
		<%  %> : 모든 자바 코드를 사용할 수 있는 영역
		<%= %> : 원하는 값을 HTML에 출력
		<%! %> : 함수를 선언할 수 있는 영역
		<%@ %> : JSP 설정 영역
	--%>
	
	<%-- 
		이 주석은 컴파일러에게 처리되는 주석이기 때문에 HTML보다 먼저 처리된다
		(HTML의 주석은 웹 브라우저까지 도착해야 처리되는 주석이다.
	 --%>
	 <%
	 	// 메서드의 내부 처럼 사용할 수 있는 영역 
	 	
	 	int a = 10;
	 	int b = 11;
	 	
	 	class Apple{ // 메서드 내부의 클래스
	 		int size;
	 		int color;
	 		
	 		Apple(int size, int color){
	 			this.size = size;
	 			this.color = color;
	 		}
	 		
	 		public String toString(){
	 			return String.format("크기%d/%d번색", size, color);
	 		}
	 	}
	 
	 	List<Apple> apples = new ArrayList<>(); //ctrl + shift + o로 import 되지 않아서 위에서 적어줘야한다
	 	
	 	Apple apple1 = new Apple(123, 10);
	 	Apple apple2 = new Apple(444, 44);
	 	
	 	for(int i=0;i<10;i++){
	 		apples.add(new Apple(i, i));
	 	}
	 
	 %>
	 
	 <div><%=apple1 %></div>
	 <div><%=apple2 %></div>
	 <div><%=apples %></div>
	 
	 <table border="1">
	 <%	for(int i=0;i<apples.size();i++){ %>
	 	<tr>
	 		<td><%=apples.get(i).size %></td>
	 		<td><%=apples.get(i).color %></td>
	 	
	 	</tr>
	 <%} %>
	 </table>
	 
	 <%
	 	// 메서드 내부의 영역
	 	for(int i=0 ;i<10;i++){
	 		rabbit();
	 	}
	 
	 	// out 내장객체 : 출력 장소가 HTML인 미리 만들어져 있는 OutPutStream
	 	out.print("&nbsp;/)/)<br>");
	 	out.print("(&nbsp;&nbsp;..)<br>");
	 	out.print("(&nbsp;&nbsp;>$)<br>");
	 	
	 	for(int i=0;i<10;i++){
	 		out.print(String.format("<a href=\"link%d\">링크%d</a> <br>", i, i));
	 	}
	 %>
	 
	 
	 <%!
	 	// 클래스의 내부, 메서드 바깥처럼 사용할 수 있는 영역
	 	public static void rabbit(){
		 System.out.println(" /)/)");
		 System.out.println("(  ..)");
		 System.out.println("(  >$)");
		 
	 }
	 %>

</body>
</html>