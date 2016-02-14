package com.esprit.pidev.dao.test;

import com.esprit.pidev.models.daos.interfaces.DAOFactory;
import com.esprit.pidev.models.daos.interfaces.IChapitreDAO;
import com.esprit.pidev.models.entities.Chapitre;
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
 * @author Noor
 */
public class ImplChapitreDAOTest {

    public ImplChapitreDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Ignore
    @Test
    public void TEST_CREATE_CHAPITRE_SHOULD_RETURN_TRUE() throws SQLException {
        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        Chapitre chapitre = new Chapitre(1, 1, "chap1", 1, "bla", "resres");
        boolean test = chapitreDAO.createChapitre(chapitre);
        assertTrue(test);

    }

    @Ignore
    @Test
    public void TEST_REMOVE_CHAPITRE_SHOULD_RETURN_TRUE() throws SQLException {
        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        Chapitre chapitre = new Chapitre(1, 1, "chap1", 1, "bla", "resres");
        boolean test = chapitreDAO.removeChapitre(chapitre);
        assertTrue(test);
    }

    @Ignore
    @Test
    public void TEST_REMOVE_CHAPITRE_BY_NAME_SHOULD_RETURN_TRUE() throws SQLException {
        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        boolean test = chapitreDAO.removeChapitreByName("chap1");
        assertTrue(test);
    }

    @Ignore
    @Test
    public void TEST_UPDATE_CHAPITRE_SHOULD_RETURN_TRUE() throws SQLException {

        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        boolean test = chapitreDAO.updateChapitre("chap1", new Chapitre(2, 1, "chap2", 2, "desc", "rees"));
        assertTrue(test);
    }

    @Ignore
    @Test
    public void TEST_DISPLAY_CHAPITRES_SHOULD_RETURN_LIST_CHAPITRES() throws SQLException {

        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        List<Chapitre> test = chapitreDAO.displayChapitres();
        assertEquals(1, test.size());
    }
    
    // @Ignore
    @Test
    public void TEST_GET_CHAPITRE_BY_NAME_SHOULD_RETURN_LIST_CHAPITRES() throws SQLException {

        IChapitreDAO chapitreDAO = DAOFactory.getChapitreDAO();
        Chapitre chapitre=chapitreDAO.getChapitreByName("chap1");
        assertNotNull(chapitre);
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

  
}
