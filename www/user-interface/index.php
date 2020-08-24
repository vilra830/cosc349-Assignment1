<!DOCTYPE html>

<html lang="en">

<head>
    <title>Escape Park - HomePage</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="./js/jquery/jquery-ui.min.css">
    <?php
    $scriptList = array ('js/jquery-3.4.1.min.js','js/Carousel.js' , 'js/Reviews.js');
    include('htaccess/header.php');
    ?>
</head>

<main>
    <div id="index">
        <p id="intro"> "Welcome to Escape Holiday Park , a place to relax, have fun and be one with nature"</p>
        <!--This photo is taken by Eric Muhr , downloaded from Wikimedia-->
        <figure id="indexPhoto">
            <img src="images/index.jpg" alt="background"> </figure>
        <div id="reviews"><h3>Customer Reviews</h3><p></p></div>
    </div>
</main>
<?php include("htaccess/footer.php"); ?>
</body>
</html>