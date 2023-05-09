<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
//$rdate=date("d-m-Y");
$uname=$_SESSION['uname'];
$qry=mysqli_query($connect,"select * from vt_booth where uname='$uname'");
$row=mysqli_fetch_array($qry);
$name=$row['name'];
$area=$row['area'];
$booth=$row['booth'];
$city=$row['city'];
$division=$row['division'];

$qry2=mysqli_query($connect,"select * from vt_division where division='$division' && district='$city'");
$row2=mysqli_fetch_array($qry2);
$vcount=$row2['vcount'];
$per=$row2['percent'];
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
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
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
                <a class="navbar-brand" href=""><strong> <?php include("include/title1.php"); ?></strong></a>
				
		        <div id="sideNav" href="">
                    <i class="fa fa-bars icon"></i> 
		        </div>
            </div>
    </div>
            
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <?php include("include/link_officer2.php"); ?>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Presiding Officer <small>  </small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="booth_home.php">Home</a></li>
					
					</ol> 
									
		</div>
            <div id="page-inner">

                <!-- /. ROW  -->
				
				<div class="row">
					<div class="col-md-4">
						<div class="panel panel-primary">
							<div class="panel-heading">
							Presiding Officer: <?php echo $name." (".$uname.")"; ?>
							</div>
							<div class="panel-footer">
							Booth: <?php echo $booth; ?>
							</div>
							<div class="panel-footer">
							Division: <?php echo $division; ?>
							</div>
							<div class="panel-footer">
							District: <?php echo $city; ?>
							</div>
						</div>
					</div><!--md4-->
					<div class="col-md-4">
								<div class="board">
									<div class="panel panel-primary">
										<div class="number">
											<h3>
												<h3><?php echo $vcount; ?></h3>
												<small>Vote Count</small>
											</h3> 
										</div>
										<div class="icon">
										   <i class="fa fa-user fa-5x yellow"></i>
										</div>
					 
									</div>
								</div>
							</div><!--md3-->
					<div class="col-md-4">
							<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>Vote Registered</h4>
								<div class="easypiechart" id="easypiechart-blue" data-percent="<?php echo $per; ?>" ><span class="percent"><?php echo $per; ?>%</span>
								</div>
							</div>
				</div>
					</div><!--md3-->
							
				</div><!--row-->
				
				
               
				     <div class="row">
                        <div class="col-sm-6 col-xs-12">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Voters</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>S No.</th>
                                                <th>Name</th>
                                                <th>Gender</th>
                                                <th>Age</th>
                                                <th>Aadhar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
										<?php
										$q1=mysqli_query($connect,"select * from vt_voter where division='$division' && city='$city' && vote_st=0");
										$i=0;
										while($r1=mysqli_fetch_array($q1))
										{
										$i++;
										$yr=date("Y");
										$dd=explode("-",$r1['dob']);
										$age=$yr-$dd[2];
										?>
                                            <tr>
                                                <td><?php echo $i; ?></td>
                                                <td><?php echo $r1['name']; ?></td>
                                                <td><?php echo $r1['gender']; ?></td>
                                                <td><?php echo $age; ?></td>
                                                <td><?php echo $r1['aadhar']; ?></td>
                                            </tr>
											<?php
											}
											?>
										</tbody>
									</table>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Vote Registered</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                   <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th>S No.</th>
                                                <th>Name</th>
                                                <th>Gender</th>
                                                <th>Age</th>
                                                <th>Aadhar</th>
                                            </tr>
                                        </thead>
                                        <tbody>
										<?php
										$q2=mysqli_query($connect,"select * from vt_voter where division='$division' && city='$city' && vote_st=1");
										$i=0;
										while($r2=mysqli_fetch_array($q2))
										{
										$i++;
										$yr2=date("Y");
										$dd2=explode("-",$r2['dob']);
										$age2=$yr2-$dd2[2];
										?>
                                            <tr>
                                                <td><?php echo $i; ?></td>
                                                <td><?php 
												echo '<img src="upload/v'.$r2['id'].'.jpg" width="100" height="100"><br>';
												echo $r2['name']; ?></td>
                                                <td><?php echo $r2['gender']; ?></td>
                                                <td><?php echo $age2; ?></td>
                                                <td><?php echo $r2['aadhar']; ?></td>
                                            </tr>
											<?php
											}
											?>
										</tbody>
									</table>
                                </div>
                            </div>
                        </div>
                    </div>
				
		
		<script language="javascript">
	setTimeout(function () {
   //Redirect with JavaScript
 window.location.href="booth_home.php";
  
}, 15000);
	</script>
                 
                      
                <!-- /. ROW  -->
			
		
				<footer><p>All right reserved. Voting System <a href="http://webthemez.com"></a></p>
				
        
				</footer>
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
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

      
    <!-- Chart Js -->
    <script type="text/javascript" src="assets/js/Chart.min.js"></script>  
    <script type="text/javascript" src="assets/js/chartjs.js"></script> 

</body>

</html>