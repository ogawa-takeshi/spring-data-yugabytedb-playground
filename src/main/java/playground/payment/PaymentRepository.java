package playground.payment;

import com.yugabyte.data.jdbc.repository.YsqlRepository;

public interface PaymentRepository extends YsqlRepository<Payment, Long> {

    Iterable<Payment> findAllByGeoPartition(String geoPartition);

}
