<?php
session_start();
include("include/dbconnect.php");
extract($_POST);
$id=$_REQUEST['id'];
$msg="";
$get_qry=mysqli_query($connect,"select * from vt_voter where id=$id");
$get_row=mysqli_fetch_array($get_qry);

$s_img=$get_row['src_img1'];
$d_img=$get_row['dest_img1'];
//$userid=$get_row['secret_key'];

$_SESSION['s_img']=$s_img;
$_SESSION['d_img']=$d_img;
header("location:color_match.php?id=".$id);

?>