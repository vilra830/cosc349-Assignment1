
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
        include('htaccess/connect.php');
        ?>
    </head>
    <main>
        <h2>Administration Page - Cancel Booking</h2>
<?php
$number = $_POST["bookedCamp"];


$sql = "DELETE FROM bookings WHERE bookingNumber='$number'";

if ($conn->query($sql) === TRUE) {

    echo "<p> Booking No."."$number"." has been canceled! </p>";
    echo "<p>Click <a href='admin.php'> here </a> to go back to admin page</p>";

} else {
    echo "Error canceling booking. " . $conn->error;
}
?>
</main>
<?php include("htaccess/footer.php"); ?>
        </body>
</html>
