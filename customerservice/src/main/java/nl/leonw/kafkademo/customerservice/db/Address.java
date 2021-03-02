package nl.leonw.kafkademo.customerservice.db;

import lombok.*;

import javax.persistence.Embeddable;


@Data
@Builder
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address {
    @NonNull String streetName;
    @NonNull String houseNumber;
    @NonNull String city;
    @NonNull String country;
    @NonNull String zipCode;
}
