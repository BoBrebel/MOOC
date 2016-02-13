
package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Notification;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface INotificationDAO {
     public boolean createNotification(Notification notification) throws SQLException;

    public List<Notification> displayNotificationByUserId(int idUtilisateur) throws SQLException;

    public List<Notification> displayNotificationByDate(Date date ) throws SQLException;
    
}
