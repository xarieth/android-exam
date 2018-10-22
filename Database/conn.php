<?php
define('SERVERNAME', 'localhost');
define('USERNAME','root');
define('PASSWORD','');
define('DATABASE','myapplication');

$conn=mysqli_connect(SERVERNAME,USERNAME,PASSWORD,DATABASE);
if(!$conn){
	die('ERROR : ' . mysqli_connect_error($conn));

}


?>