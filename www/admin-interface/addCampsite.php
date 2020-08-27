<?php
/**
 * This file allows staff to add  new campsite details
 * It will initially check duplications of the new
 * campsite number. Then it will do the usual validation of inputs.
 * Once done, it will add the details into campsites.json.
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
    $scriptList = array ('js/jquery-3.4.1.min.js','js/CampSites.js','js/CampBooking.js');
    include('htaccess/header.php');
    include("htaccess/validateFunctions.php");
    include('htaccess/connect.php');
    ?>
</head>

<main>
    <h2>Add a Campsite</h2>
<?php


$number = $_SESSION['number'] = $_POST['number'];
$siteType = $_SESSION['siteType'] = $_POST['siteType'];
$description = $_SESSION['description'] = $_POST['description'];
$price = $_SESSION['price'] = $_POST['price'];

$a = 0;
$file = "json/campsites.json";
$json_input = file_get_contents($file);
$json = json_decode($json_input, true);
foreach ($json["campSites"]["site"] as $key) {
    if ($key["number"] == $_SESSION['number']) {
        $a++;
        }
    }


$messages = array();
$formOk = true;
if(isset($_POST['addCampsite'])){
    $formOk = true;
    if(isEmpty($_POST['number'])) {

        $formOk = false;
        array_push($messages , "Please enter a number");
    }    if(isEmpty($_POST['description'])) {

    $formOk = false;
    array_push($messages , "Please enter a description");
    } if (!isDigits($_POST['number']) || !checkLength($_POST['number'], 3)) {
        $formOk = false;
        array_push($messages,"Campsite number must be  a number and exactly 3 digits long");
    }  if(isEmpty($_POST['price'])) {
        $formOk = false;
        array_push($messages , "Please enter a price");
    }  if (!isDigits($_POST['price'])) {
        $formOk = false;
        array_push($messages,"Price must be a number ");
    } if ($a > 0 ){
        $formOk = false;
        array_push($messages, "Campsite number already exists - No duplication");
    }


}
if (count($messages) !=  0) {
    echo "<div><ul id='errors'><b>Errors:</b>";
    foreach ($messages as $error) {
        echo "<li>$error</li>";
    }
    echo "</ul></div>";

    echo "<p>Please click <a href='admin.php'>here</a> to go back to admin page</p>";

}else {

    echo "<p><b>These are your New Campsite Details:</b><br>
    <b>Campsite Number: </b>" . $_SESSION['number'] . "<br>
    <b>SiteType: </b>" . $_SESSION['siteType'] . "<br>
    <b>Description: </b>" . $_SESSION['description'] . "<br>
    <b>Price: </b>" . $_SESSION['price'] . "</p>";


     $query = "INSERT INTO campsites (campNumber, siteType , description, pricePerNight)VALUES('$number','$siteType','$description','$price')";

    if($conn->query($query) === TRUE) {
        echo "<p>Please click <a href='admin.php'>here</a> to go back to admin page</p>";

    } else {
        echo "Error: " . $query . "<br>" . $conn->error;
    }

    session_destroy();

}


?>
</main>
</body>
</html>
