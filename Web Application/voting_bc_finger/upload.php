<?php

// new filename
//$filename = 'pic_'.date('YmdHis') . '.jpeg';
session_start();
$booth=$_SESSION['booth'];

include("include/dbconnect.php");
$q1=mysqli_query($connect,"select * from vt_booth where uname='$booth'");
$r1=mysqli_fetch_array($q1);

$id=$r1['voterid'];
$filename = 'v'.$id.'.jpg';

$url = '';
if( move_uploaded_file($_FILES['webcam']['tmp_name'],'upload/'.$filename) ){
	$url = 'http://' . $_SERVER['HTTP_HOST'] . dirname($_SERVER['REQUEST_URI']) . '/upload/' . $filename;
}

// Return image url
echo $url;