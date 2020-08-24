<?php
session_start();
?>
<!--This file allows customers to make a booking
 -- It also validates inputs - It is using Nick's CampBooking.js file to validate its inputs.
 Created by Rhea VIllafuerte-->
<!DOCTYPE html>

<html lang="en">

<head>
    <title>Escape Park - Booking Page</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="./js/jquery/jquery-ui.min.css">
    <?php
    $scriptList = array ('./js/jquery/jquery3.3.js','./js/jquery/jquery-ui.js','js/CampBooking.js' , 'js/CampSites.js');
    include('htaccess/header.php');
    include("htaccess/validateFunctions.php");

    ?>
</head>
<main>
<div id="bookingData">
    <form id="bookingForm" action="bookCamp.php" method="POST">
    <section id="siteList">
    <fieldset>
        <legend>Our Accommodation Options</legend>
        <ul id="accommTypeLst" <?php
        if (isset($_SESSION['campSite'])) {
            $campSite = $_SESSION['campSite'];
            echo "value='$campSite'";

        }
        ?>></ul>
    </fieldset>
</section>

<fieldset id="selectDates">
    <legend>Booking Dates</legend>
    <p>
        <label for="checkin"> CheckIn Date: </label>
        <input type="text" id="arriveDatepicker" name="arriveDatepicker"  <?php
        if (isset($_SESSION['arriveDatepicker'])) {
            $arriveDatepicker = $_SESSION['arriveDatepicker'];
            echo "value='$arriveDatepicker'";

        }
        ?>>
    </p>
    <p>
        <label for="checkout"> CheckOut Date: </label>
        <input type="text" id="departDatepicker" name="departDatepicker" <?php
        if (isset($_SESSION['departDatepicker'])) {
            $departDatepicker = $_SESSION['departDatepicker'];
            echo "value='$departDatepicker'";

        }
        ?>></p>

    <p>
        <button type="button" id="checkAvail">Check What's Available</button>
    </p>
    <div id="dateErrors"></div>
</fieldset>
        <fieldset>
            <legend>Your Details</legend>
            <p>
            <label for="guestName"> Guest Name: </label>
            <input type="text" id="guestName" name="guestName" <?php
            if (isset($_SESSION['guestName'])) {
                $guestName = $_SESSION['guestName'];
                echo "value='$guestName'";

            }
            ?>>
            </p>
            <input type="submit" id="makeBooking" name="book" value="Book Selected Site">

        </fieldset>

    </form>
</section>
<section id="sitePreview"></section>
</div>


</main>
<?php include("htaccess/footer.php"); ?>

</body>
</html>