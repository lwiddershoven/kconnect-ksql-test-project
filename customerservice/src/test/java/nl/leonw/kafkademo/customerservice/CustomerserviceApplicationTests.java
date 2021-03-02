package nl.leonw.kafkademo.customerservice;

import nl.leonw.kafkademo.customerservice.db.Address;
import nl.leonw.kafkademo.customerservice.db.Customer;
import nl.leonw.kafkademo.customerservice.db.CustomerRepository;
import nl.leonw.kafkademo.customerservice.db.Metadata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.IconUIResource;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerserviceApplicationTests {


    @Autowired
    private CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    void loadAndSaveWorks() {
        var customer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .email("a@b.c")
                .firstName("a")
                .lastName("a")
                .address(Address.builder()
                        .streetName("a")
                        .houseNumber("a")
                        .city("a")
                        .country("a")
                        .zipCode("a")
                        .build()
                )
                .metadata(Metadata.builder()
                        .active(true)
                        .created(ZonedDateTime.now())
                        .modified(ZonedDateTime.now())
                    .build()
                )
                .build();

        var savedCustomer = repo.save(customer);
        assertNotSame(customer, savedCustomer); // we're supposed to get a managed entity back - a different instance.

        var loadedCustomerOpt = repo.findById(customer.getId());
        assertEquals(Optional.of(customer), loadedCustomerOpt);
        assertEquals(loadedCustomerOpt.orElseThrow(), savedCustomer); // we get the same managed instance back.
    }

}
