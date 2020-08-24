<?php
/**
 * This file will get all the details through POST method using $_POST superglobal .
 * The booking details are then added to bookings.json
 * then echoes a confirmation of booking with details
 * Created by Rhea VIllafuerte
 */
session_start();
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
$_SESSION['name'] = $_POST['guestName'];
$_SESSION['number'] = $_POST['campSite'];
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


$file = "json/bookings.json";
$json_input = file_get_contents($file);
$json = json_decode($json_input,true);

$messages = array();
$formOk = true;

if(isset($_POST['book'])){
    $formOk = true;
    if(isEmpty($_SESSION['name'])) {
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


    array_push($json["bookings"]["booking"], array("number" => $_SESSION['number'], "name" => $_SESSION['name'], "checkin" => ["day" => $date, "month" => $month, "year" => $year]
    , "checkout" => ["day" => $date1, "month" => $month1, "year" => $year1]));

    file_put_contents($file, json_encode($json));


    echo "<p><b>Your booking is successful!</b></p>";
    echo "<p><b>These are your Booking Details:</b><br>
    <b>Booking Number: " . $_SESSION['number'] . "</b><br>
    <b>Booking Name: " . $_SESSION['name'] . "</b><br>
    <b>CheckIn: " . $date. "/" .$month. "/" . $year ."<br> CheckOut: " .$date1 ."/" .$month1. "/" .$year1. " </b></p>";

    echo "<p>Please click <a href='index.php'>here</a> to go back to Homepage</p>";

}


session_destroy();

?>
</main>

<?php include("htaccess/footer.php"); ?>

</body>
</html>

