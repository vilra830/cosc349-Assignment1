# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.
Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.

  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
	config.vm.box = "ubuntu/xenial64"

  # Disable automatic box update checking. If you disable this, then
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
   config.vm.box_check_update = true

 # Vagrantfile will start up multiple interconnected VMs. 
	# We have called our first VM "custwebserver" intended for customer interface
	# since we intend it to run on a webserver
	config.vm.define "custwebserver" do |custwebserver|
	
	# These are the options specific to the custwebserver VM
	custwebserver.vm.hostname = "custwebserver"

	# Our host computer can
    # connect to IP address 127.0.0.1 port 8080, and that network
    # request will reach our webserver VM's port 80.
    custwebserver.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"


	# Create a private network, which allows host-only access to the machine
	# using a specific IP.
	custwebserver.vm.network "private_network", ip: "192.168.2.11"

	# This following line is only necessary in the CS Labs... but that
	# may well be where markers mark your assignment.
    custwebserver.vm.synced_folder ".", "/vagrant", owner: "vagrant", group: "vagrant", mount_options: ["dmode=775,fmode=777"]

	custwebserver.vm.provision "shell", path: "user-interface.sh"
	
 end 

	#Second VM


	config.vm.define "adminwebserver" do |adminwebserver|

		adminwebserver.vm.hostname = "adminwebserver"
		
		adminwebserver.vm.network "forwarded_port", guest: 80, host: 8081, host_ip: "127.0.0.1"
	
		adminwebserver.vm.network "private_network", ip: "192.168.2.12"
	
		adminwebserver.vm.synced_folder ".", "/vagrant", owner: "vagrant", group: "vagrant", mount_options: ["dmode=775,fmode=777"]
	
		adminwebserver.vm.provision "shell", path: "admin-interface.sh"
	end


	#Third VM - SQL server 
	# Here is the section for defining the database server, which I have
	# named "dbserver".
	config.vm.define "dbserver" do |dbserver|
    dbserver.vm.hostname = "dbserver"
	
	# Note that the IP address is different from that of the webserver
    # above: it is important that no two VMs attempt to use the same
    # IP address on the private_network.
    dbserver.vm.network "private_network", ip: "192.168.2.13"
    dbserver.vm.synced_folder ".", "/vagrant", owner: "vagrant", group: "vagrant", mount_options: ["dmode=775,fmode=777"]
    
	dbserver.vm.provision "shell" , path: "dbserver.sh"
	
	end

end
