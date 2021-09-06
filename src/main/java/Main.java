
import domain.Event;
import domain.EventTicketCategory;
import domain.Fee;
import org.hibernate.reactive.stage.Stage;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testcase-pu");
        Stage.SessionFactory sessionFactory =emf.unwrap(Stage.SessionFactory.class);


        Long id = 1L;

        Event event = sessionFactory.withSession(session -> session.find(Event.class,id)).toCompletableFuture().join();
        Fee fee   = sessionFactory.withSession(session -> session.find(Fee.class,id)).toCompletableFuture().join();


        BigDecimal price = new BigDecimal(12);
        final String referenceCode = java.util.UUID.randomUUID().toString();
        final LocalDateTime startDateTime = LocalDateTime.parse(LocalDateTime.now().toString());
        final LocalDateTime endDateTime   = LocalDateTime.parse(LocalDateTime.now().toString());
        String description = " test case desc";

        EventTicketCategory eventTicketCategory = new EventTicketCategory("test case",price,startDateTime,endDateTime ,referenceCode,description,10,
                new BigDecimal(1),fee);

        eventTicketCategory.setEvent(event);

        event.getEventTicketCategories().add(eventTicketCategory);

        try{
            Event saveEvent = sessionFactory.withTransaction((session,tx) ->  session.merge(event))
                    .toCompletableFuture().join();
        }catch (Exception e){
            System.out.print(e.getCause().toString());
        }

    }

}
