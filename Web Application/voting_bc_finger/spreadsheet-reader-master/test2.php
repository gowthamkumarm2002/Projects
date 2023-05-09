<?php
/**
 * XLS parsing uses php-excel-reader from http://code.google.com/p/php-excel-reader/
 */
	header('Content-Type: text/html');

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
					if($k==0)
					{
					echo "<tr>";
						for($i=0;$i<40;$i++)//count($Row)
						{
						echo "<td>".$Row[$i]."</td>";
						}
						echo "</tr>";
					}
					else
					{
					//print_r($Row);
					echo "<tr>";
					for($i=0;$i<40;$i++)//count($Row)
					{
						if($i==0)
						{
							$dd=explode("##",$Row[0]);
							echo "<td>".$dd[1]."</td>";
							
						}
						else if($i==1)
						{
						$dd=explode("##",$Row[1]);
							echo "<td>".$dd[1]."</td>";
						}
						else
						{
					
					echo "<td>".$Row[$i]."</td>";
						}
					}
					echo "</tr>";
					}
				}
				$k++;
				
			}
			echo "</table>";
			
		}
		
	}
	catch (Exception $E)
	{
		echo $E -> getMessage();
	}
?>
