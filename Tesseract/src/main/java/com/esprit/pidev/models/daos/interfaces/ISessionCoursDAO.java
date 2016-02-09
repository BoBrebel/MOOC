package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.SessionCours;
import java.util.Date;
import java.util.List;


public interface ISessionCoursDAO {
    
    public boolean ajouterSessionCours(SessionCours SessionCours);
    
    public List<SessionCours> getSessionCoursbyUserid(int idUser);
    
    public List<SessionCours> getSessionCoursbyCoursid(int idCours);
    
    public List<SessionCours> getSessionCoursbyDate(Date date);
}
