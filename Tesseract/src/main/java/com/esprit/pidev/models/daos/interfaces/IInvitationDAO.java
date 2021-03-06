package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Invitation;
import com.esprit.pidev.models.entities.Organisation;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IInvitationDAO {

    public boolean createInvitation(Invitation invitation) throws SQLException;

    public List<Invitation> displayInvitationByUserId(int idUtilisateur) throws SQLException;

    public List<Invitation> displayInvitationByOrganisationId(int idOrganisation) throws SQLException;

    public List<Invitation> getAllInvitations() throws SQLException;

}
