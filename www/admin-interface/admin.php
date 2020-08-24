<?php
/**
 * This file is the administration page of Escape Holiday Park. It has 4 forms which allow staff to
 * cancel booking, delete , edit or add campsite.
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
    include("htaccess/validateFunctions.php");

    ?>
</head>
<main>

    <h2>Administration Page</h2>
    <div class="admin">
        <form id="cancelBooking" action="cancelBooking.php" method = "POST" novalidate>
            <fieldset>
                <legend> Cancel Booking </legend>
                <p>
                    <label for=bookings> Bookings: </label>
                    <?php
                    echo "<select id='bookedCamp' name='bookedCamp'>";
                    $json_input = file_get_contents("json/bookings.json");
                    $json = json_decode($json_input,true);
                    foreach ($json["bookings"]["booking"] as $key) {
                        echo "<option value='" . $key["number"] . $key["name"]."'> Booking Number: " . $key["number"] . " Name: " . $key["name"] . "</option>";
                    }
                    echo "</select>";
                    ?>
                </p>
                <p>
                    <input type="submit" class="adminButtons" name="cancelBooking" value="Cancel Booking">
                </p>
            </fieldset>

        </form>
    </div>
    <div class="admin">
        <form id="deleteCampsite" action="deleteCampsite.php" method = "POST" novalidate>
            <fieldset>
                <legend> Delete Campsites </legend>
                <p>
                    <label for=campsites> Campsites: </label>
                    <?php
                    echo "<select id='campsites' name='campsites'>";
                    $json_input = file_get_contents("json/campsites.json");
                    $json = json_decode($json_input,true);
                    var_dump($json);
                    foreach ($json["campSites"]["site"] as $key){
                        echo "<option value='".$key["number"]."'> Campsite Number: " .$key["number"] ."</option>";
                    }
                    echo "</select>";
                    ?>
                </p>

                <p>
                    <input type="submit" class="adminButtons" name="deleteCampsite" value="Delete Campsite">
                </p>
            </fieldset>

        </form>
    </div>
    <div class="admin">
        <form id="addCampsite" action="addCampsite.php" method = "POST" novalidate>
            <fieldset>
                <legend> Add a Campsite </legend>
                <p>
                    <label for="number"> Campsite Number: </label>
                    <input type="text" name="number" placeholder="Campsite Number" <?php
                    if (isset($_SESSION['number'])) {
                        $number = $_SESSION['number'];
                        echo "value='$number'";

                    }
                    ?>>
                </p>
                <p>
                    <label for="siteType"> Site Type:</label>
                    <select id="siteType" name="siteType" <?php
                    if (isset($_SESSION['siteType'])) {
                        $siteType = $_SESSION['siteType'];
                        echo "value='$siteType'";

                    }
                    ?>>
                        <option value="Tent">Tent</option>
                        <option value="Cabin">Cabin</option>
                        <option value="Van">Van</option>
                    </select>
                </p>
                <p>
                    <label for="description"> Description: </label>
                    <textarea rows="4" cols="50"  type="text" name="description" placeholder="Description" <?php
                    if (isset($_SESSION['description'])) {
                        $description = $_SESSION['description'];
                        echo "value='$description'";

                    }
                    ?>></textarea>
                </p>
                <p>
                    <label for="price"> Price Per Night: </label>
                    <input type="text" name="price" placeholder="Price" <?php
                    if (isset($_SESSION['price'])) {
                        $price = $_SESSION['price'];
                        echo "value='$price'";

                    }
                    ?>>
                </p>
                <p>
                    <input type="submit" class="adminButtons" name="addCampsite" value="Add Campsite">
                </p>
            </fieldset>

        </form>
    </div>
    <div class="admin">
        <form id="editCampsite" action="editCampsite.php" method = "POST" novalidate>
            <fieldset>
                <legend> Edit a Campsite </legend>
                <p>
                    <label for=number> Campsite Number: </label> <?php
                    echo "<select id='campsites' name='number'>";
                    $json_input = file_get_contents("json/campsites.json");
                    $json = json_decode($json_input,true);
                    var_dump($json);
                    foreach ($json["campSites"]["site"] as $key){
                        echo "<option value='".$key["number"]."'> Campsite Number: " .$key["number"]. "</option>";
                    }
                    echo "</select>";
                    ?>
                </p>
                <p>
                    <label for=newNumber> Number: </label>
                    <input type="text"  name="newNumber" placeholder="New number"  <?php
                    if (isset($_SESSION['newNumber'])) {
                        $newNumber = $_SESSION['newNumber'];
                        echo "value='$newNumber'";

                    }
                    ?>>
                </p>
                <p>
                    <label for=siteType> Site Type:</label>
                    <select id='campsites' name='siteType' <?php
                    if (isset($_SESSION['siteType'])) {
                        $siteType = $_SESSION['siteType'];
                        echo "value='$siteType'";

                    }
                    ?> >
                        <option value="tent">Tent</option>
                        <option value="cabin">Cabin</option>
                        <option value="van">Van</option>
                    </select>
                </p>
                <p>
                    <label for=description> Description: </label>
                    <textarea rows="4" cols="50"  type="text" name="description" placeholder="Description" <?php
                    if (isset($_SESSION['description'])) {
                        $description = $_SESSION['description'];
                        echo "value='$description'";

                    }
                    ?> ></textarea>
                </p>
                <p>
                    <label for=price> Price Per Night: </label>
                    <input type="text" name="price" placeholder="Price" <?php
                    if (isset($_SESSION['price'])) {
                        $price = $_SESSION['price'];
                        echo "value='$price'";

                    }
                    ?>>
                </p>
                <p>
                    <input type="submit" class="adminButtons" name="addCampsite" value="Edit Campsite">
                </p>
            </fieldset>


        </form>
    </div>


</main>
<?php include("htaccess/footer.php"); ?>
</body>
</html>
