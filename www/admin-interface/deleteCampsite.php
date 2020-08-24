<?php
/**
 * This file allows staff to delete the selected campsite
 * It will initially check if there is an existing booking under
 * the campsite. If there is, it will update staff and deletion will not go through.
 * if no existing booking, it will unset the campsite from campsites.json.
 * Created by Rhea Villafuerte
 */
session_start();
?>
<!DOCTYPE html>

    <html lang="en">

    <head>
        <title>Escape Park - Admin Page</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="style.css">
        <?php
        $scriptList = array ('js/jquery-3.4.1.min.js');
        include('htaccess/header.php');
        ?>
    </head>
    <main>
        <h2>Administration Page - Delete</h2>
<?php

$number = $_POST["campsites"];


$file = "json/bookings.json";
$json_input = file_get_contents($file);
$json = json_decode($json_input, true);
//var_dump($json["bookings"]["booking"] );
//unset($json["bookings"]["booking"]["name"]);
//unset($json["bookings"]["booking"]->["name"]);
//unset($bookings["name"]);

$a = 0;

foreach ($json["bookings"]["booking"] as $elementKey => $element) {
    //var_dump($element);
    if ($element["number"] == $number) {
        $a++;

    }
}

if($a > 0){

    echo "<p><b>Can't cancel , there is an existing booking for this campsite</b> </p>";
    echo "<p>Click <a href='admin.php'> here </a> to go back</p>";


} else {
    $file = "json/campsites.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);

    foreach ($json["campSites"]["site"] as $elementKey => $element) {
        //      var_dump($element);
        if ($element["number"] == $number) {
            unset($json["campSites"]["site"][$elementKey]);
            echo "<p>Campsite" . "$number" . " has been deleted. Please click <a href='admin.php'>here</a>  to see changes</p>";


        }



    }
    echo "<p>Click <a href='admin.php'> here </a> to go back to admin page</p>";

}
file_put_contents($file, json_encode($json));


?>
</main>
<?php include("htaccess/footer.php"); ?>
        </body>
</html>
