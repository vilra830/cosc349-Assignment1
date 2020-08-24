
<?php
/**
 * This file allows staff to cancel the selected booking
 * It will unset booking entry from bookings.json once staff preses cancel booking button
 * Also echoes confirmation of canceled booking
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
        <h2>Administration Page - Cancel Booking</h2>
<?php
$number = $_POST["bookedCamp"];

$file = "json/bookings.json";
$json_input = file_get_contents($file);
$json = json_decode($json_input,true);


foreach($json["bookings"]["booking"] as $elementKey => $element) {
    if ($element["number"] . $element["name"] == $number) {
        unset($json["bookings"]["booking"][$elementKey]);
    }
}

file_put_contents($file, json_encode($json));

echo "<p> Booking No."."$number"." has been canceled! </p>";
echo "<p>Click <a href='admin.php'> here </a> to go back to admin page</p>";


?>
</main>
<?php include("htaccess/footer.php"); ?>
        </body>
</html>
