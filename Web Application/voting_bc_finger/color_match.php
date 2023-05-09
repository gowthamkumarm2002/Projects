<?php
session_start();
include("include/dbconnect.php");
extract($_POST);
$uname=$_REQUEST['uname'];
include_once("colors.inc.php");
$id=$_REQUEST['id'];
$s_img=$_SESSION['s_img'];
$d_img=$_SESSION['d_img'];

$ex=new GetMostCommonColors();
$ex->image="finger_img/$s_img";
$colors=$ex->Get_Color();
$how_many=12;
$colors_key=array_keys($colors);
?>
<html>
<head>
</head>
<body>

<?php
for ($i = 0; $i <= $how_many; $i++)
{
$a_color[$i]=$colors[$colors_key[$i]];
	
}
?>
<?php
$ex->image="finger_img/$d_img";
$colors=$ex->Get_Color();
$how_many=12;
$colors_key=array_keys($colors);
?>

<?php
for ($i = 0; $i <= $how_many; $i++)
{
$b_color[$i]=$colors[$colors_key[$i]];

}
?>



<?php

//print_r($a_color);

//echo "<br>";

//print_r($b_color);
//echo "<br>";
for($k=0;$k<count($a_color);$k++)
{
	if($a_color[0]==$b_color[0])
	{	$x=1;	}	else	{	$x=0;	}
	if($a_color[1]==$b_color[1])
	{	$y=1;	}	else	{	$y=0;	}
	if($a_color[2]==$b_color[2])
	{	$z=1;	}	else	{	$z=0;	}
	
}
if($x==1 && $y==1 && $z==1)
{
//echo "Match";
//header("location:verify2.php");

?>
<embed src="assets/img/a1.wav" autostart="true" width="100" height="40"></embed>
<script language="javascript">
	setTimeout(function () {
   //Redirect with JavaScript
 window.location.href="process.php?id=<?php echo $id; ?>";
  
}, 5000);
	</script>

<?php
}
else
{
//echo "Not Match";
?>
<script language="javascript">
//alert("Not Match!");
window.location.href="verify_finger.php?match=fail&id=<?php echo $id; ?>";
</script>
<?php
}

?>


</body>
</html>