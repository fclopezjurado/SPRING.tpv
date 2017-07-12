package wrappers;

import entities.core.Shopping;
import entities.core.Ticket;

public class DayTicketWrapper {

    private long id;

    private String reference;

    private double total;

    public DayTicketWrapper() {
    }

    public DayTicketWrapper(Ticket ticket) {
        this.id = ticket.getId();

        this.reference = ticket.getReference();

        this.total = 0;
        if (ticket.getShoppingList() != null) {
            for (Shopping shopping : ticket.getShoppingList()) {
                this.total += shopping.getShoppingTotal();
            }
        }
    }

    public long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "DayTicketWrapper [reference=" + reference + ", total=" + total + "]";
    }

}
