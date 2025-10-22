package sum25.se183036.pehsf302trialexamse183036.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;
import sum25.se183036.pehsf302trialexamse183036.repository.SonyAccountsRepository;

@Service
public class SonyAccountsServiceImpl implements SonyAccountsService {
    @Autowired
    private SonyAccountsRepository sonyAccountsRepository;

    @Override
    public SonyAccounts getSonyAccounts(String phone, String password) {
        return sonyAccountsRepository.findByPhoneAndPassword(phone, password);
    }

    @Override
    public boolean addSonyAccounts(SonyAccounts account) {
        return sonyAccountsRepository.save(account) != null;
    }

    @Override
    public boolean checkRole(String phone) {
        SonyAccounts account = sonyAccountsRepository.findByPhone(phone);
        if (account != null) {
            return account.getRoleId() == 1 || account.getRoleId() == 2;
        }
        return false;
    }
}
