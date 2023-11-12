# Spring and MySQL local configuration tutorial

This tutorial is designed to help you get started with MySQL and your SpringBoot project. 

## Table of Contents
1. [Prerequisite](#prerequisite)
2. [Steps](#steps)


## 1. Prerequisite
   - Ubuntu 20/22 [this tutortial should work for ubuntu18 too]
   - IntelliJ IDEA
   - JDK 17 or higher [Please remember to use LTS version]
   - Some SQL scripts that can create databases

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
      Remove anonymous users: chooes `Yes`. 
      Disallow root login remotely: chooes `Yes`. 
      Remove test database and access to it： `No`.
      Reload privilege tables now: `Yes`. 
   - Install MySQL Workbench: run `sudo snap install mysql-workbench-community`
   - (3)

<!-- ## 5. Workflow
   - Typical development workflow:
     - Find a problem/bug/possible improvement
     - Raise an issue for the problem/bug/possible improvement and discuss it with other developers
     - Pulling the latest changes from the develop branch.
     - Creating feature or bug-fix branches.
     - Committing changes and writing meaningful commit messages.
     - Pushing branches to GitHub.
     - Creating pull requests (PRs) for code review.
     - Addressing feedback and making necessary changes.
     - Merging PRs to the main branch.
     - Handling merge conflicts. -->


