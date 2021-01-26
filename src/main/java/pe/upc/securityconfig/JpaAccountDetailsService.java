package pe.upc.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.entity.Account;
import pe.upc.entity.Role;
import pe.upc.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaAccountDetailsService  implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = accountRepository.findByUserName(userName);

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return new User(account.getUserName(), account.getPassword(), account.getEnabled(), true, true, true, authorities);
    }
}
