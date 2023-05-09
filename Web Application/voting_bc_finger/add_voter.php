<?php
include("include/protect.php");
include("include/dbconnect.php");
extract($_REQUEST);
$rdate=date("d-m-Y");
$m=date("m");
$y=date("y");
if(isset($btn))
{

$mq=mysqli_query($connect,"select max(id) from vt_voter");
$mr=mysqli_fetch_array($mq);
$id=$mr['max(id)']+1;
$vid="V".$m.$y;
$rno=str_pad($id,3,"0",STR_PAD_LEFT);
$voterid=$vid.$rno;
$pp1=substr($name,0,3);
$pp1=strtolower($pp1);
$pp2=rand(100,999);
$pass=$pp1.$pp2;

$dd=explode("-",$dob);
$dob1=$dd[2]."-".$dd[1]."-".$dd[0];

include 'phpqrcode/qrlib.php';
$text = $id;
  
// $path variable store the location where to 
// store image and $file creates directory name
// of the QR code file by using 'uniqid'
// uniqid creates unique id based on microtime
$path = 'images/';
$fn="Q".$id.".png";
$file = $path.$fn;
  
// $ecc stores error correction capability('L')
$ecc = 'L';
$pixel_Size = 10;
$frame_Size = 10;
 
$text=$aadhar;
// Generates QR Code and Stores it in directory given
$img=QRcode::png($text, $file, $ecc, $pixel_Size, $frame_size);
//////////////

$qry=mysqli_query($connect,"insert into vt_voter(id,division,voterid,name,gender,dob,address,area,city,contact,email,aadhar,pass,rdate) values($id,'$division','$voterid','$name','$gender','$dob1','$address','$area','$city','$contact','$email','$aadhar','$pass','$rdate')");

if($qry)
{
	/////////////////////////////////////////////
	 $q3=mysqli_query($connect,"select * from vt_blockchain order by id desc limit 0,1");
	 $r3=mysqli_fetch_array($q3);
	 
	 $prid=$r3['id'];
	 if($prid=="")
	 {
	 $pre_hash="00000000000000000000000000000000";
	 }
	 else
	 {
	 $q4=mysqli_query($connect,"select * from vt_blockchain where id=$prid");
	 $r4=mysqli_fetch_array($q4);
	 $pre_hash=$r4['hash_value'];
	 }
	 
	 $mq2=mysqli_query($connect,"select max(id) from vt_blockchain");
	 $mr2=mysqli_fetch_array($mq2);
	 $id2=$mr2['max(id)']+1;
	 
	$data="Voter ID:$voterid,Name:$name,Reg. Date:$rdate,Division:$division,Aadhar:$aadhar";
	$hash=md5($data);
	
	
	#$hash=bin2hex(Encode($data,"xyz"));
	mysqli_query($connect,"insert into vt_blockchain(id,block_id,pre_hash,hash_value,sdata,status) values($id2,'$id','$pre_hash','$hash','$data','reg')");
	//////////////////////////////////////////////////////////////
header("location:add_finger.php?id=".$id);
}

}
?>
<!DOCTYPE html>
<!-- 
Template Name: BRILLIANT Bootstrap Admin Template
Version: 4.5.6
Author: WebThemez
Website: http://www.webthemez.com/ 
-->
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

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
                                        <em>Today</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">28% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
                                            <span class="sr-only">28% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">85% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
                                            <span class="sr-only">85% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <?php include("include/link_admin.php"); ?>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Voter Information <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  
					</ol> 
									
		</div>
		
           
                   
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Add New</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <form class="form-horizontal">
									 <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">District</label>
                                            <div class="col-sm-10">
                                                <select name="city" class="form-control" onChange="this.form.submit()">
											  <option value="">-District-</option>
											   <?php
											  $dq=mysqli_query($connect,"select distinct(district) from vt_division order by district");
											  while($dr=mysqli_fetch_array($dq))
											  {
											  ?>
											  <option <?php if($dr['district']==$city) echo "selected"; ?>><?php echo $dr['district']; ?></option>
											  <?php
											  }
											  ?>
											  </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Division</label>
                                            <div class="col-sm-10">
                                                <select name="division" class="form-control">
												   <?php
											  $dq2=mysqli_query($connect,"select * from vt_division where district='$city'");
											  while($dr2=mysqli_fetch_array($dq2))
											  {
											  ?>
											  <option><?php echo $dr2['division']; ?></option>
											  <?php
											  }
											  ?>
												  </select>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Aadhar No.</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="aadhar" class="form-control" id="inputEmail3" placeholder="" required>
                                            </div>
                                        </div>
										
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Name</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="name" placeholder="" required>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Gender</label>
                                            <div class="col-sm-10">
                                                <input type="radio" name="gender" value="Male">Male
												<input type="radio" name="gender" value="Female">Female
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Date of Birth</label>
                                            <div class="col-sm-10">
                                                <input type="date" class="form-control" name="dob" placeholder="" required>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Address</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="address" class="form-control" id="inputEmail3" placeholder="" required>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Area</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="area" class="form-control" id="inputEmail3" placeholder="" required>
                                            </div>
                                        </div>
										
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Contact No.</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="contact" class="form-control" id="inputEmail3" placeholder="">
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">E-mail</label>
                                            <div class="col-sm-10">
                                                <input type="email" name="email" class="form-control" id="inputEmail3" placeholder="">
                                            </div>
                                        </div>
										
                                       
                                        <!--<div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                              <div class="checkbox3 checkbox-round checkbox-check checkbox-light">
                                                <input type="checkbox" id="checkbox-10">
                                                <label for="checkbox-10">
                                                  Remember me
                                                </label>
                                              </div>
                                            </div>
                                        </div>-->
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="submit" name="btn" class="btn btn-default" value="Add Voter">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
               
			<footer><p align="center">All right reserved. Voting System <a href="http://webthemez.com"></a></p></footer>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
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
