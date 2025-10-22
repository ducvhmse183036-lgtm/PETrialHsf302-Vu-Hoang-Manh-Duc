package sum25.se183036.pehsf302trialexamse183036.service;

import org.springframework.stereotype.Service;
import sum25.se183036.pehsf302trialexamse183036.entity.SonyAccounts;

@Service
public interface SonyAccountsService {
    public SonyAccounts getSonyAccounts(String phone, String password);

    public boolean addSonyAccounts(SonyAccounts account);
    public boolean checkRole(String phone);
}
