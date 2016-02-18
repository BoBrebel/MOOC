package com.esprit.pidev.models.daos.interfaces;

import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Matiere;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

public interface ICoursDAO {

    public boolean AjouterCours(Cours c1, Matiere m1) throws SQLException;

    public boolean deleteCoursById(int idCours) throws SQLException;

    public boolean updateCours(Cours c1, Matiere m1) throws SQLException;

    public ObservableList<Cours> findAll() throws SQLException;

    public Cours findCoursById(int idCours) throws SQLException;

    public List<Cours> findCoursByIdFromateur(int idFormateur) throws SQLException;

    public List<Cours> findCoursByMatiere(Matiere m1) throws SQLException;
}
