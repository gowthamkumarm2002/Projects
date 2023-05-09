<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group Chat</title>
<link rel='stylesheet' href='css/friend.css'>
</head>
<body>
	<div class="container">
		<div class="form2">
			<a href="home.jsp"><button class="btn"><ion-icon name="arrow-back-sharp" size="30px"></ion-icon></button></a>
            <p>Choose group</p>
            <form action="logout" method="post" class="btn1">
                <button class="btn"><ion-icon name="log-out-sharp" size="30px"></ion-icon></button>
            </form>
		</div>
		<div class="form">
			<form action="addmember" method="post">
				<input type="submit" value="Create Group">
			</form>
		</div>
		<div class="form">
			<form action="exitinggroup" method="post">
				<input type="submit" value="Existing Group">
			</form>
		</div>
	</div>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>