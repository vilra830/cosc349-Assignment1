# cosc349 - Assignment1

In this project we have created a web-based campsite booking system for the fictional “Escape Park” company. This system allows potential campers to book a campsite online, and also provides a back-end access for the employees/admins of Escape Park to cancel bookings, add new campsites and edit campsites. All of these features are connected to a Mysql database which stores the information for the different campsite options, and stores all of the bookings that are made. 

<b> To run this application, here is the set of instructions:
Download and install Vagrant.
https://www.vagrantup.com/downloads.html
Vagrant does not provide a virtualisation engine itself. It instead uses what it terms to be a “provider”, hence VirtualBox installation. 
https://www.virtualbox.org/wiki/Downloads
Clone the repository.
git clone https://github.com/vilra830/cosc349-Assignment1
Navigate to the directory that contains the cloned repository and run the command:
vagrant up --provider VirtualBox
To access custwebserver for customers:
http://127.0.0.1:8080/index.php
To access adminwebserver for administration:
http://127.0.0.1:8081/admin.php
