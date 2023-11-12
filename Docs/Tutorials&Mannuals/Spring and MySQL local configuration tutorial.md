# Spring and MySQL local configuration tutorial

This tutorial is designed to help you get started with MySQL and your SpringBoot project. 

## Table of Contents
1. [Prerequisite](#prerequisite)
2. [Steps](#steps)


## 1. Prerequisite
   - Ubuntu 20/22 [this tutortial should work for ubuntu18 too]
   - IntelliJ IDEA
   - JDK 17 or higher [Please remember to use LTS version]
   - Some SQL scripts that can create tables

## 2. Steps
   - Install MySQL
      - (1) run `sudo apt update`
      - (2) run `sudo apt install mysql-server`
         After the command is executed, run `sudo systemctl status mysql.service`to check the running status of the MySQL server. You should see something like this:
         ```
         ● mysql.service - MySQL Community Server
            Loaded: loaded (/lib/systemd/system/mysql.service; enabled; vendor preset: enabled)
            Active: active (running) since Sat 2023-11-11 20:18:20 MST; 1min 23s ago
           Process: 8807 ExecStartPre=/usr/share/mysql/mysql-systemd-start pre (code=exited, st>
          Main PID: 8815 (mysqld)
            Status: "Server is operational"
             Tasks: 37 (limit: 9387)
            Memory: 365.6M
               CPU: 1.819s
            CGroup: /system.slice/mysql.service
                    └─8815 /usr/sbin/mysqld
         ```
      - (3) run `sudo mysql_secure_installation`. This command is used to enhance the security of a MySQL server. 
      After the command is executed, the system will ask you do you want to setup VALIDATE PASSWORD component. You can choose `No` here. 
      Although we did not use VALIDATE PASSWORD component here, we still need to set a password for our root account. If the setting process
      does not show up, remeber to run `sudo mysql -u root` and then run `ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';`.
      Remove anonymous users: chooes `Yes`. 
      Disallow root login remotely: chooes `Yes`. 
      Remove test database and access to it： `No`.
      Reload privilege tables now: `Yes`. 
   - Install MySQL Workbench: run `sudo snap install mysql-workbench-community`
   - Create database
      - First open and connect to your local server
      - navigate to `Schemas`. Since we did not Remove test database, we should have a default database `sys` like this: 
      - 
      - Click the button in the picture and create the databse with the name you want. 
      - Run the SQL scripts you have to create the tables. 
      - Insert some test data. 
   - Connect to the database with your Spring project

## 5. Reference: 
   - install MySQL and MySQL workbench: https://www.youtube.com/watch?v=zRfI79BHf3k
   - setup pw after installation: https://stackoverflow.com/questions/7864276/cannot-connect-to-database-server-mysql-workbench
   - Create database with MySQL workbench: https://www.youtube.com/watch?v=wALCw0F8e9M




