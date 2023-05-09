<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Group</title>
<link rel='stylesheet' href='css/friend.css'>
</head>
<body>
	<input type='hidden' id="status" value="<%=request.getAttribute("status") %>">
	<div class="container">
		<div class="form2">
            <a href="groupchat.jsp"><button class="btn"><ion-icon name="arrow-back-sharp" size="30px"></ion-icon></button></a>
            <p class="pa">Create Group</p>
            <form action="logout" method="post" class="btn1">
                <button class="btn"><ion-icon name="log-out-sharp" size="30px"></ion-icon></button>
            </form>
		</div>
		<div class="form1">
			<form action="creategroup" method="post">
				<p>Choose Friends</p>
				<%ArrayList<String> log = (ArrayList<String>)request.getAttribute("list");
		        	for(String a:log){%>
					<input type="checkbox" class="check"name="members" value="<%=a%>"><%=a%><br>
				<%}%>
				<div class="form3">
	               <input type="text" name="groupname" placeholder="Enter Group Name" required>
					<input type="submit" value="Create" class="button">
	            </div>
			</form>
		</div>
	</div>
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Success") {
			swal("Congrats", "Group was Successfully created, You can Chat",
					"Sucesss");
		} else if (status == "Exist") {
			swal("Group alreay Exists...");
		}
	</script>
</body>
</html>