package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PatientAlertProcessor {

    private NotificationService notificationService;
    private NotificationService smsService;
    private NotificationService emergencyService;

    @Autowired
    public PatientAlertProcessor(@Qualifier("emailNotificationService")NotificationService notificationService,
                                 @Qualifier("smsService") NotificationService smsService,
                                 @Qualifier("emergencyService") NotificationService emergencyService) {
        this.notificationService = notificationService;
        this.smsService = smsService;
        this.emergencyService = emergencyService;
    }

    public void processRoutineAlert(String patientId, String message) {
        notificationService.sendNotification(patientId, message);
    }

    public void processEmergencyAlert(String patientId, String message) {
        emergencyService.sendNotification(patientId, message);
    }
}
