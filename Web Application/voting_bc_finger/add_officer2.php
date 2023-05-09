<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);

if(isset($btn))
{

$mq=mysqli_query($connect,"select max(id) from vt_booth");
$mr=mysqli_fetch_array($mq);
$id=$mr['max(id)']+1;

$uu=str_pad($id,3,"0",STR_PAD_LEFT);
$uname="B".$uu;
$pass="12345";

$qry=mysqli_query($connect,"insert into vt_booth(id,booth,name,area,city,division,contact,email,uname,pass) values($id,'$booth','$name','$area','$district','$division','$contact','$email','$uname','$pass')");

$message="Presiding  Officer: Username:$uname, Password:$pass";
echo '<iframe src="http://iotcloud.co.in/testmail/sendmail.php?message='.$message.'&email='.$email.'" style="display:none"></iframe>';
if($qry)
{
?>
	<script language="javascript">
	window.location.href="add_officer2.php?district2=<?php echo $district; ?>&div2=<?php echo $division; ?>";
	</script>
	<?php
	}

}
//////////////
if($act=="del")
{
mysqli_query($connect,"delete from vt_booth where id=$did");
?>
	<script language="javascript">
	window.location.href="add_officer2.php";
	</script>
	<?php
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
                            Presiding Officers <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  
					</ol> 
									
		</div>
		
		   <div id="page-inner"> 
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           Add Presiding Officers
                        </div>
						
						
						 <div class="panel-body">
                                    <form class="form-horizontal" method="post">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">District</label>
                                            <div class="col-sm-10">
                                               <select name="district" class="form-control" onChange="this.form.submit()">
	<option value="">-District-</option>
      <?php
	$cq1=mysqli_query($connect,"select distinct(district) from vt_division");
	while($cr1=mysqli_fetch_array($cq1))
	{
	?>
      <option <?php if($district==$cr1['district']) echo "selected"; ?>><?php echo $cr1['district']; ?></option>
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
	$cq2=mysqli_query($connect,"select distinct(division) from vt_division where district='$district'");
	while($cr2=mysqli_fetch_array($cq2))
	{
	?>
      <option <?php if($division==$cr2['division']) echo "selected"; ?>><?php echo $cr2['division']; ?></option>
      <?php
	}
	?>
    </select>
                                            </div>
                                        </div>
										
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Booth Name</label>
                                            <div class="col-sm-10">
                                               <input type="text" name="booth" class="form-control">
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Person Name</label>
                                            <div class="col-sm-10">
                                               <input type="text" name="name" class="form-control">
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Area</label>
                                            <div class="col-sm-10">
                                               <input type="text" name="area" class="form-control">
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Contact No.</label>
                                            <div class="col-sm-10">
                                               <input type="text" name="contact" class="form-control">
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">E-mail ID</label>
                                            <div class="col-sm-10">
                                               <input type="text" name="email" class="form-control">
                                            </div>
                                        </div>
										
										<div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="submit" name="btn" class="btn btn-default" value="Add">
                                            </div>
                                        </div>
                                    </form>
                                </div>
						
                        
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
			
		<div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                           View Presiding Officers
							
                        </div>
						
						
						 <div class="panel-body">
                                    <form class="form-horizontal" method="post">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">District</label>
                                            <div class="col-sm-10">
                                               <select name="district2" class="form-control" onChange="this.form.submit()">
	<option value="">-District-</option>
      <?php
	$cq11=mysqli_query($connect,"select distinct(district) from vt_division");
	while($cr11=mysqli_fetch_array($cq11))
	{
	?>
      <option <?php if($district2==$cr11['district']) echo "selected"; ?>><?php echo $cr11['district']; ?></option>
      <?php
	}
	?>
    </select>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label">Division</label>
                                            <div class="col-sm-10">
                                                <select name="div2" class="form-control">
      <?php
	$cq22=mysqli_query($connect,"select distinct(division) from vt_division where district='$district2'");
	while($cr22=mysqli_fetch_array($cq22))
	{
	?>
      <option <?php if($div2==$cr22['division']) echo "selected"; ?>><?php echo $cr22['division']; ?></option>
      <?php
	}
	?>
    </select>
                                            </div>
                                        </div>
										<div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <input type="submit" name="btn2" class="btn btn-default" value="Submit">
                                            </div>
                                        </div>
									</form>
							</div>
						</div>
					</div>
                <!-- /. ROW  -->
		   <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Presiding Officers
                        </div>
                        <div class="panel-body">
						<?php
						$qry=mysqli_query($connect,"select * from vt_booth where division='$div2'");
						$num=mysqli_num_rows($qry);
						if($num>0)
						{
						?>
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>S.No</th>
                                            <th>Booth Name</th>
                                            <th>Name</th>
                                            <th>Contact No.</th>
                                            <th>E-mail</th>
											<th>Username</th>
											<th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
										<?php
										while($row=mysqli_fetch_array($qry))
										{
										$i++;
										?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $i; ?></td>
											<td><?php echo $row['booth']; ?></td>
                                            <td><?php echo $row['name']; ?></td>
                                            <td><?php echo $row['contact']; ?></td>
                                            <td><?php echo $row['email']; ?></td>
                                            <td><?php echo $row['uname']; ?></td>
											<td><?php echo '<a href="add_officer2.php?act=del&did='.$row['id'].'">Delete</a>'; ?></td>
                                        </tr>
                                     	<?php
										}
										?>
										</tbody>
                                </table>
                            </div>
							<?php
							}
							?>
                        </div>
                    </div>
                     <!-- End  Kitchen Sink -->
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
