<?php
include("../include/dbconnect.php");
/**
 * XLS parsing uses php-excel-reader from http://code.google.com/p/php-excel-reader/
 */
	header('Content-Type: text/html');
?>

<?php
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
	require('php-excel-reader/excel_reader2.php');
	require('SpreadsheetReader.php');

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
$a1=array();
			
			$k=0;
				$y=0;
		foreach ($Sheets as $Index => $Name)
		{
			//echo '---------------------------------'.PHP_EOL;
			//echo '*** Sheet '.$Name.' ***'.PHP_EOL;
			//echo '---------------------------------'.PHP_EOL;

			$Time = microtime(true);

			$Spreadsheet -> ChangeSheet($Index);
			echo "<table border=1>";
			
			foreach ($Spreadsheet as $Key => $Row)
			{
				//echo $Key.': ';
				
				if ($Row)
				{
				
						
						
					$cn=count($Row);
						for($x=0;$x<$cn;$x++)
						{
							if($x>1 && $x<8)
							{
								if($Row[2]>=1)
								{
								$st="1";
								}
								else
								{
								$st="0";
								}
								if($Row[4]>=1)
								{
								$st1="1";
								}
								else
								{
								$st1="0";
								}
								if($Row[5]>=1)
								{
								$st2="1";
								}
								else
								{
								$st2="0";
								}
							}
						}
					///////////////////
					if($k==0)
					{
					echo "<tr>";
					for($i=0;$i<count($Row);$i++)
					{
					
						if($i>1 && $i<8)
						{
							
							
							
						echo "<td>";
					echo $Row[$i]."</td>";
						}
					}
					echo "</tr>";
					}
					/////////
					if($st=="1" && $st1=="1" && $st2=="1")
						{	
					//print_r($Row);
					echo "<tr>";
					
					
					for($i=0;$i<count($Row);$i++)
					{
						if($i>1 && $i<8)
						{
						$a1[$i]+=$Row[$i];
					echo "<td>";
					
					echo $Row[$i]."</td>";
						}
						
					}
					echo "</tr>";
					
					$y++;
					}//if
					$k++;
				}
				
			
			}
			echo "</table>";
			
		}
		//echo $y." ";
			//print_r($a1);
			//echo $a1[2];
			//echo "$a1[2]/$y";
			$d1=$a1[2]/$y;
			//echo $d1;
			$d2=($a1[3]/$y);
			$d3=($a1[4]/$y);
			$d4=($a1[5]/$y);
			$d5=($a1[6]/$y);
			$d6=($a1[7]/$y);
			mysql_query("update analysis set d1='$d1',d2='$d2',d3='$d3',d4='$d4',d5='$d5',d6='$d6' where id=1");
		
	}
	catch (Exception $E)
	{
		echo $E -> getMessage();
	}
?>
