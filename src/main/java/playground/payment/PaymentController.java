package playground.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentRepository payments;

    @GetMapping
    public Iterable<Payment> list() {
        return this.payments.findAll();
    }

    @GetMapping("/{geoPartition}")
    public Iterable<Payment> listByGeoPartition(@PathVariable String geoPartition) {
        return this.payments.findAllByGeoPartition(geoPartition);
    }

}
