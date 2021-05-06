package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.Role;
import web.models.User;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByName(s);
        return new org.springframework.security.core.userdetails.User("v", "v", getAuthority(user.getRoles()));
    }

    private Set<GrantedAuthority> getAuthority(Set<Role> roles) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for(Role role : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return grantedAuthoritySet;
    }
}
