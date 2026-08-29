# EC2 Setup Tutorial

-----

Please make sure you login into the ```us-west-2/Oregon``` region. Otherwise you cannot find any existing resource. 

### EC2 instance launch

Go to EC2 -> EC2 Dashboard -> Launch Instance

Enter all EC2 instance name first. Then select the OS of the instance. If you choice the Amazon Linux system, the default user name is ```root```. For the ubuntu system, the default user name is ```ubuntu```.

We recommand to choice the free tier eligible Amazon Machine Image (AMI). It should be capaible for us to expience all our current functionilies and infras. In the future, services can migate to envirnment with higher capacities for Prod. (Or we could use Lambda which gives us more horizontal scaling elasticity)

```Key pair``` is the session where you can put/generate your ssh key for your service. If you want to use our existing public key pair, please select ```public_key_pair``` from dropdown box. Then you can use the pem file to ssh. To use your own ssh, click create new key pair. Please keep the key file properly, it will only be downloaded in create page. You won't be able to login to your own instance if you lost your ssh key and have to delete the old instance and create a new one.

For the Firewall (Security Groups), you can create your own group. Or you can use existing groups. One option is using ```launch-wizard-2```. It is the security group applied to the dev instance, which allowlist all our ips to access the instance with valid PEM key. If you want to restrict the access into only you can access it, please create your own securtiy group.

To get your current Public IP, run command ```curl https://ipinfo.io```	

In the end, click ```launch instance``` and wait until your instance been created.

### EC2 instance access

#### through ssh command

First, go to the console -> EC2 -> Instances

Click your instance, you should be about to find the Public IPv4 DNS in summary

The ssh username for Ubuntu is ```ubuntu```, for the Amazon Linux system is ```root```.

Then run this command to connect to your EC2 instace:

```
ssh -i /path/to/your/public_key_pair.pem <ssh-username>@<Public IPv4 DNS>
```
#### through Python code

Here is the python3 script to connect to the EC2 instance and do ```pwd``` in the home.

```
import logging
import sshtunnel
from sshtunnel import SSHTunnelForwarder
import paramiko

ssh_host = 'EC2 instance Public IPv4 DNS'
ssh_username = '<ssh username>'
ssh_key_file = '</path/to/your/public_key_pair.pem>'


key = paramiko.RSAKey.from_private_key_file(ssh_key_file)
client = paramiko.SSHClient()
client.set_missing_host_key_policy(paramiko.AutoAddPolicy())

try:
    # Here 'ubuntu' is user name and 'instance_ip' is public IP of EC2
    client.connect(hostname=ssh_host, username=ssh_username, key_filename=ssh_key_file)

    # Execute a command(cmd) after connecting/ssh to an instance
    stdin, stdout, stderr = client.exec_command('pwd')
    print(stdout.read())
    # close the client connection once the job is done
    client.close()
except e:
    print(e)
```


### Install MySQL

As we choose to open the EC2 instance with Ubuntu system, it is just as sample as your local machine to install MySQL. In our dev instance, I followed commands from this tutorial: https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-20-04