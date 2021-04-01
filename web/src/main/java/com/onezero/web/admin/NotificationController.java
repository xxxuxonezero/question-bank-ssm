package com.onezero.web.admin;

import com.onezero.auth.AuthUtils;
import com.onezero.bll.notification.Notification;
import com.onezero.bll.notification.NotificationManager;
import com.onezero.datastructure.Code;
import com.onezero.datastructure.NoneDataResult;
import com.onezero.web.data.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/Admin/Notification")
public class NotificationController {
    @Autowired
    private NotificationManager notificationManager;

    @PostMapping("/Send")
    public NoneDataResult send(HttpServletRequest request,
                               @RequestBody Notification notification) {
        NoneDataResult result = new NoneDataResult();
        Identity identity = AuthUtils.getIdentity(request);

        Date publishTime = notification.getPublishTime();
        Date current = new Date();
        if (publishTime == null) {
            notification.setPublishTime(current);
        } else if (publishTime.before(current)) {
            result.setCode(Code.PUBLISH_TIME_CANNOT_BEFORE_CURRENT);
            return result;
        }

        notification.setUserId(identity.getId());
        result = notificationManager.create(notification);
        if (result.isNotOK()) {
            return result;
        }

        return result;
    }
}
