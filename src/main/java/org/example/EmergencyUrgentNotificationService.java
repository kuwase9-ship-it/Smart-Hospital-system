package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("emergencyService")
public class EmergencyUrgentNotificationService implements NotificationService {

    @Value("${HOSPITAL_API_SECRET}")
    private String apiSecret;

    @Override
    public void sendNotification(String patientId, String message) {
        System.out.println("EMERGENCY to Patient: " + patientId + " : " + message);

    }
}