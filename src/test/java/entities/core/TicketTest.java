package entities.core;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class TicketTest {

    @Test
    public void testTicketLongTicketState() {
        Ticket ticket = new Ticket(666);
        assertTrue(ticket.getReference().length() > 20);

    }

    @Test
    public void testTicketId() {
        Ticket ticket = new Ticket(99999);
        assertEquals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + "99999", "" + ticket.getId());
    }

    @Test
    public void testSimpleId() {
        Ticket ticket = new Ticket(99999);
        assertEquals(99999, ticket.simpleId());
    }

}
