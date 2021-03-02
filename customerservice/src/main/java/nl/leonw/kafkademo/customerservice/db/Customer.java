package nl.leonw.kafkademo.customerservice.db;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor // Builder requires allargs constructor
@Entity
@NoArgsConstructor // entity requires noargs constructor
public class Customer {
    @Id
    String id;
    @NonNull String firstName;
    @NonNull String lastName;
    @NonNull String email;
    @NonNull Address address;
    @NonNull Metadata metadata;
}
