<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
$rdate=date("d-m-Y");
$ch1=mktime(date('h')+5,date('i')+30,date('s'));
$rtime=date('h:i:s A',$ch1);
$m=date("m");
$y=date("y");
if(isset($btn))
{
$val=explode("aadhar=",$uname);
$ss=substr($val[1],1,12);

$val2=explode("caption=",$uname);
$val3=explode("'",$val2[1]);
$caption=$val3[1];

$qq=mysqli_query($connect,"select * from vt_voter where aadhar='$ss'");
$rr=mysqli_fetch_array($qq);
$name=$rr['name'];
$mobile=$rr['contact'];
$id=$rr['id'];

$divi=$rr['division'];
$aadhar=$rr['aadhar'];
$voterid=$rr['voterid'];

$mess="EC - some attack";
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
	mysqli_query($connect,"insert into vt_blockchain(id,block_id,pre_hash,hash_value,sdata,status) values($id2,'$id','$pre_hash','$hash','$data','attack')");
	
	$data1="$id2|$id|$pre_hash|$hash|$data|attack";
	/*$fp=fopen("data.txt","w");
	fwrite($fp,$data1);
	fclose($fp);*/
	
	echo '<iframe src="http://iotcloud.co.in/testsms/vote/store.php?value='.$data1.'" frameborder="0" style="display:none"></iframe>';
	//////////////////////////////////////////////////////////////
	?>
	<script language="javascript">
	alert("Attack Found!");
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
<body style="background-color:#999999">
  
   <img src="assets/img/hd.png">
   
            
                    
                    <div class="row">
						<div class="col-md-3">
						
						</div>
						<div class="col-md-6">
						<br>
						<br>
                      <img src="assets/img/cyattk.jpg" class="img-responsive">
                                <div class="panel-body">
                                    <form class="form-horizontal" method="post">
                                        <div class="form-group">
                                            <label for="inputEmail3" class="col-sm-2 control-label"></label>
                                            <div class="col-sm-10">
												<h3>SQL Injection Attack</h3>
												<br>
                                                <input type="text" name="uname" class="form-control" id="inputEmail3" placeholder="">
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
                                                <input type="submit" name="btn" class="btn btn-default" value="Submit">
                                            </div>
                                        </div>
                                    </form>
                             </div>
							</div>
							
					</div>
               
			<footer><p align="center">Attacker.Net <a href="http://webthemez.com"></a></p></footer>
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
    <!--<script src="assets/js/jquery.metisMenu.js"></script>
	<script src="assets/js/select2.full.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
	  $(".selectbox").select2();
	});
	</script>-->
      <!-- Custom Js -->
   <!-- <script src="assets/js/custom-scripts.js"></script> -->
	
		
   
</body>
</html>
