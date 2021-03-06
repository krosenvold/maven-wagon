package org.apache.maven.wagon.events;

import junit.framework.TestCase;
import org.apache.maven.wagon.Wagon;
import org.apache.maven.wagon.providers.file.FileWagon;

/**
 * @author <a href="michal.maczka@dimatics.com">Michal Maczka</a>
 * @version $Id$
 */
public class SessionEventSupportTest extends TestCase
{

    private SessionEventSupport eventSupport;


    /**
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {

        super.setUp();
        eventSupport = new SessionEventSupport();


    }

    public void testSessionListenerRegistration()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        assertTrue( eventSupport.hasSessionListener( mock1 ) );
        final MockSessionListener mock2 = new MockSessionListener();

        assertFalse( eventSupport.hasSessionListener( mock2 ) );

        eventSupport.addSessionListener( mock2 );

        assertTrue( eventSupport.hasSessionListener( mock1 ) );
        assertTrue( eventSupport.hasSessionListener( mock2 ) );

        eventSupport.removeSessionListener( mock2 );

        assertTrue( eventSupport.hasSessionListener( mock1 ) );
        assertFalse( eventSupport.hasSessionListener( mock2 ) );

        eventSupport.removeSessionListener( mock1 );
        assertFalse( eventSupport.hasSessionListener( mock1 ) );
    }

    public void testFireSessionDisconnected()
    {

        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon, 1 );

        eventSupport.fireSessionDisconnected( event );

        assertTrue( mock1.isSessionDisconnectedCalled() );
        assertTrue( mock2.isSessionDisconnectedCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );

    }

    public void testFireSessionDisconneting()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon,  1 );

        eventSupport.fireSessionDisconnecting( event );

        assertTrue( mock1.isSessionDisconnectingCalled() );
        assertTrue( mock2.isSessionDisconnectingCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );
    }

    public void testFireSessionLoggedIn()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon, 1 );

        eventSupport.fireSessionLoggedIn( event );

        assertTrue( mock1.isSessionLoggedInCalled() );
        assertTrue( mock2.isSessionLoggedInCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );

    }

    public void testFireSessionLoggedOff()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon, 1 );

        eventSupport.fireSessionLoggedOff( event );

        assertTrue( mock1.isSessionLoggedOffCalled() );
        assertTrue( mock2.isSessionLoggedOffCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );
    }

    public void testFireSessionOpened()
    {

        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon, 1 );

        eventSupport.fireSessionOpened( event );

        assertTrue( mock1.isSessionOpenedCalled() );
        assertTrue( mock2.isSessionOpenedCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );

    }

    public void testFireSessionOpenning()
    {

        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon,  1 );

        eventSupport.fireSessionOpening( event );

        assertTrue( mock1.isSessionOpenningCalled() );
        assertTrue( mock2.isSessionOpenningCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );

    }

    public void testFireSessionRefused()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        final Wagon wagon = new FileWagon();
        final SessionEvent event = new SessionEvent( wagon,  1 );

        eventSupport.fireSessionConnectionRefused( event );

        assertTrue( mock1.isSessionRefusedCalled() );
        assertTrue( mock2.isSessionRefusedCalled() );
        assertEquals( event, mock1.getSessionEvent() );
        assertEquals( event, mock2.getSessionEvent() );
    }

    public void testFireDebug()
    {
        final MockSessionListener mock1 = new MockSessionListener();
        eventSupport.addSessionListener( mock1 );

        final MockSessionListener mock2 = new MockSessionListener();
        eventSupport.addSessionListener( mock2 );

        eventSupport.fireDebug( "mm" );

        assertTrue( mock1.isDebugCalled() );
        assertTrue( mock2.isDebugCalled() );
        assertEquals( "mm", mock1.getDebugMessage() );
        assertEquals( "mm", mock2.getDebugMessage() );

    }

}
