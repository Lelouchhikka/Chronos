package com.itstep.trelloanalog.services;

import com.itstep.trelloanalog.entities.DbUser;
import com.itstep.trelloanalog.entities.Role;
import com.itstep.trelloanalog.repositories.RoleRepository;
import com.itstep.trelloanalog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        DbUser userdb=userRepository.findByEmail(email);
        UserDetails user = (UserDetails)new User(userdb.getEmail(),
                userdb.getPassword(), userdb.getRoles());
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return  user;
    }

    public DbUser findUserById(Long userId) {
        Optional<DbUser> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new DbUser());
    }

    public List<DbUser> allUsers() {
        return userRepository.findAll();
    }

    public boolean saveUser(DbUser user) {
        DbUser userFromDB = userRepository.findByEmail(user.getEmail());

        if (userFromDB != null) {
            return false;
        }

        user.setRoles(new ArrayList<Role>((Collection<? extends Role>) new Role("ADMIN","Administartor")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public List<DbUser> usergtList(Long idMin) {
        return em.createQuery("SELECT u FROM DbUser u WHERE u.id > :paramId", DbUser.class)
                .setParameter("paramId", idMin).getResultList();
    }
}
