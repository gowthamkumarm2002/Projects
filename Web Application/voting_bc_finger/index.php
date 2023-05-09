<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
$rdate=date("d-m-Y");
$m=date("m");
$y=date("y");



$aq=mysqli_query($connect,"select * from vt_admin where username='admin'");
$ar=mysqli_fetch_array($aq);
$election_st=$ar['election_st'];
$vdate=$ar['vdate'];

if(isset($btn))
{
	if($officer=="1")
	{
		$q2=mysqli_query($connect,"select * from vt_officer1 where uname='$uname' && pass='$pass'");
		$n2=mysqli_num_rows($q2);
		if($n2>0)
		{
		$r2=mysqli_fetch_array($q2);
		$_SESSION['uname']=$uname;
		    header("location:home.php");
		}
		else
		{
		$msg="Invalid ID!";
		}
	}
	else if($officer=="2")
	{
		$q2=mysqli_query($connect,"select * from vt_booth where uname='$uname' && pass='$pass'");
		$n2=mysqli_num_rows($q2);
		if($n2>0)
		{
		$r2=mysqli_fetch_array($q2);
		$_SESSION['uname']=$uname;
		header("location:booth_home.php");
		}
		else
		{
		$msg="Invalid ID!";
		}
	}
	else
	{
	
		$vdate=date("d-m-Y");
			$q1=mysqli_query($connect,"select * from vt_admin where username='admin' && vdate='$vdate'");
			$n1=mysqli_num_rows($q1);
			
			if($n1>0)
			{
				$q2=mysqli_query($connect,"select * from vt_poll where uname='$uname' && pass='$pass'");
				$n2=mysqli_num_rows($q2);
				if($n2>0)
				{
				$r2=mysqli_fetch_array($q2);
				$_SESSION['booth']=$r2['officer'];
				    header("location:index1.php");
				}
				else
				{
				$msg="Invalid ID!";
				}
			}
			else
			{
			$msg="No Election!!!";
			}
	}
}	
if(isset($btn1))
{
$vdate=date("d-m-Y");
	$q1=mysqli_query($connect,"select * from vt_admin where username='admin' && vdate='$vdate'");
	$n1=mysqli_num_rows($q1);
	
	if($n1>0)
	{
	?>
    <script language="javascript">
	window.location.href="index1.php";
	</script>
	<?php
	}
	else
	{
	$msg1="No Election!!!";
	}


}

?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta content="" name="description" />
    <meta content="webthemez" name="author" />
    <title><?php include("include/title.php"); ?></title>
	<!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
	
    <link href="assets/css/select2.min.css" rel="stylesheet" >
	<link href="assets/css/checkbox3.min.css" rel="stylesheet" >
        <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
     <!-- Google Fonts-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href=""><strong><!--<i class="icon fa fa-plane"></i>--> <?php include("include/title1.php"); ?></strong></a>
				<div id="sideNav" href="">
			<i class="fa fa-bars icon"></i> 
			</div>
            </div>

        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <?php include("include/link_home.php"); ?>
            </div>
        </nav>

        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div class="header"> 
                <h1 class="page-header">
                    Election Commission of India <small></small>
                </h1>
            </div>
            <div class="row">
            <div class="col-sm-6 col-xs-12">  
                <div class="panel panel-default chartJs">
                    <div class="panel-heading">
                        <div class="card-title">
                            <div class="title"></div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <img src="assets/img/election-commission.jpg" class="img-responsive">
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xs-12">
                <div class="panel panel-default chartJs">
                    
                    <div class="panel-heading">
                        <div class="card-title">
                            <div class="title">Login</div>
                        </div>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal" method="post">
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-3 control-label">Officer</label>
                                <div class="col-sm-9">
                                    <select name="officer" class="form-control">
                                    <option value="1">Returning Officer</option>
                                    <option value="2">Presiding Officer</option>
                                    <option value="3">Polling Officer</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-3 control-label">Username</label>
                                <div class="col-sm-9">
                                    <input type="text" name="uname" class="form-control" id="inputEmail3" placeholder="Username">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                                <div class="col-sm-9">
                                    <input type="password" name="pass" class="form-control" id="inputPassword3" placeholder="Password">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-9">
                                    <input type="submit" name="btn" class="btn btn-default" value="Login">
                                </div>
                            </div>
                        </form>
                        <div class="alert-danger"><?php echo $msg; ?></div>
                    </div>
                </div>
            </div>
        </div>

		<div class="row">
            <div class="col-sm-6 col-xs-12">  
                <div class="panel panel-default chartJs">
                    <div class="panel-heading">
                        <div class="card-title">
                            <div class="title">Election Commission of India</div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <img src="assets/img/india-voting.jpg" class="img-responsive">
                    </div>
                </div>
            </div>
            <div class="col-sm-6 col-xs-12">
                <div class="panel panel-default chartJs">
                    <div class="panel-heading">
                        <div class="card-title">
                            <div class="title">Election Commission</div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div align="justify">
                        The Election Commission of India is an autonomous constitutional authority responsible for administering Union and State election processes in India.
                        </div>
                        <div align="justify">
                        The election commission has the right to allow symbols to the political parties. It gives recognition to the national parties, state parties and regional parties. 
                        </div>
                        <div align="justify">
                        Electronic Voting Machine (also known as EVM ) is voting using electronic means to either aid or take care of the chores of casting and counting votes.
                        </div>
                        <div align="justify">
                        The Election Commission of India (ECI) is an autonomous body under the ownership of Ministry of Law and Justice, Government of India. It is established by the Constitution of India directly to ensure free and fair elections in the country. 
                        </div>
                        <div align="justify">
                        Thus, the Election Commission is an all-India body in the sense that it is common to both the Central government and the state governments.
                        </div>
                    </div>
                </div>
            </div>
        </div>
							
		<footer><p align="center"><a href="attack.php">Attack</a> | Voting System <a href="http://webthemez.com"></a></p></footer>
	</div>
             <!-- /. PAGE INNER  -->
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/select2.full.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  $(".selectbox").select2();
	});
	</script>
      <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
	
		
   
</body>
</html>
