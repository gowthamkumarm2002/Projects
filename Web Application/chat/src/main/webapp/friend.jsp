<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Friends Page</title>
<link rel='stylesheet' href='css/fri.css'>
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
	<input type='hidden' id="status" value="<%=request.getAttribute("status") %>">
	<div class="container">
        <div class="header">
            <a href="home.jsp"><button class="back"><ion-icon name="arrow-back-sharp"></ion-icon></button></a>
            <img src="images/avatar.png" alt="profile">
            <p>${ Email}</p>
            <form action="logout" method="post">
           		<button class="logout"><ion-icon name="log-out-sharp"></ion-icon></button>
           	</form>
        </div>
        <div class="center">
        	<form action="friend" method="post">
        		<%ArrayList<String> log = (ArrayList<String>)request.getAttribute("list");
		        	for(String a:log){%>
		        <div class="select"></div>
	            <button  value="<%=a%>" name="Friname" width="300">
		                <div class="flex1">
		                    <img src="images/avatar.png" alt="profile" class="img">
		                </div>
		                <div class="flex">
		                    <div class="p"><%=a%></div>
		                    <div class="p2">You : How are you</div>
		                </div>
		        </button>
	           	<hr>
	           	<%}%>
	           	</div>
           	</form>
        </div>
    </div>
    
    
    
	<!-- <div class="container">
		<div class="form2">
			<a href="home.jsp"><button class="btn"><ion-icon name="arrow-back-sharp" size="30px"></ion-icon></button></a>
            <p class="pa">${ Email}</p>
            <form action="logout" method="post" class="btn1">
                <button class="btn"><ion-icon name="log-out-sharp" size="30px"></ion-icon></button>
            </form>
		</div>
		
		<div class="form1">
			<form action="friend" method="post">
				
	        </form>
		</div>
		
           <div class="form3">
              	<input type="text" name="FriName" placeholder="Type your friend name" required>
				<input type="submit" value="Chat" class="button">
            </div> 
	</div>	--> 
	<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Failed") {
			swal("Friend is not found...");
		}if (status == "You") {
			swal("You can't message yourself!!");
		}
	</script>
</body>
</html>