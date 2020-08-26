<?php
$db_host   = '192.168.2.13';
$db_name   = 'fvision';
$db_user   = 'webuser';
$db_passwd = 'admin';
$conn = new mysqli($db_host, $db_user, $db_passwd, $db_name);
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>
