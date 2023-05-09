<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel='stylesheet' href='css/login.css'>
</head>
<body>
	<input type='hidden' id="status" value="<%=request.getAttribute("status") %>">
	
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
                <div class="card">
                    <div class="front">
                        <div class="form">
                            <h2>Login</h2>
                            <form action="login" method="post">
                                <div class="data">
                                    <input type="text" name="Email" placeholder="Enter your Email" required="Required">
                                </div>
                                <div class="data">
                                    <input type="password" name="Password" placeholder="Enter your Password" required="Required" id="pass">
                                </div>
                                <div class="forget">
                                    <a href="#">Forgot Password?</a>
                                </div>
                                <div class="data">
                                    <input type="submit"  value="LOGIN">
                                </div>
                                <div class="signup">Not a Member?
                                    <a href="register.jsp" >Signup now</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
    </section>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>

	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Failed") {
			swal("Error", "Name and password is Wrong", "Failed");
		}
	</script>
</body>
</html>