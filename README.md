# cosc349 - Assignment1

In this project we have created a web-based campsite booking system for the fictional “Escape Park” company. This system allows potential campers to book a campsite online, and also provides a back-end access for the employees/admins of Escape Park to cancel bookings, add new campsites and edit campsites. All of these features are connected to a Mysql database which stores the information for the different campsite options, and stores all of the bookings that are made. 

<b> To run this application, here is the set of instructions: </b>

<br> Download and install Vagrant. 
<br>https://www.vagrantup.com/downloads.html

<br>Vagrant does not provide a virtualisation engine itself. It instead uses what it terms to be a “provider”, hence VirtualBox installation. 
<br>https://www.virtualbox.org/wiki/Downloads

<br>Clone the repository.
<br>git clone https://github.com/vilra830/cosc349-Assignment1

<br>Navigate to the directory that contains the cloned repository and run the command:
<br>vagrant up --provider VirtualBox

<br>To access custwebserver for customers:
<br>http://127.0.0.1:8080/index.php

<br>To access adminwebserver for administration:
<br>http://127.0.0.1:8081/admin.php

<br>To connect to the database: Run vagrant ssh dbserver
<br>Once on the shell : Run mysql -u root -p. Password is insecure_mysqlroot_pw
<br>Once on the database shell, type <b> Use fvision</b> which is the name of the database
