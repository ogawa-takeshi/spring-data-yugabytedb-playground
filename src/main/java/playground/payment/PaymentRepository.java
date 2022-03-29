package playground.payment;

import com.yugabyte.data.jdbc.repository.YsqlRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentRepository extends YsqlRepository<Payment, Long> {

    @Transactional(readOnly = true)
    Iterable<Payment> findAllByGeoPartition(String geoPartition);

}
