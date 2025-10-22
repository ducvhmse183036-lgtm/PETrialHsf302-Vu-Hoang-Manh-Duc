package sum25.se183036.pehsf302trialexamse183036.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;

@Repository
public interface SonyAccountsRepository extends JpaRepository<SonyAccounts, Integer> {
    SonyAccounts findByPhoneAndPassword(String phone, String password);
    SonyAccounts findByPhone(String phone);
}
