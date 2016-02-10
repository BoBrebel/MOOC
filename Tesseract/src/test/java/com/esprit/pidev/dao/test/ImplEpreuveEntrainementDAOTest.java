package com.esprit.pidev.dao.test;

import com.esprit.pidev.models.daos.interfaces.DAOFactory;
import com.esprit.pidev.models.daos.interfaces.IEpreuveEntrainementDAO;
import com.esprit.pidev.models.entities.EpreuveEntrainement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class ImplEpreuveEntrainementDAOTest {

    public ImplEpreuveEntrainementDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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

    @Ignore
    @Test
    public void TEST_CREATE_EPREUVE_SHOULD_RETURN_TRUE() {
        IEpreuveEntrainementDAO iEpreuveEntrainementDAO = DAOFactory.getEpreuveEntrainementDAO();
        EpreuveEntrainement epreuveEntrainement = new EpreuveEntrainement();

    }
}
