    <?php
    /**
     * This file allows staff to edit the details of a campsite
     * It will initially check if there is an existing booking under
     * the campsite that is to be edited. Also, it will check duplications of the new
     * campsite number. Then it will do the usual validation of inputs.
     * Once done, it will unset the campsite and add the new details in.
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
            <h2>Edit a Campsite</h2>
            <?php


    $newNumber = $_SESSION['newNumber'] = $_POST['newNumber'];
    $siteType = $_SESSION['siteType'] = $_POST['siteType'];
    $description = $_SESSION['description'] = $_POST['description'];
    $price = $_SESSION['price'] = $_POST['price'];


    $number = $_POST['number'];
    $messages = array();
    $formOk = true;

    if(isset($_POST['addCampsite'])) {
        $formOk = true;
        if (isEmpty($_POST['newNumber'])) {
            $formOk = false;
            array_push($messages, "Please enter a number");
        }
        if (isEmpty($_POST['description'])) {
            $formOk = false;
            array_push($messages, "Please enter a description");
        }
        if (!isDigits($_POST['newNumber']) || !checkLength($_POST['newNumber'], 3)) {
            $formOk = false;
            array_push($messages, "Campsite number must be  a number and exactly 3 digits long");
        }
        if (isEmpty($_POST['price'])) {
            $formOk = false;
            array_push($messages, "Please enter a price");
        }
        if (!isDigits($_POST['price'])) {
            $formOk = false;
            array_push($messages, "Price must be a number ");
        }

        $query = "SELECT * FROM bookings , campsites";
        $result = $conn->query($query)
        or die  ($conn->error);

        while ($row = $result->fetch_assoc()) //mysql_fetch_array($sql)
        {
            if ($newNumber == $row["bookingNumber"]) {

                $formOk = false;
                array_push($messages, "There is an existing booking on that number");
                break;
            }

            if($newNumber == $row["campNumber"] && $newNumber != $number){

                $formOk = false;
                array_push($messages, "Campsite number already exists - No duplication");

            }
        }
        if (count($messages) != 0) {
            echo "<div><ul id='errors'><b>Errors:</b>";

            foreach ($messages as $error) {
                echo "<li>$error</li>";

            }
            echo "</ul></div>";

            echo "<p>Please click <a href='admin.php'>here</a> to go back to admin page</p>";


        } else {

        ?>

        <?php
            //array_push($json["campSites"]["site"], array("number" => $_SESSION['newNumber'], "siteType" => $_SESSION['siteType'], "description" => $_SESSION['description'], "pricePerNight" => $_SESSION['price']));
            //file_put_contents($file, json_encode($json));


            echo "<p><b>These are your New Campsite Details:</b><br>
        <b>Campsite Number: </b>" . $_SESSION['newNumber'] . "<br>
        <b>SiteType: </b>" . $_SESSION['siteType'] . "<br>
        <b>Description: </b>" . $_SESSION['description'] . "<br>
        <b>Price: </b>" . $_SESSION['price'] . "</p>";


            $query = "UPDATE campsites SET campNumber = '$newNumber' , siteType= '$siteType', description= '$description', pricePerNight='$price' WHERE campNumber='$number'";

            if($conn->query($query) === TRUE) {
                echo "<p>Please click <a href='admin.php'>here</a> to go back to admin page</p>";

            } else {
                echo "Error: " . $query . "<br>" . $conn->error;
            }



            
            session_destroy();

        }
    }


    ?>





    </main>
    </body>
    </html>
