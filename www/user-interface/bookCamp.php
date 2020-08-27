<?php
/**
 * This file will get all the details through POST method using $_POST superglobal .
 * The booking details are then added to bookings.json
 * then echoes a confirmation of booking with details
 * Created by Rhea VIllafuerte
 */
session_start();
include('htaccess/connect.php');
?>
<!DOCTYPE html>

<html lang="en">

<head>
    <title>Escape Holiday Park Administrative Page</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <?php
    $scriptList = array ('js/jquery-3.4.1.min.js');
    include('htaccess/header.php');
    include('htaccess/validateFunctions.php');
    ?>
</head>

<main>
    <h2>Book a Camp</h2>
<?php
$name = $_SESSION['name'] = $_POST['guestName'];
$number = $_SESSION['number'] = $_POST['campSite'];
$_SESSION['checkIn'] = $_POST['arriveDatepicker'];
$_SESSION['checkOut'] = $_POST['departDatepicker'];


$timestamp = strtotime($_SESSION['checkIn']);
$date=date('d',$timestamp);
$month=date('m',$timestamp);
$year=date('Y',$timestamp);
$checkin = date('Y-m-d',$timestamp);



$timestamp1 = strtotime($_SESSION['checkOut']);
$date1=date('d',$timestamp1);
$month1=date('m',$timestamp1);
$year1=date('Y',$timestamp1);
$checkout = date('Y-m-d',$timestamp1);

$datee= new DateTime('today');
$dateNow=$datee->format('Y-m-d');

$messages = array();
$formOk = true;

if(isset($_POST['book'])){
    $formOk = true;
    if(isEmpty($_SESSION['number'])) {
        $formOk = false;
        array_push($messages , "Please select a campsite");

    }   if($_POST['guestName'] == "") {

        $formOk = false;
        array_push( $messages , "Please enter your name");

    } if ($checkin == $checkout){
        $formOk = false;
        array_push($messages, "Checkout on same day of checkin is not allowed");
    }
    if ($checkin > $checkout){
        $formOk = false;
        array_push($messages, "You must arrive before you depart");
    }
    if ($dateNow >= $checkin) {
        $formOk = false;
        array_push($messages, "We only accept bookings in the future");


    }

}
if (count($messages) !=  0) {
    $formOk = false;
    echo "<div><ul id='errors'><b>Errors:</b>";
    foreach ($messages as $error) {
        echo "<li>$error</li>";
    }

    echo "<p>Click <a href='booking.php'> here </a> to go back</p>";
    echo "</ul></div>";
} else {


    echo "<p><b>Your booking is successful!</b></p>";
    echo "<p><b>These are your Booking Details:</b><br>
    <b>Booking Number: " . $_SESSION['number'] . "</b><br>
    <b>Booking Name: " . $_SESSION['name'] . "</b><br>
    <b>CheckIn: " . $date. "/" .$month. "/" . $year ."<br> CheckOut: " .$date1 ."/" .$month1. "/" .$year1. " </b></p>";


    $query = "INSERT INTO bookings(bookingNumber, checkin , checkout, guestName)VALUES('$number','$checkin','$checkout','$name')";

    if($conn->query($query) === TRUE) {
        echo "<p>Please click <a href='index.php'>here</a> to go back to Homepage</p>";

    } else {
        echo "Error: " . $query . "<br>" . $conn->error;
    }
}


session_destroy();

?>
</main>

<?php include("htaccess/footer.php"); ?>

</body>
</html>

