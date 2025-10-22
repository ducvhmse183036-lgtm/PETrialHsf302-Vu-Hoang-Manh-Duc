package sum25.se183036.pehsf302trialexamse183036.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "sony_accounts")
@AllArgsConstructor
@NoArgsConstructor
public class SonyAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "phone", length = 13)
    private String phone;
    @Column(name = "password", length = 10)
    private String password;
    @Column(name = "role_id")
    private int roleId;
}
