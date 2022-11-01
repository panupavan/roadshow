package com.yesbank;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import net.sf.portletunit2.PortletUnitTestCase;
import org.junit.Test;

/**
 *
 * @author Matthew O. Smith
 */
public class MyPortletTest extends PortletUnitTestCase {

    public MyPortletTest() {
        super("webappyesbank");
    }

    /**
     * Test of doView method, of class MyPortlet.
     */
    @Test
    public void testDoView() throws Exception {
       
        renderPortlet();
        assertTextPresent("Welcome to the Maven 2 World");
    }


    /**
     * Test of maximized, of class MyPortlet.
     */
    @Test
    public void testDoViewMaximized() throws Exception {

        renderPortlet(WindowState.MAXIMIZED);
        assertTextPresent("This is a much bigger world isn't it?");
    }

    /**
     * Test of minimized by ensuring that none of the text for any
     * of the portlet modes or windows states is present.
     */
    @Test
    public void testDoViewMinimized() throws Exception {

        renderPortlet(WindowState.MINIMIZED);
        assertTextNotPresent("This is a much bigger world isn't it?");
        assertTextNotPresent("Need help?");
        assertTextNotPresent("Welcome to the Maven 2 World");
    }

    /**
     * Test of doHelp method, of class MyPortlet.
     */
    @Test
    public void testHelp() throws Exception {

        renderPortlet(PortletMode.HELP);
        assertTextPresent("Need help?");
    }
}
