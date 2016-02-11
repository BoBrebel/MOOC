package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.daos.interfaces.implementations.ImplAdministrateurDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplAppreantDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplBanForumDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplChallengeDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplChapitreDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplCommentaireCoursDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplCommentaireForumDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplCoursDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveEntrainementDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveFinalDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplEpreuveObjectifDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplFormateurDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplInvitationDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplLogDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplMatiereDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplMembreCPDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplNotificationDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplObjectifDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplOrganisationDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplQuestionDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplReclamationDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplReponseDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplSessionCoursDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplSessionEpreuveDAO;
import com.esprit.pidev.models.daos.interfaces.implementations.ImplSujetForumDAO;

public interface DAOFactory {

    public static IAdministrateurDAO getAdministrateurDAO() {
        return new ImplAdministrateurDAO();
    }

    public static ISessionEpreuveDAO getSessionEpreuveDAO() {
        return new ImplSessionEpreuveDAO();
    }

    public static IFormateurDAO getFormateurDAO() {
        return new ImplFormateurDAO();
    }

    public static IMembreCPDAO getMembreCPDAO() {
        return new ImplMembreCPDAO();
    }

    public static IBanForumDAO getBanForumDAO() {
        return new ImplBanForumDAO();
    }

    public static IChallengeDAO getChallengeDAO() {
        return new ImplChallengeDAO();
    }

    public static IChapitreDAO getChapitreDAO() {
        return new ImplChapitreDAO();
    }

    public static ICommentaireCoursDAO getCommentaireCoursDAO() {
        return new ImplCommentaireCoursDAO();
    }

    public static ICommentaireForumDAO getCommentaireForumDAO() {
        return new ImplCommentaireForumDAO();
    }

    public static IInvitationDAO getInvitationDAO() {
        return new ImplInvitationDAO();
    }

    public static ILogDAO getLogDAO() {
        return new ImplLogDAO();
    }

    public static IAdministrateurDAO getMatiereDAO() {
        return new ImplAdministrateurDAO();
    }

    public static INotificationDAO getNotificationDAO() {
        return new ImplNotificationDAO();
    }

    public static IObjectifDAO getObjectifDAO() {
        return new ImplObjectifDAO();
    }

    public static IOrganisationDAO getOrganisationDAO() {
        return new ImplOrganisationDAO();
    }

    public static IQuestionDAO getQuestionDAO() {
        return new ImplQuestionDAO();
    }

    public static IReclamationDAO getReclamationDAO() {
        return new ImplReclamationDAO();
    }

    public static IReponseDAO getReponseDAO() {
        return new ImplReponseDAO();
    }

    public static ISessionCoursDAO getSessionCoursDAO() {
        return new ImplSessionCoursDAO();
    }

    public static ISujetForumDAO getSujetCoursDAO() {
        return new ImplSujetForumDAO();
    }

    public static IApprenantDAO getApprenantDAO() {
        return new ImplAppreantDAO();
    }

    public static IEpreuveEntrainementDAO getEpreuveEntrainementDAO() {
        return new ImplEpreuveEntrainementDAO();
    }

    public static IEpreuveFinalDAO getEpreuveFinalDAO() {
        return new ImplEpreuveFinalDAO();
    }

    public static IEpreuveObjectifDAO getEpreuveObjectifDAO() {
        return new ImplEpreuveObjectifDAO();
    }

    public static ICoursDAO getCoursDAO() {
        return new ImplCoursDAO();
    }

  

}
