package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {

    @Value("${hospital.name:Masaka CHIB Hospital}")
    private String hospitalName;

    @Override
    public void sendNotification(String patientId, String message) {
        System.out.println("(..." + hospitalName + "...) EMAIL to Patient " + patientId + ": " + message);
    }
}