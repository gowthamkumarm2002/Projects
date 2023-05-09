<?php
session_start();
include("include/dbconnect.php");
extract($_REQUEST);
//$rdate=date("d-m-Y");

?>
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
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css"> 
	
	<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
	
</head>

<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href=""><strong> <?php include("include/title1.php"); ?></strong></a>
				
        </nav>
        <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <?php include("include/link_home.php"); ?>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
		<div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Election Result <small></small>
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="index.php">Home</a></li>
					
					</ol> 
									
		</div>
            <div id="page-inner">

                <!-- /. ROW  -->
		<?php
		$tcnt=0;
	$aq1=mysqli_query($connect,"select * from vt_admin where username='admin'");
			$ar1=mysqli_fetch_array($aq1);
			$est=$ar1['election_st'];
			if($est=="3")
			{
				
					$q2=mysqli_query($connect,"select distinct(caption) from vt_candidate");
						while($r2=mysqli_fetch_array($q2))
						{
						$cap[]=$r2['caption'];
						}
					$q3=mysqli_query($connect,"select * from vt_division order by id");
					$tot=mysqli_num_rows($q3);
						$acnt=array();
						while($r3=mysqli_fetch_array($q3))
						{
							if($page=="3")
							{
								$tcnt+=$r3['vcount2'];
								$det=$r3['detail'];
								$d1=explode(",",$det);
									$i=0;
									foreach($d1 as $d11)
									{
									$d2=explode("-",$d11);
									$acnt[$i]+=$d2[1];
									
									$i++;
									}
							}
							else if($page=="2")
							{
								$tcnt+=$r3['vcount2'];
								$det=$r3['detail2'];
								$d1=explode(",",$det);
									$i=0;
									foreach($d1 as $d11)
									{
									$d2=explode("-",$d11);
									$acnt[$i]+=$d2[1];
									
									$i++;
									}
							}
							else
							{	
								$tcnt+=$r3['vcount2'];
								$det=$r3['detail1'];
								$d1=explode(",",$det);
									$i=0;
									foreach($d1 as $d11)
									{
									$d2=explode("-",$d11);
									$acnt[$i]+=$d2[1];
									
									$i++;
									}
							}
						}
			//print_r($cap);
			//print_r($acnt);
			///////
			mysqli_query($connect,"delete from vt_temp");
			for($j=0;$j<count($cap);$j++)
			{
			$mq=mysqli_query($connect,"select max(id) from vt_temp");
			$mr=mysqli_fetch_array($mq);
			$id=$mr['max(id)']+1;
					if($page=="3")
					{
					$qq1=mysqli_query($connect,"select * from vt_division where caption='$cap[$j]'");
					$seats=mysqli_num_rows($qq1);
					}
					else if($page=="2")
					{
					$qq1=mysqli_query($connect,"select * from vt_division where caption2='$cap[$j]'");
					$seats=mysqli_num_rows($qq1);
					}
					else
					{
					$qq1=mysqli_query($connect,"select * from vt_division where caption1='$cap[$j]'");
					$seats=mysqli_num_rows($qq1);
					}
			
			$qry=mysqli_query($connect,"insert into vt_temp(id,caption,vcount,seats) values($id,'$cap[$j]','$acnt[$j]','$seats')");
			}
			////////
			$q4=mysqli_query($connect,"select * from vt_temp order by seats desc");
				while($r4=mysqli_fetch_array($q4))
				{
				$st[]=$r4['seats'];
				$cap1[]=$r4['caption'];
				$vcount[]=$r4['vcount'];
				
				$vnt=$r4['vcount'];
				$tt=($r4['seats']/$tot)*100;
				$tper[]=floor($tt);
				}
		
			
		?>
	
                <div class="row">
					<?php
					for($j=0;$j<4;$j++)
					{
					?>
                    <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							
								<h3><?php echo $st[$j]; ?></h3>
								<h4>Votes: <?php echo $vcount[$j]; ?></h4>
								<h3><?php echo $cap1[$j]; ?></h3>
							 
						</div>
						<div class="icon">
							<?php
							$q5=mysqli_query($connect,"select * from vt_candidate where caption='$cap1[$j]'");
							$r5=mysqli_fetch_array($q5);
							?>
							<img src="symbol/<?php echo $r5['symbol']; ?>" width="80" height="80">
						   <!--<i class="fa fa-eye fa-5x red"></i>-->
						</div>
		 
                        </div>
						</div>
                    </div>
					<?php
					}
					?>
					<!-- <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>32,850</h3>
								<small>Caption2</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-shopping-cart fa-5x blue"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>56,150</h3>
								<small>Caption3</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-comments fa-5x green"></i>
						</div>
		 
                        </div>
						</div>
                    </div>
					
					       <div class="col-md-3 col-sm-12 col-xs-12">
					<div class="board">
                        <div class="panel panel-primary">
						<div class="number">
							<h3>
								<h3>89,645</h3>
								<small>Caption4</small>
							</h3> 
						</div>
						<div class="icon">
						   <i class="fa fa-user fa-5x yellow"></i>
						</div>
		 
                        </div>
						</div>
                    </div>-->
				   
                </div>
				
				<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4><?php echo $cap1[0]; ?></h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="<?php echo $tper[0]; ?>" ><span class="percent"><?php echo $tper[0]; ?>%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4><?php echo $cap1[1]; ?></h4>
						<div class="easypiechart" id="easypiechart-orange" data-percent="<?php echo $tper[1]; ?>" ><span class="percent"><?php echo $tper[1]; ?>%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4><?php echo $cap1[2]; ?></h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="<?php echo $tper[2]; ?>" ><span class="percent"><?php echo $tper[2]; ?>%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4><?php echo $cap1[3]; ?></h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="<?php echo $tper[3]; ?>" ><span class="percent"><?php echo $tper[3]; ?>%</span>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
		
		
				     <div class="row">
                        <div class="col-sm-6 col-xs-12">  
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Top Ranking</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="line-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xs-12">
                            <div class="panel panel-default chartJs">
                                <div class="panel-heading">
                                    <div class="card-title">
                                        <div class="title">Majority Places</div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <canvas id="bar-chart" class="chart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
				
				 <div class="row">
                    <div class="col-md-4 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                               Leading Place
                            </div>
                            <div class="panel-body">
                                <div class="list-group">
									<?php
									$q6=mysqli_query($connect,"select * from vt_temp order by seats desc");
									while($r6=mysqli_fetch_array($q6))
									{
									$qq31=mysqli_query($connect,"select * from vt_candidate where caption='".$r6['caption']."'");	
												$rr31=mysqli_fetch_array($qq31);
									?>
									 <a href="#" class="list-group-item">
                                        <span class="badge"><?php echo $r6['seats']; ?></span>
                                       <?php 
									    echo '<img src="symbol/'.$rr31['symbol'].'" width="40" height="40">';
										echo $r6['caption']; 
									   ?>
									   
                                    </a>
									<?php
									}
									?>
                                    
                                </div>
                                <div class="text-right">
                                    
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-8 col-sm-12 col-xs-12">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Division
                            </div> 
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                        <thead>
                                            <tr>
                                                <th>S No.</th>
												<th>District</th>
                                                <th>Division</th>
												<th>Symbol</th>
                                                <th>Committee</th>
                                                <th>Candidate</th>
                                               
                                            </tr>
                                        </thead>
                                        <tbody>
											<?php
											$i=0;
											$qq2=mysqli_query($connect,"select * from vt_division order by district");
											while($rr2=mysqli_fetch_array($qq2))
											{
											$i++;
												$qq3=mysqli_query($connect,"select * from vt_candidate where caption='".$rr2['caption']."'");	
												$rr3=mysqli_fetch_array($qq3);
											?>
                                            <tr>
                                                <td><?php echo $i; ?></td>
												<td><?php echo $rr2['district']; ?></td>
                                                <td><?php echo $rr2['division']; ?></td>
												<td><?php echo '<img src="symbol/'.$rr3['symbol'].'" width="40" height="40">'; ?></td>
                                                <td><?php echo $rr3['caption']; ?></td>
                                                <td><?php echo $rr3['name']; ?></td>
                                                
                                            </tr>
                                            <?php
											}
											?>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                      </div>
				</div>
				</div>
				<!-- /. ROW  -->
				
				
				
				<div class="row" style="visibility:hidden;">
				<div class="col-md-5">
						<div class="panel panel-default">
						<div class="panel-heading">
							Line Chart
						</div> 
						<div class="panel-body">
							<div id="morris-line-chart"></div>
						</div>						
					</div>   
					</div>		
					
						<div class="col-md-7">
					<div class="panel panel-default">
					<div class="panel-heading">
                                Bar Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-bar-chart"></div>
                            </div>
						
					</div>  
					</div>
					
				</div> 
			 
				
				
                <div class="row" style="visibility:hidden;">
                    <div class="col-md-9 col-sm-12 col-xs-12" >
                        <div class="panel panel-default">                            
							<div class="panel-heading">
							Area Chart
						</div>
						<div class="panel-body">
							<div id="morris-area-chart"></div>
						</div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12 col-xs-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                Donut Chart Example
                            </div>
                            <div class="panel-body">
                                <div id="morris-donut-chart"></div>
                            </div>
                        </div>
                    </div>

                </div>
				<div class="row">
				<div class="col-md-12">
				
					</div>		
				</div> 	
                <!-- /. ROW  -->

	<?php
	if($page=="")
	{
	   
	?>			
		<script language="javascript">
	setTimeout(function () {
   //Redirect with JavaScript
 window.location.href="result.php?page=2";
  
}, 10000);
	</script>		
     <?php
	 }
	 else if($page=="2")
	 {
	 ?>
	
	 <?php
	 }
	 
	 ?>           
			
		
		<?php
		}//est=3
		?>
				<footer><p>All right reserved. Template by: <a href="http://webthemez.com">WebThemez.com</a></p>
				
        
				</footer>
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
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	<script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script>

      
    <!-- Chart Js -->
    <script type="text/javascript" src="assets/js/Chart.min.js"></script>  
   <!-- <script type="text/javascript" src="assets/js/chartjs.js"></script> -->
   <script>
   $(function() {
  var ctx, data, myLineChart, options;
  Chart.defaults.global.responsive = true;
  ctx = $('#line-chart').get(0).getContext('2d');
  options = {
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: false,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].strokeColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: ['<?php echo $cap1[0]; ?>', '<?php echo $cap1[1]; ?>', '<?php echo $cap1[2]; ?>', '<?php echo $cap1[3]; ?>'],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(26, 188, 156,0.2)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [<?php echo $tper[0]; ?>, <?php echo $tper[1]; ?>, <?php echo $tper[2]; ?>, <?php echo $tper[3]; ?>]
      }/*, {
        label: "My Second dataset",
        fillColor: "rgba(34, 167, 240,0.2)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [28, 48, 40, 19, 86, 27, 90]
      }*/
    ]
  };
  myLineChart = new Chart(ctx).Line(data, options);
});

$(function() {
  var ctx, data, myBarChart, option_bars;
  Chart.defaults.global.responsive = true;
  ctx = $('#bar-chart').get(0).getContext('2d');
  option_bars = {
    scaleBeginAtZero: true,
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: false,
    barShowStroke: true,
    barStrokeWidth: 1,
    barValueSpacing: 5,
    barDatasetSpacing: 3,
    legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].fillColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>"
  };
  data = {
    labels: ['<?php echo $cap1[0]; ?>', '<?php echo $cap1[1]; ?>', '<?php echo $cap1[2]; ?>', '<?php echo $cap1[3]; ?>'],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(26, 188, 156,0.6)",
        strokeColor: "#1ABC9C",
        pointColor: "#1ABC9C",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#1ABC9C",
        data: [<?php echo $st[0]; ?>, <?php echo $st[1]; ?>, <?php echo $st[2]; ?>, <?php echo $st[3]; ?>]
      }/*, {
        label: "My Second dataset",
        fillColor: "rgba(34, 167, 240,0.6)",
        strokeColor: "#22A7F0",
        pointColor: "#22A7F0",
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#22A7F0",
        data: [28, 48, 40, 19, 86, 27, 90]
      }*/
    ]
  };
  myBarChart = new Chart(ctx).Bar(data, option_bars);
});
   </script>

</body>

</html>