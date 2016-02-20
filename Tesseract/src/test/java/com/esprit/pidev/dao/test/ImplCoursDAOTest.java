package com.esprit.pidev.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.esprit.pidev.models.daos.interfaces.DAOFactory;
import com.esprit.pidev.models.daos.interfaces.ICoursDAO;
import com.esprit.pidev.models.daos.interfaces.IMatiereDAO;

import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Matiere;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Sameh
 */

public class ImplCoursDAOTest {

    public ImplCoursDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Ignore
    @Test
    public void TEST_CREATE_COURS_SHOULD_RETURN_TRUE_IF_SUCCESS() throws SQLException, Exception {
        Matiere matiere = new Matiere(1, "haikel", "yassmine");
        ICoursDAO coursDao = DAOFactory.getCoursDAO();
        Cours cours = new Cours(2,"java", " ",null, "",25, "certView",1);
        boolean test = coursDao.AjouterCours(cours);
        assertTrue(test);

    }

    @Ignore
    @Test
    public void TEST_GET_COURS_BY_ID_SHOULD_RETURN_COURS() throws SQLException, Exception {
        Matiere matiere = new Matiere(1, "haikel", "yassmine");
        ICoursDAO coursDao = DAOFactory.getCoursDAO();
        Cours cours = new Cours(1,"java", " ",null, "",25, "certView",1);
        Cours test = coursDao.findCoursById(1);
        assertNotNull(test);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
