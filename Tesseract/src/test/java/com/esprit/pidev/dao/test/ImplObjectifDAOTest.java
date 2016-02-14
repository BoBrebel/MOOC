package com.esprit.pidev.dao.test;

import com.esprit.pidev.models.daos.interfaces.DAOFactory;
import com.esprit.pidev.models.daos.interfaces.IObjectifDAO;
import com.esprit.pidev.models.entities.Chapitre;
import com.esprit.pidev.models.entities.Cours;
import com.esprit.pidev.models.entities.Objectif;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ImplObjectifDAOTest {
    
    public ImplObjectifDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Ignore
    @Test
    public void TEST_CREATE_OBJECTIF_SHOULD_RETURN_TRUE() throws SQLException {
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        Objectif objectif = new Objectif(1, 1, "objectif1", "desco", "f");
        boolean test = objectifDAO.createObjectif(objectif);
        assertTrue(test);
        
    }
    
    @Ignore
    @Test
    public void TEST_REMOVE_OBJECTIF_SHOULD_RETURN_TRUE() throws SQLException {
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        Objectif objectif = new Objectif(1, 1, "objectif1", "desco", "f");
        boolean test = objectifDAO.removeObjectif(objectif);
        assertTrue(test);
        
    }
    
    @Ignore
    @Test
    public void TEST_REMOVE_OBJECTIF_BY_NAME_SHOULD_RETURN_TRUE() throws SQLException {
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        boolean test = objectifDAO.removeObjectifByname("objectif1");
        assertTrue(test);
        
    }
    
    @Ignore
    @Test
    public void TEST_UPDATE_OBJECTIF_SHOULD_RETURN_TRUE() throws SQLException {
        
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        boolean test = objectifDAO.updateObjectif("objectif1", new Objectif(2, 1, "deux", "dess", "d"));
        assertTrue(test);
    }
    
    @Ignore
    @Test
    public void TEST_DISPLAY_OBJECTIFS_SHOULD_RETURN_LIST_OBJECTIFS() throws SQLException {
        
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        List<Objectif> test = objectifDAO.displayObjectifs();
        assertEquals(1, test.size());
    }

    @Ignore
    @Test
    public void TEST_GET_OBJECTIFS_BY_CHAPITRE_SHOULD_RETURN_LIST_OBJECTIFS() throws SQLException {
        
        IObjectifDAO objectifDAO = DAOFactory.getObjectifDAO();
        List<Objectif> test = objectifDAO.getObjectifByChapitre(new Chapitre(1, 1, "eee", 3, "erty", "ertyu"));
        assertEquals(1, test.size());
        
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
