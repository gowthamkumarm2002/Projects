<?php
include("include/protect.php");
include("include/dbconnect.php");
extract($_REQUEST);
$rdate=date("d-m-Y");
if(isset($btn))
{
$mq=mysqli_query($connect,"select max(id) from vt_division");
$mr=mysqli_fetch_array($mq);
$id=$mr['max(id)']+1;
$qry=mysqli_query($connect,"insert into vt_division(id,district,division) values($id,'$district','$division2')");
	if($qry)
	{
	?>
	<script language="javascript">
	window.location.href="add_candidate.php?act=success";
	</script>
	<?php
	}
	else
	{
	?>
	<script language="javascript">
	window.location.href="add_candidate.php?act=wrong";
	</script>
	<?php
	}

}
if(isset($btn2))
{
$mq=mysqli_query($connect,"select max(id) from vt_candidate");
$mr=mysqli_fetch_array($mq);
$id=$mr['max(id)']+1;
$symbol="S".$id.$_FILES['file']['name'];
$qry=mysqli_query($connect,"insert into vt_candidate(id,division,name,caption,symbol,gender,age,contact,rdate) values($id,'$division','$name','$caption','$symbol','$gender','$age','$contact','$rdate')");
if($qry)
{
move_uploaded_file($_FILES['file']['tmp_name'],"symbol/".$symbol);
?>
	<script language="javascript">
	window.location.href="add_candidate.php?act1=success";
	</script>
	<?php
}
else
{
?>
	<script language="javascript">
	window.location.href="add_candidate.php?act1=wrong";
	</script>
	<?php
}

}
///////
if(isset($btn3))
{
$fname="dataset.xlsx";
move_uploaded_file($_FILES['file']['tmp_name'],"spreadsheet-reader-master/upload/".$fname);
?>
<script language="javascript">
window.location.href="store_data.php?File=spreadsheet-reader-master/upload/<?php echo $fname; ?>";
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
                    <li><a href="index.php">Home</a></li>
                </ol> 				
		    </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="card-title">
                                <div class="title">Upload Data</div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" name="form3" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Division Data</label>
                                    <div class="col-sm-10">
                                        <input type="file" class="form-control" name="file">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" name="btn3" class="btn btn-default" value="Upload">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
					
            <div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="card-title">
                                <div class="title">Add Division</div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" name="form1" method="post">
                                <?php
                                if($act=="success")
                                {
                                ?>
                                <div class="alert-success">Added Success..</div>
                                <?php
                                }
                                if($act=="wrong")
                                {
                                ?>
                                <div class="alert-danger">Already Exist!</div>
                                <?php
                                }
                                ?>
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">District</label>
                                    <div class="col-sm-10">
                                        <select name="district" class="form-control">
                                            <option value="">-District-</option>
                                            <option>Ariyalur</option>
                                            <option>Chengalpattu</option>
                                            <option>Chennai</option>
                                            <option>Coimbatore</option>
                                            <option>Cuddalore</option>
                                            <option>Dharmapuri</option>
                                            <option>Dindigul</option>
                                            <option>Erode</option>
                                            <option>Kallakurichi</option>
                                            <option>Kanchipuram</option>
                                            <option>Kanyakumari</option>	
                                            <option>Karur</option>
                                            <option>Krishnagiri</option>
                                            <option>Madurai</option>
                                            <option>Mayiladuthurai</option>
                                            <option>Nagapattinam</option>
                                            <option>Namakkal</option>
                                            <option>Nilgiris</option>
                                            <option>Perambalur</option>
                                            <option>Pudukkottai</option>
                                            <option>Ramanathapuram</option>
                                            <option>Ranipet</option>
                                            <option>Salem</option>
                                            <option>Sivagangai</option>
                                            <option>Tenkasi</option>
                                            <option>Thanjavur</option>
                                            <option>Theni</option>
                                            <option>Thoothukudi</option>
                                            <option>Tiruchirappalli</option>
                                            <option>Tirunelveli</option>
                                            <option>Tirupattur</option>
                                            <option>Tiruppur</option>
                                            <option>Tiruvallur</option>
                                            <option>Tiruvannamalai</option>
                                            <option>Tiruvarur</option>
                                            <option>Vellore</option>
                                            <option>Viluppuram</option>
                                            <option>Virudhunagar</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Division</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="division2" placeholder="">
                                    </div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" name="btn" class="btn btn-default" value="Add Division">
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
					
			<div class="row">
                <div class="col-xs-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="card-title">
                                <div class="title">Add New Candidate</div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <form class="form-horizontal" name="form2" method="post" enctype="multipart/form-data">
                                <?php
                                if($act1=="success")
                                {
                                ?>
                                <div class="alert-success">Added Success..</div>
                                <?php
                                }
                                if($act1=="wrong")
                                {
                                ?>
                                <div class="alert-danger">Already Exist!</div>
                                <?php
                                }
                                ?>
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">District</label>
                                    <div class="col-sm-10">
                                        <select name="district" class="form-control" onChange="this.form.submit()">
                                        <option value="">-District-</option>
                                        <?php
                                        $dq=mysqli_query($connect,"select distinct(district) from vt_division order by district");
                                        while($dr=mysqli_fetch_array($dq))
                                        {
                                        ?>
                                        <option <?php if($dr['district']==$district) echo "selected"; ?>><?php echo $dr['district']; ?></option>
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
                                        $dq2=mysqli_query($connect,"select * from vt_division where district='$district'");
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
                                    <label for="inputEmail3" class="col-sm-2 control-label">Candidate Name</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="name" placeholder="">
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
                                    <label for="inputEmail3" class="col-sm-2 control-label">Age</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="age" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Contact No.</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" name="contact" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Commitee</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="caption" class="form-control" placeholder="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputEmail3" class="col-sm-2 control-label">Symbol</label>
                                    <div class="col-sm-10">
                                        <input type="file" name="file" class="form-control" placeholder="">
                                    </div>
                                </div>
                                
                                
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <input type="submit" name="btn2" class="btn btn-default" value="Add">
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
