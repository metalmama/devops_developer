terraform {
 required_providers {
   aws = {
     source  = "hashicorp/aws"
     version = "~> 4.36.1"
   }
 }
}

provider "aws" {
  region  = "eu-north-1"
}


resource "tls_private_key" "webt1_private_key" {
    algorithm   =  "RSA"
    rsa_bits    =  4096
}
resource "local_file" "private_key" {
    content         =  tls_private_key.webt1_private_key.private_key_pem
    filename        =  "webserver_key.pem"
    file_permission =  0400
}
resource "aws_key_pair" "task1_key" {
  key_name   = "task1_key"
  public_key = tls_private_key.webt1_private_key.public_key_openssh
}



resource "aws_security_group" "allow_app_port" {
  name        = "allow_app_port"
  description = "Allow tcp8080 traffic"
  key_name =aws_key_pair.task1_key.key_name


  ingress {
    description = "application"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
 
  }
  ingress {
    description = "ssh"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
 
  }
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "allow_app_port"
  }
}



resource "aws_instance" "app_server" {
  ami           = "ami-0149b2da6ceec4bb0"
  instance_type = "t3.micro"

  tags = {
    Name = "an_ubunutu_instance"
  }
    security_groups=["${aws_security_group.allow_app_port.name}"]

    root_block_device {
        delete_on_termination = true
        device_name           = "/dev/sda1"
        encrypted             = false
        iops                  = 0
        tags                  = {}
        throughput            = 0
        volume_id             = "vol-031d56cc45ea4a245"
        volume_size           = 8
        volume_type           = "standard"
    }

}  

variable "ec2_instance_name" {
  type = string
  default = "an_ubunutu_instance"
}

output "public_ip" {
  value = aws_instance.app_server.public_ip
}

# provisioner "local-exec" {
# 	command = "sleep 120; ANSIBLE_HOST_KEY_CHECKING=False ansible-playbook -u ubuntu --private-key ./webserver_key.pem -i '${aws_instance.app_server.public_ip},' master.yml"
# }
# The above command was to call terraform from ainsible, but because I realised I needed ainsible to call terraform I didn't need the above,but kept it in as notes. 
