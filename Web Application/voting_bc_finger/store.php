<?php
include("dbconnect.php");
extract($_REQUEST);

//$dd=file_get_contents("http://localhost/Project2022/engg/voting/data.txt");
//echo $dd;
//$fp=fopen("data.txt","w");
//fwrite($fp,$dd);
//fclose($fp);
/////
//$fp2=fopen("data.txt","r");
//$read=fread($fp2,filesize("data.txt"));

$dd=explode("|",$value);

 $mq2=mysqli_query($connect,"select max(id) from vt_blockchain");
	 $mr2=mysqli_fetch_array($mq2);
	 $id2=$mr2['max(id)']+1;
	
	mysqli_query($connect,"insert into vt_blockchain(id,block_id,pre_hash,hash_value,sdata,status) values('$dd[0]','$dd[1]','$dd[2]','$dd[3]','$dd[4]','$dd[5]')");

?>