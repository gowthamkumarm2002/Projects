<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
//$rdate=date("d-m-Y");
$uname=$_SESSION['uname'];

$aq1=mysqli_query($connect,"select * from vt_admin where username='admin'");
				$ar1=mysqli_fetch_array($aq1);
				$est=$ar1['election_st'];

if($est=="2")
				{
					$q3=mysqli_query($connect,"select * from vt_division");
					$k=0;
					$per_sum=0;
					while($r3=mysqli_fetch_array($q3))
					{
					$rn1=rand(20,100);
							
							$av1=$r3['vcount']+$rn1;
							$av2=$r3['vcount2'];
								if($av1<$av2)
								{
					mysqli_query($connect,"update vt_division set vcount=vcount+$rn1 where id=".$r3['id']."");
								}
							$q4=mysqli_query($connect,"select * from vt_division where id=".$r3['id']."");
							$r4=mysqli_fetch_array($q4);
							$vc=$r4['vcount'];
							$vc2=$r4['vcount2'];
							$per=($vc/$vc2)*100;
							$per1=floor($per);
							$per_sum+=$per1;
							$k++;
							mysqli_query($connect,"update vt_division set percent=$per1 where id=".$r3['id']."");
							
					}
					$all_per=$per_sum/$k;
				}
?>
<script language="javascript">
	setTimeout(function () {
   //Redirect with JavaScript
 window.location.href="vote_process.php";
  
}, 10000);
	</script>