<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Page</title>
<link rel='stylesheet' href='css/friend.css'>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Progma", "no-cache");
	response.setHeader("Expires", "0");
	if (session.getAttribute("Email") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container">
		<div class="form2">
			<form action="back" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="arrow-back-sharp" size="30px"></ion-icon>
				</button>
			</form>
			<p class="pa">${ FriName}</p>
			<form action="logout" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="log-out-sharp" size="30px"></ion-icon>
				</button>
			</form>
		</div>
		<div class="form4">
			<p class="text">No message</p>
		</div>
		<form action="message" method="post">
			<div class="form3">
				<input type="text" name="msg" placeholder="Type message...." required>
				<input type="submit" value="Send" class="button">
			</div>
		</form>
	</div>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script><script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Success") {
			swal("Message was sended");
		}
	</script>
</body>
</html>