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
    include('htaccess/connect.php');


    ?>
</head>
<main>
<div id="bookingData">
    <form id="bookingForm" action="bookCamp.php" method="POST">
    <section id="siteList">
    <fieldset>
        <legend>Our Accommodation Options</legend>
        <ul id="accommTypeLst" <?php

        $query="SELECT * FROM campsites";

        $result= $conn->query($query)
        or die  ($conn->error);

        //store the entire response
        $response = array();

        //the array that will hold the titles and links

        $site = array();

        $campsites = array($site);


        while($row=$result->fetch_assoc()) //mysql_fetch_array($sql)
        {
            $number=$row['campNumber'];
            $siteType=$row['siteType'];
            $description=$row['description'];
            $pricePerNight=$row['pricePerNight'];

            //echo "<tr><td>".$row["campNumber"]."</td><td>".$row["siteType"]."</td>.<td>".$row["description"]."</td>.<td>".$row["pricePerNight"]."</td></tr>\n";

//each item from the rows go in their respective vars and into the posts array
            $site[] = array ('number'=> $number, 'siteType'=> $siteType, 'description'=> $description, 'pricePerNight'=> $pricePerNight);

        }

        //the posts array goes into the response
        $response['campsites']['site']= $site;

        //creates the file
        $fp = fopen('json/results.json', 'w');
        fwrite($fp, json_encode($response));
        fclose($fp);




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
        $query="SELECT * FROM bookings";

        $result= $conn->query($query)
        or die  ($conn->error);

        //store the entire response
        $response = array();

        //the array that will hold the titles and links

        $booking = array();

        $bookings = array($booking);


        while($row=$result->fetch_assoc()) //mysql_fetch_array($sql)
        {
            $number=$row['bookingNumber'];
            $name=$row['guestName'];
            $checkin=$row['checkin'];
            $checkout=$row['checkout'];

            $timestamp = strtotime($checkin);
            $date=date('d',$timestamp);
            $month=date('m',$timestamp);
            $year=date('Y',$timestamp);

            $timestamp1 = strtotime($checkout);
            $date1=date('d',$timestamp1);
            $month1=date('m',$timestamp1);
            $year1=date('Y',$timestamp1);


            //echo "<tr><td>".$row["bookingNumber"]."</td><td>".$row["guestName"]."</td>.<td>".$row["checkin"]."</td>.<td>".$row["checkout"]."</td></tr>\n";

//each item from the rows go in their respective vars and into the posts array
            $booking[] = array ('number'=> $number, 'name'=> $name, "checkin" => ["day" => $date, "month" => $month, "year" => $year], "checkout" => ["day" => $date1, "month" => $month1, "year" => $year1]);

        }

        //the posts array goes into the response
        $response['bookings']['booking']= $booking;

        //creates the file
        $fp = fopen('json/bookings1.json', 'w');
        fwrite($fp, json_encode($response));
        fclose($fp);



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