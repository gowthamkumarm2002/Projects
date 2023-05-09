<?php
include("dbconnect.php");
extract($_REQUEST);
?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Voting</title>
<style type="text/css">
<!--
body
{
font-family:Arial, Helvetica, sans-serif;
font-size:12px;
}
.bor {
	border-bottom-width: 3px;
	border-bottom-style: solid;
	border-bottom-color: #FF0000;
}
.bor2 {
background-color:#D5F7FF;
font-weight:bold;
	
}
-->
</style>
</head>

<body>
<h3 align="center">Voting Information </h3>
<?php
$q1=mysqli_query($connect,"select * from vt_blockchain where block_id=$id order by id desc");
while($r1=mysqli_fetch_array($q1))
{
?>
<table width="90%" border="0" align="center" cellpadding="5" cellspacing="0">
  <tr>
    <td width="98" class="bor2">Block ID </td>
    <td width="783" class="bor2">: <?php echo $r1['id']; ?> </td>
  </tr>
  <tr>
    <td><strong>Block Data </strong></td>
    <td>: <?php echo $r1['sdata']; ?></td>
  </tr>
  <tr>
    <td colspan="2" class="bor">&nbsp;</td>
  </tr>
</table>
<?php
}
?>
</body>
</html>
