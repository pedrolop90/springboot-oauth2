data "aws_vpc" "default" {
  default = true
}

data "aws_subnet_ids" "all_available" {
  vpc_id = data.aws_vpc.default.id
}

resource "aws_elb" "terraform_elb_testing_1" {
  name = "terraform-elb-testing-1"
  availability_zones = data.aws_subnet_ids.all_available.ids

  #  access_logs {
  #    bucket        = "terraform_elb_testing_logs_1"
  #    bucket_prefix = "testing_elb_logs"
  #    interval      = 60
  #  }

  listener {
    instance_port = 8010
    instance_protocol = "http"
    lb_port = 8010
    lb_protocol = "http"
  }

  health_check {
    healthy_threshold = 2
    unhealthy_threshold = 2
    timeout = 3
    target = "HTTP:8010/"
    interval = 30
  }

  instances = [
    aws_instance.instancia_testing_1.id
  ]
  cross_zone_load_balancing = true
  idle_timeout = 400
  connection_draining = true
  connection_draining_timeout = 400

  tags = {
    ENV = "DEV"
    GROUP = "DEFAULT"
    TYPE = "TESTING"
    NAME = var.project_name
  }
}