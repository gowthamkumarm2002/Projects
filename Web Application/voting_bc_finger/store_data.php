<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
mysqli_query($connect,"delete from vt_division");
if (isset($argv[1]))
	{
		$Filepath = $argv[1];
	}
	elseif (isset($_GET['File']))
	{
		$Filepath = $_GET['File'];
	}
	else
	{
		if (php_sapi_name() == 'cli')
		{
			echo 'Please specify filename as the first argument'.PHP_EOL;
		}
		else
		{
			echo 'Please specify filename as a HTTP GET parameter "File", e.g., "/test.php?File=test.xlsx"';
		}
		exit;
	}

	// Excel reader from http://code.google.com/p/php-excel-reader/
	require('spreadsheet-reader-master/php-excel-reader/excel_reader2.php');
	require('spreadsheet-reader-master/SpreadsheetReader.php');

	date_default_timezone_set('UTC');

	$StartMem = memory_get_usage();
	//echo '---------------------------------'.PHP_EOL;
	//echo 'Starting memory: '.$StartMem.PHP_EOL;
	//echo '---------------------------------'.PHP_EOL;

	try
	{
		$Spreadsheet = new SpreadsheetReader($Filepath);
		$BaseMem = memory_get_usage();

		$Sheets = $Spreadsheet -> Sheets();

		//echo '---------------------------------'.PHP_EOL;
		//echo 'Spreadsheets:'.PHP_EOL;
		//print_r($Sheets);
		//echo '---------------------------------'.PHP_EOL;
		//echo '---------------------------------'.PHP_EOL;

		//foreach ($Sheets as $Index => $Name)
		//{
			//echo '---------------------------------'.PHP_EOL;
			//echo '*** Sheet '.$Name.' ***'.PHP_EOL;
			//echo '---------------------------------'.PHP_EOL;

			$Time = microtime(true);
			$k=0;
			$Spreadsheet -> ChangeSheet($Index);
			$sum1=0;
			$sum2=0;
			$sum3=0;
			$sum4=0;
			$sum5=0;
			$sum6=0;
			$district[0]="";
			$year[0]="";
			
			foreach ($Spreadsheet as $Key => $Row)
			{
				//echo $Key.': ';
				
				if ($Row)
				{
				
								$mq = mysqli_query($connect,"select max(id) as maxid from vt_division");
        $mr = mysqli_fetch_array($mq);
        $id = $mr['maxid']+1;
		
										
						
					$q1="insert into vt_division(id,district,division) values($id,'$Row[0]','$Row[1]')";
					mysqli_query($connect,$q1);
								
					
				}//Row
			
			}//for
			
			
		//}
		
		
		
		///////////////////////
		
		
	}
	catch (Exception $E)
	{
		//echo $E -> getMessage();
	}
?>
<script language="javascript">
//alert("Uploaded Successfully");
window.location.href="add_candidate.php";
</script>
<?php