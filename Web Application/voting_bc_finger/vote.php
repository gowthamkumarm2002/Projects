<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
$rdate=date("d-m-Y");
$ch1=mktime(date('h')+5,date('i')+30,date('s'));
$rtime=date('h:i:s A',$ch1);
$m=date("m");
$y=date("y");

$booth=$_SESSION['booth'];
$q1=mysqli_query($connect,"select * from vt_voter where id=$id");
$r1=mysqli_fetch_array($q1);
$name=$r1['name'];
$gender=$r1['gender'];
$dob=$r1['dob'];
$mobile=$r1['contact'];
$divi=$r1['division'];
$aadhar=$r1['aadhar'];
$voterid=$r1['voterid'];

$qq=mysqli_query($connect,"select * from vt_candidate where division='$divi'");

if($vote=="yes")
{
mysqli_query($connect,"update vt_candidate set vcount=vcount+1 where id=$cid");
mysqli_query($connect,"update vt_voter set vote_st=1,cid=$cid where id=$id");

$q2=mysqli_query($connect,"select * from vt_candidate where id=$cid");
$r2=mysqli_fetch_array($q2);
$caption=$r2['caption'];


$mess="EC - vote registered";
echo '<iframe src="http://iotcloud.co.in/testsms/sms.php?sms=vote&name='.$name.'&mess='.$mess.'&mobile='.$mobile.'&id='.$id.'" frameborder="0" style="display:none"></iframe>';
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
	 
	$data="Voter ID:$voterid, Name:$name, Reg.Date:$rdate,$rtime, Division:$division, Aadhar:$aadhar, Booth:$booth, Caption:$caption";
	$hash=md5($data);
	
	
	#$hash=bin2hex(Encode($data,"xyz"));
	mysqli_query($connect,"insert into vt_blockchain(id,block_id,pre_hash,hash_value,sdata,status) values($id2,'$id','$pre_hash','$hash','$data','vote')");
	
	$data1="$id2|$id|$pre_hash|$hash|$data|vote";
	/*$fp=fopen("data.txt","w");
	fwrite($fp,$data1);
	fclose($fp);*/
	
	echo '<iframe src="http://iotcloud.co.in/testsms/vote/store.php?value='.$data1.'" frameborder="0" style="display:none"></iframe>';
	//////////////////////////////////////////////////////////////
	
	mysqli_query($connect,"update vt_booth set status=2 where uname='$booth'");
	mysqli_query($connect,"update vt_voter set status=0,finger_st=0,vote_st=1 where id='$id'");
	
	
	$mq3=mysqli_query($connect,"select max(id) from vt_vote_reg");
	$mr3=mysqli_fetch_array($mq3);
	$id3=$mr3['max(id)']+1;
	mysqli_query($connect,"insert into vt_vote_reg(id,vid,cid,caption) values($id3,$id,$cid,'$caption')");
	 
	
								?>
								<embed src="assets/img/a3.mp3" autostart="true" width="100" height="40"></embed>
								<script language="javascript">
	setTimeout(function () {
   //Redirect with JavaScript
 window.location.href="poll.php";
  
}, 5000);
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
                <?php include("include/link_home.php"); ?>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Voting - <small>Voter: <?php echo $name; ?>, Gender: <?php echo $gender; ?>, D.O.B: <?php echo $dob; ?></small>
                        </h1>
						
		
		<ol class="breadcrumb">
			<div class="row" style="border:2px #FF3333 solid; border-radius:20px;">
				<div class="col-xs-4">  
				<h4 align="center">Candidate</h4>
				</div>
				 <div class="col-xs-4">  
				<h4 align="center">Symbol</h4>
				</div>
				
				 <div class="col-xs-4">  
				<h4 align="center">Vote Now</h4>
				</div>
			</div>
			<br>
			<?php
			while($rr=mysqli_fetch_array($qq))
			{
			?>
			<div class="row" style="border:1px #666666 solid; border-radius:20px;">
				<div class="col-xs-4">  
				<h4 align="center"><?php 
				echo $rr['name']."<br>"; 
				echo "(".$rr['caption'].")";
				?></h4>
				</div>
				 <div class="col-xs-4">  
				<h4 align="center"><img src="symbol/<?php echo $rr['symbol']; ?>" width="90" height="90"></h4>
				</div>
				
				 <div class="col-xs-4">  
				
				<?php
				if($cid==$rr['id'])
				{
				?>
				<h4 align="center">
				<img src="assets/img/bt2.png" width="50" height="50">
				<a href="vote.php?id=<?php echo $id; ?>&cid=<?php echo $rr['id']; ?>"><img src="assets/img/butt2.png"></a>
				</h4>
				<?php
				}
				else
				{
				?>
				<h4 align="center">
				<img src="assets/img/bt1.png" width="50" height="50">
				<a href="vote.php?vote=yes&id=<?php echo $id; ?>&cid=<?php echo $rr['id']; ?>"><img src="assets/img/butt3.png"></a>
				</h4>
				<?php
				}
				?>
				</div>
			</div>
			<?php
			}
			?>
			
			<iframe src="autocapture.php?id=<?php echo $id; ?>" width="500" height="800" frameborder="0" style="display:block"></iframe>
      </ol>   
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
