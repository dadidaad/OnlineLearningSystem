/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import bean.ArticleBean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class ArticleBeanTest {
    
    public ArticleBeanTest() {
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

    /**
     * Test of getPulished method, of class ArticleBean.
     */
    @Test
    public void testGetPulished() {
        ArticleBean instance = new ArticleBean();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPulished method, of class ArticleBean.
     */
    @Test
    public void testSetPulished() {
        String title = "MO1";
        ArticleBean instance = new ArticleBean();
        instance.setPulished(title);
        String testtitle ="MO1";
        assertEquals(testtitle,instance.getPulished());
    }

    /**
     * Test of getId method, of class ArticleBean.
     */
    @Test
    public void testGetId() {
        ArticleBean instance = new ArticleBean();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    @Test
    public void testSetId() {
        
        int id = 0;
        ArticleBean instance = new ArticleBean();
        instance.setId(id);
        int testid =0;
        assertEquals(testid,instance.getId());
    }

    /**
     * Test of getTitle method, of class ArticleBean.
     */
    @Test
    public void testGetTitle() {
        ArticleBean instance = new ArticleBean();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class ArticleBean.
     */
    @Test
    public void testSetTitle() {
        String title = "ABC";
        ArticleBean instance = new ArticleBean();
        instance.setTitle(title);
        String testtitle ="ABC";
        assertEquals(testtitle,instance.getTitle());
    }

    /**
     * Test of getDescription method, of class ArticleBean.
     */
    @Test
    public void testGetDescription() {
         ArticleBean instance = new ArticleBean();
        String description = null;
        String result = instance.getDescription();
        assertEquals(description, result);
    }

    /**
     * Test of setDescription method, of class ArticleBean.
     */
    @Test
    public void testSetDescription() {
        String description = "ABC";
        ArticleBean instance = new ArticleBean();
        instance.setDescription(description);
        String testdescription ="ABC";
        assertEquals(testdescription,instance.getDescription());
    }

    /**
     * Test of getImage method, of class ArticleBean.
     */
    @Test
    public void testGetImage() {
         ArticleBean instance = new ArticleBean();
        String image = null;
        String result = instance.getDescription();
        assertEquals(image, result);
    }

    /**
     * Test of setImage method, of class ArticleBean.
     */
    @Test
    public void testSetImage() {
          String image = null;
        ArticleBean instance = new ArticleBean();
        instance.setTitle(image);
        String testimage =null;
        assertEquals(testimage,instance.getDescription());
    }

    /**
     * Test of getCreateName method, of class ArticleBean.
     */
    @Test
    public void testGetCreateName() {
          ArticleBean instance = new ArticleBean();
        String CreateName = null;
        String result = instance.getDescription();
        assertEquals(CreateName, result);
    }

    /**
     * Test of setCreateName method, of class ArticleBean.
     */
    @Test
    public void testSetCreateName() {
          String createname = "ABC";
        ArticleBean instance = new ArticleBean();
        instance.setCreateName(createname);
        String testcreatename ="ABC";
        assertEquals(testcreatename,instance.getCreateName());
    }

    /**
     * Test of toString method, of class ArticleBean.
     */
    
}
