<?php
session_start();
?>
<!DOCTYPE html>
<title>Escape Park - Contact Page</title>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="leaflet.css">


<html lang="en">
<?php
$scriptList = array ('js/jquery-3.4.1.min.js','js/leaflet.js','js/map.js');
include('htaccess/header.php');

?>
</head>

<main>
    <div><figure id="map">
            <!--<img src="images/map.png" alt="Map placeholder">-->
        </figure> </div>



</main>
<?php include("htaccess/footer.php"); ?>


</body>
</html>