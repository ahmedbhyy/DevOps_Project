package tn.esprit.devops_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "tn.esprit.devops_project.entities")
public class DevOpsProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }

}
