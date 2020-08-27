<?php

$query="SELECT * FROM campsites LIMIT 20";

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

    echo "<tr><td>".$row["campNumber"]."</td><td>".$row["siteType"]."</td>.<td>".$row["description"]."</td>.<td>".$row["pricePerNight"]."</td></tr>\n";

//each item from the rows go in their respective vars and into the posts array
    $site[] = array ('number'=> $number, 'siteType'=> $siteType, 'description'=> $description, 'pricePerNight'=> $pricePerNight);

}

//the posts array goes into the response
$response['campsites']['site']= $site;

//creates the file
$fp = fopen('json/results.json', 'w');
fwrite($fp, json_encode($response));
fclose($fp);



?>

<?php


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


    echo "<tr><td>".$row["bookingNumber"]."</td><td>".$row["guestName"]."</td>.<td>".$row["checkin"]."</td>.<td>".$row["checkout"]."</td></tr>\n";

//each item from the rows go in their respective vars and into the posts array
    $booking[] = array ('number'=> $number, 'name'=> $name, "checkin" => ["day" => $date, "month" => $month, "year" => $year], "checkout" => ["day" => $date1, "month" => $month1, "year" => $year1]);

}

//the posts array goes into the response
$response['bookings']['booking']= $booking;

//creates the file
$fp = fopen('json/bookings1.json', 'w');
fwrite($fp, json_encode($response));
fclose($fp);
?>