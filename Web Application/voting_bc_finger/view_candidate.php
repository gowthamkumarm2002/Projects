<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);


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
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <?php include("include/link_officer1.php"); ?>
            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		    <div class="header"> 
                <h1 class="page-header">Candidate Information <small></small></h1>
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
                                Candidate Information  
                            </div>
						    <div class="panel-body">
                                <form class="form-horizontal" method="post">
                                    <div class="form-group">
                                        <label for="inputEmail3" class="col-sm-2 control-label">Division</label>
                                        <div class="col-sm-10">
                                            <select name="division" class="form-control">
                                                <?php
                                                $dq=mysqli_query($connect,"select * from vt_division");
                                                while($dr=mysqli_fetch_array($dq))
                                                {
                                                ?>
                                                <option value="<?php echo $dr['division']; ?>" <?php if($division==$dr['division']) echo "selected"; ?>><?php echo $dr['division'].", ".$dr['district']; ?></option>
                                                <?php
                                                }
                                                ?>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default">Submit</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
						
                        <div class="panel-body">
                            <div class="table-responsive">
						        <div class="row">	
                                    <?php
                                    $i=0;
                                    $qry=mysqli_query($connect,"select * from vt_candidate where division='$division'");
                                    while($row=mysqli_fetch_array($qry))
                                    {
                                    $i++;
                                    ?>
                                    <div class="col-md-4 col-sm-4">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading">
                                            <?php echo "Caption: ".$row['caption']; ?>
                                            </div>
                                            <div class="panel-body">
                                                <div align="center"><?php echo '<img src="symbol/'.$row['symbol'].'" width="80" height="80">'; ?></div>
                                            </div>
                                            <div class="panel-footer">
                                            <?php echo "Name: ".$row['name']; ?>
                                            </div>
                                            <div class="panel-footer">
                                            <?php echo "Age: ".$row['age']; ?>
                                            </div>
                                            <div class="panel-footer">
                                            <?php echo "Gender: ".$row['gender']; ?>
                                            </div>
                                            <div class="panel-footer">
                                            <?php echo "Contact No.: ".$row['contact']; ?>
                                            </div>
                                        </div>
                                    </div>
                                    <?php
                                    }
                                    ?>					
                                </div><!-- row -->      
                            </div>
                                                        
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
                <!-- /. ROW  -->
			<footer><p align="center">All right reserved. Voting System <a href="http://webthemez.com"></a></p></footer>
        </div>
             <!-- /. PAGE INNER  -->
    </div>
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
