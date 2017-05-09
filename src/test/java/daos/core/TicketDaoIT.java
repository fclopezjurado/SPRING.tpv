package daos.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import entities.core.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class TicketDaoIT {

    @Autowired
    private TicketDao ticketDao;

    @Test
    public void testCount() {
        assertTrue(ticketDao.count() >= 5);
    }
    
    public void testFindFirstByOrderByCreatedDescIdDesc() {
        Ticket ticket = ticketDao.findFirstByOrderByCreatedDescIdDesc();
        assertEquals(5, ticket.getId());
    }
    
    public void testFindFirstByReference() {
        Ticket ticket = ticketDao.findAll().get(0);
        assertEquals(ticket, ticketDao.findFirstByReference(ticket.getReference()));
    }

}
