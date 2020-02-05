package Lab;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {
    AddressBook findById (int id);

}
