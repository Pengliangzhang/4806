package Lab;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {
    List<BuddyInfo> findByPhoneNum(int phoneNum);
    List<BuddyInfo> findByname (String name);
    BuddyInfo getById(int i);
}
