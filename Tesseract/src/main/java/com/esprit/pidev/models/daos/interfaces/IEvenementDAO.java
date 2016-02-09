package com.esprit.pidev.models.daos.interfaces;
import com.esprit.pidev.models.entities.Evenement;
import java.util.List;


public interface IEvenementDAO {
    
    public boolean addEvenement(Evenement evn);
    
    public boolean deleteEvenement(int idEvn);
    
    boolean updateEvenement(Evenement evn);
        
    public List<Evenement> displayEvenement();
    
    public List<Evenement> displayChallengeByEvenement(int idEvn);
    
    public Evenement getEvenementByid(int id);
    
    public Evenement getEvenementByNom(String nom);
}
