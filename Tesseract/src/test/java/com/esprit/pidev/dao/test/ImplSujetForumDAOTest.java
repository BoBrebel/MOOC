package com.esprit.pidev.dao.test;

import com.esprit.pidev.models.daos.interfaces.DAOFactory;
import com.esprit.pidev.models.daos.interfaces.ISujetForumDAO;
import com.esprit.pidev.models.entities.SujetForum;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class ImplSujetForumDAOTest {

    public ImplSujetForumDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Ignore
    @Test
    public void TEST_CREATE_SUJET_FORUM_SHOULD_RETURN_TRUE() throws SQLException {
        ISujetForumDAO sujetForumDAO = DAOFactory.getSujetCoursDAO();
        SujetForum forum = new SujetForum(1, 0, "yui", "fghj", new Date(20));
        boolean test = sujetForumDAO.createSujetForum(forum, 1);
        assertTrue(test);

    }

    @Ignore
    @Test
    public void TEST_GET_SUJET_FORUM_BY_USER_ID_SHOULD_RETURN_TRUE() throws SQLException {
        ISujetForumDAO sujetForumDAO = DAOFactory.getSujetCoursDAO();
        List<SujetForum> forum = sujetForumDAO.getSujetForumByUserId(1);
        assertEquals(1, forum.size());

    }
    
    //@Ignore
    @Test
    public void TEST_UPDATE_SUJET_FORUM_SHOULD_RETURN_TRUE() throws SQLException {
        ISujetForumDAO sujetForumDAO = DAOFactory.getSujetCoursDAO();
        boolean test = sujetForumDAO.updateSujetForum(1, new SujetForum(1, 1, "2222", "fghj", new Date(20)));
         assertTrue(test);
        
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
