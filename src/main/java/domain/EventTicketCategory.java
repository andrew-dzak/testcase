package domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="event_ticket_category")
@Setter
@DynamicInsert
public class EventTicketCategory {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinColumn(name =  "event_id", nullable = false)
    private Event event;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "reference_code")
    private String referenceCode;

    @Column(name = "description")
    private String description;

    @Column(name = "number_of_tickets")
    private Integer numberOfTickets;

    @Column(name = "created_on_date")
    private LocalDateTime createdOnDate;

    @Column(name = "discount", nullable = true)
    private BigDecimal discount;

    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name =  "fee_id", nullable = true)
    private Fee fee;


    protected EventTicketCategory() {
    }

    public EventTicketCategory(String title, BigDecimal price, LocalDateTime startDate, LocalDateTime endDate,
            String referenceCode, String description, Integer numberOfTickets, BigDecimal discount, Fee fee) {
        this.title = title;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.referenceCode = referenceCode;
        this.description = description;
        this.numberOfTickets = numberOfTickets;
        this.discount = discount;
        this.fee = fee;
    }
}
