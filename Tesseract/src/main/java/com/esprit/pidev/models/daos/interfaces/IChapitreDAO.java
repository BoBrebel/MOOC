package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Chapitre;
import javafx.collections.ObservableList;


public interface IChapitreDAO {
    
    public boolean addrChapitre(Chapitre c);
    
    public boolean deleteChapitre(int id);
    
    public boolean updateChapitre(Chapitre c);
    
    public ObservableList<Chapitre> displayChapitre(int idCours);
    
    public Chapitre searchChapitre(String nom, int idCours);
}
