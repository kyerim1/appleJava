<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="org.json.simple.JSONObject" %>     
<%@ page import="org.json.simple.parser.JSONParser" %>  
<%@ page import="java.util.Calendar" %>

<%
	request.setCharacterEncoding("utf-8");
	StringBuffer jsonbuf = new StringBuffer();
	JSONObject jsonobj = null;
	String json=null;
	String line=null; 
	
	try{
		BufferedReader bf = request.getReader();
		while( (line=bf.readLine()) != null ){
			jsonbuf.append(line);
		}
		json = jsonbuf.toString();
		System.out.println(json);
		
		JSONParser par = new JSONParser();
		jsonobj = (JSONObject)par.parse(json);
		
		System.out.println( jsonobj.get("close") );
		
		Cookie cook = new Cookie("today","none");
		
		Calendar today = Calendar.getInstance();
		
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int min = today.get(Calendar.MINUTE);
		int sec = today.get(Calendar.SECOND);
		
		System.out.println(hour +":"+min+":"+sec);
		
		// 하루의 마지막 - 23:59:59  -> 23*60*60 + 59*60 + 59
		//  현재시간 - 23:58:30
		int last = 23*60*60+59*60+59;
		int now = hour*60*60+min*60+sec;
		System.out.println(last-now);
		cook.setMaxAge(last-now);
		response.addCookie(cook);
		
		
	}catch(Exception e){
		System.out.println("json 실패");
		e.printStackTrace();
	} 

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>