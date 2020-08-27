<?php $currentPage = basename($_SERVER['PHP_SELF']);
?>
    <?php
    if (isset($scriptList) && is_array($scriptList)) {
        foreach ($scriptList as $script) {
            echo "<script src='$script'></script>";
        }
    }
    ?>

<body>
<header>

        <h1>Escape Park</h1>
    <nav class="mainNav">
        <ul>
            <?php
            $navLinks = array("Home" => "admin.php");
            foreach ($navLinks as $key => $val){
                if($val === $currentPage) {
                    echo "<li>$key</li>";
                } else {
                    echo "<li><a href='$val'>$key</a></li>";
                }
            }
            ?>
        </ul>
    </nav>
</header>
