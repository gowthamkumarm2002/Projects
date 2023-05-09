<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Group</title>
<link rel='stylesheet' href='css/friend.css'>
</head>
<body>
	<div class="container">
		<div class="form2">
			<a href="groupchat.jsp"><button class="btn">
					<ion-icon name="arrow-back-sharp" size="30px"></ion-icon>
				</button></a>
			<p class="pa">${ Email}</p>
			<form action="logout" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="log-out-sharp" size="30px"></ion-icon>
				</button>
			</form>
		</div>
		<form action="groups" method="post">
			<div class="form1">
				<table class="tab" border="2" width="300">
					<tr>
						<th class="text1"><b>Group Names</b></th>
					</tr>
					<%
					ArrayList<String> log = (ArrayList<String>) request.getAttribute("list");
					for (String a : log) {
					%>
					<tr>
						<td class="text"><%=a%></td>
					</tr>
					<%}%>
				</table>
			</div>
			<div class="form3">
				<input type="text" name="Groupname"
					placeholder="Type your Group name" required> <input
					type="submit" value="Chat" class="button">
			</div>
		</form>
	</div>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>