package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(e -> System.setProperty(e.getKey(), e.getValue()));

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        PatientAlertProcessor processor = context.getBean(PatientAlertProcessor.class);

        processor.processRoutineAlert("P001", "Your appointment is tomorrow at 10am");
        processor.processEmergencyAlert("P002", "ICU patient heart rate dropping!");
        processor.processEmergencyAlert("P003", "You will pass in X-ray on 25th");
        processor.processEmergencyAlert("P004", "Your surgery results are out !");
        context.close();
    }
}