
package com.esprit.pidev.models.entities;

import java.util.Objects;

public class Reclamation {
    
   private String descriptionReclamation ;
   private EtatDemande etatDemandeReclamation ;
   private String identifiantReclamation ;

    public Reclamation(String descriptionReclamation, EtatDemande etatDemandeReclamation,String identifiantReclamation) {
        this.descriptionReclamation = descriptionReclamation;
        this.etatDemandeReclamation = etatDemandeReclamation;
        this.identifiantReclamation= identifiantReclamation;
    }

    public Reclamation() {
    }

   
   
    public String getDescriptionReclamation() {
        return descriptionReclamation;
    }

    public void setDescriptionReclamation(String descriptionReclamation) {
        this.descriptionReclamation = descriptionReclamation;
    }

    public EtatDemande getEtatDemandeReclamation() {
        return etatDemandeReclamation;
    }

    public void setEtatDemandeReclamation(EtatDemande etatDemandeReclamation) {
        this.etatDemandeReclamation = etatDemandeReclamation;
    }

    public String getIdentifiantReclamation() {
        return identifiantReclamation;
    }

    public void setIdentifiantReclamation(String identifiantReclamation) {
        this.identifiantReclamation = identifiantReclamation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.identifiantReclamation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.identifiantReclamation, other.identifiantReclamation)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Reclamation{" + "descriptionReclamation=" + descriptionReclamation + ", etatDemandeReclamation=" + etatDemandeReclamation +" IdentifiantReclamation"+identifiantReclamation+" '}'";
    }
    
    
}
