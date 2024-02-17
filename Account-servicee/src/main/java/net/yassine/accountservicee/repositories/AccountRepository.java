package net.yassine.accountservicee.repositories;

import net.yassine.accountservicee.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
