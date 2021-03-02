package nl.leonw.kafkademo.customerservice.db;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Metadata {
    @NonNull ZonedDateTime created;
    @NonNull ZonedDateTime modified;
    @NonNull Boolean active;
}
