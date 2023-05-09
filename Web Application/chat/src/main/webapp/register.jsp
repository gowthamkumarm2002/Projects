<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel='stylesheet' href='css/login.css'>
</head>
<body>
	<input type='hidden' id="status"
		value="<%=request.getAttribute("status")%>">
		
		
	<section>
        <div class="color"></div>
        <div class="color"></div>
        <div class="color"></div>
        <div class="box">
            <div class="square" style="--i:0;"></div>
            <div class="square" style="--i:1;"></div>
            <div class="square" style="--i:2;"></div>
            <div class="square" style="--i:3;"></div>
            <div class="square" style="--i:4;"></div>
            <div class="container" id="rot">
                <div class="card2">
                    <div class="front">
                        <div class="form">
                            <h2>Register</h2>
                        <form action="register" method="post">
                            <div class="data">
                                <input type="text" placeholder="Enter your Full name" name="Name" required>
                            </div>
                            <div class="data">
                                <input type="email" placeholder="Enter your Email" name="Email" required>
                            </div>
                            <div class="data">
                                <input type="password" placeholder="Enter your Password" name="Password" id="pass" required>
                            </div>
                            <div class="data">
                                <input type="text" placeholder="Enter your Mobile No" name="Mobile" id="pass" required>
                            </div>
                            <div class="data">
                                <input type="submit"  value="Register">
                            </div>
                            <div class="login">Already a Member?
                                <a href="login.jsp">Login now</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </session>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Success") {
			swal("Congrats", "Account Successfully created, You can Login",
					"Sucesss");
		} else if (status == "Exists") {
			swal("Account alreay Exists...");
		}
	</script>
</body>
</html>