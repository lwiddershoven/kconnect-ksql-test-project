package nl.leonw.kafkademo.customerservice.sched;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.util.TimeZone;

import static net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider.Configuration.builder;

@Configuration
public class ShedlockConfig {

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(builder()
                .withTableName("shdlck")
                .withJdbcTemplate(new JdbcTemplate(dataSource))
                .withTimeZone(TimeZone.getDefault())
                .build());
    }
}
