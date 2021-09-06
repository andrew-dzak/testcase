package domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@DynamicInsert
@Table(name= "event")
@Setter
public class Event {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "name")
    private String name;

    @Column(name =  "description")
    private String description;


    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "venue")
    private Point venue;

    @Column(name = "address")
    private String address;


    @Column(name = "created_on_date")
    private LocalDateTime createdOnDate;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "event")
    private Set<EventTicketCategory> eventTicketCategories = new HashSet<>();

    protected Event() {
    }
}
