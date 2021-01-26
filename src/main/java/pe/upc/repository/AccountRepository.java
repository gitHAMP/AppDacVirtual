package pe.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.entity.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long> {
    Account findByUserName(String userName);
}
