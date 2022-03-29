package playground.payment;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "payment")
@Value
public class Payment implements Persistable<Long> {

    @Id
    Long id;

    Long accountId;

    BigDecimal amount;

    String geoPartition;

    @Override
    public boolean isNew() {
        return true;
    }

}
