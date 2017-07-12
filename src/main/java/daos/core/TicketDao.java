package daos.core;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import entities.core.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long> {

    public Ticket findFirstByOrderByCreatedDescIdDesc();
    
    public Ticket findFirstByReference(String reference);
    
   public Page<Ticket> findByUserMobile(long mobile, Pageable pageable);

    public List<Ticket> findByCreatedGreaterThan(Calendar date);
}
