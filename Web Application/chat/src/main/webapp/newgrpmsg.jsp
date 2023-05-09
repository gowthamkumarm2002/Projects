<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
<link rel='stylesheet' href='css/friend.css'>
</head>
<body>
	<div class="container">
		<div class="form2">
			<form action="back2" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="arrow-back-sharp" size="30px"></ion-icon>
				</button>
			</form>
			<p class="pa">${ GrpName}</p>
			<form action="add" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="add-circle" size="30px"></ion-icon>
				</button>
			</form>
			<form action="logout" method="post" class="btn1">
				<button class="btn">
					<ion-icon name="log-out-sharp" size="30px"></ion-icon>
				</button>
			</form>
		</div>
		<div class="form4">
			<p class="text">No message</p>
		</div>
		<form action="groupmsg" method="post">
			<div class="form3">
				<input type="text" name="msg" placeholder="Type message...."
					required> <input type="submit" value="Send" class="button">
			</div>
		</form>
	</div>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Success") {
			swal("Message was sended");
		}
	</script>
</body>
</html>