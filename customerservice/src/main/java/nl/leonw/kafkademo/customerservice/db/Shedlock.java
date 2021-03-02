package nl.leonw.kafkademo.customerservice.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

// This entity exist solely to have JPA create the appropriate table.
@Data
@NoArgsConstructor
@Table(name="shdlck")
@Entity
public class Shedlock {
    @NonNull
    @Id String name;

    @NonNull ZonedDateTime lock_until;
    @NonNull ZonedDateTime locked_at;
    @NonNull String locked_by;
}
