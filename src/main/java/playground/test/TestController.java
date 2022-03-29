package playground.test;

import com.yugabyte.ysql.LoadBalanceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final JdbcTemplate jdbcTemplate;

    @GetMapping
    public String print() {
        // Print the current number of connections per host
        LoadBalanceProperties.CONNECTION_MANAGER_MAP.values().stream().findFirst().orElseThrow().printHostToConnMap();
        // Return connected host name
        return this.jdbcTemplate.queryForObject("select current_setting('listen_addresses')", new SingleColumnRowMapper<>(String.class));
    }

}
