package entities.core;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entities.users.Encrypting;
import entities.users.User;

@Entity
public class Ticket {

    private static final String DATE_FORMAT = "yyyyMMdd";

    @Id
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;

    @Column(unique = true, nullable = false)
    private String reference;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shopping> shoppingList;

    @ManyToOne
    @JoinColumn
    private User user;

    public Ticket() {
        created = Calendar.getInstance();
        created.set(Calendar.MILLISECOND, 0);
        reference = new Encrypting().encryptInBase64UrlSafe("" + this.getId() + Long.toString(new Date().getTime()));
        shoppingList = new ArrayList<>();
    }

    public Ticket(long id) {
        this();
        String date = new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTime());
        this.id = Long.parseLong(date + id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long simpleId(){
        return Long.parseLong(String.valueOf(id).substring(DATE_FORMAT.length()));
    }

    public void addShopping(Shopping shopping) {
        shoppingList.add(shopping);
    }

    public List<Shopping> getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(List<Shopping> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getCreated() {
        return created;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getTicketTotal() {
        double total = 0.0;
        for (Shopping shopping : shoppingList) {
            total += shopping.getShoppingTotal();
        }
        return new BigDecimal(total);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return (id == ((Ticket) obj).id);
    }

    @Override
    public String toString() {
        String createTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(created.getTime());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ticket[" + id + ": created=" + createTime + ", shoppingList=" + shoppingList);
        if (user != null) {
            stringBuilder.append(", userId=" + user.getId());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
