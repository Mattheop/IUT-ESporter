package com.example.sae.controller.ecurie;

import com.example.sae.models.db.Ecurie;
import com.example.sae.models.db.Notification;
import com.example.sae.repository.NotificationRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/ecurie/messages")
public class EcurieNotificationController extends EcurieDashboard {

    private NotificationRepository notificationRepository;

    public EcurieNotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("")
    public String index(Authentication authentication, Model model) {
        Ecurie managedEcurie = getManagedEcurie(getAppUser(authentication));

        Collection<Notification> notifications = this.notificationRepository.findTop15ByEcurieIdOrderByDateDesc(managedEcurie.getId());

        model.addAttribute("messages", notifications);

        this.notificationRepository.markAllNotificationReadedByEcurieId(managedEcurie.getId());

        return "ecurie/notification";
    }
}
