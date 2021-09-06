package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Entity
@Setter
@Table(name= "fee")
public class Fee {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "min_band")
    private BigDecimal minBand;

    @Column(name = "max_band")
    private BigDecimal maxBand;

    @Column(name = "fee_amount")
    private BigDecimal feeAmount;


    protected Fee() {
    }
}
