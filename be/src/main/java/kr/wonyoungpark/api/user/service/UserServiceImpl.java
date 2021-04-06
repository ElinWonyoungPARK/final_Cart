package kr.wonyoungpark.api.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import kr.wonyoungpark.api.security.domain.SecurityProvider;
import kr.wonyoungpark.api.security.exception.SecurityRuntimeException;
import kr.wonyoungpark.api.user.domain.Role;
import kr.wonyoungpark.api.user.domain.UserVo;
import kr.wonyoungpark.api.user.repository.UserRepository;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final SecurityProvider provider;
    private final AuthenticationManager manager;

    @Override
    public String save(UserVo userVo) {
        System.out.println(("===2===:"+userVo.toString()));
        UserVo user = userRepo.save(userVo);
        return (user != null) ? "SUCCESS" : "FAILURE";
    }

    @Override
    public List<UserVo> all() {
        return userRepo.findAll();
    }

    @Override
    public Optional<UserVo> one(long id) {
        return userRepo.findById(id);
    }

    @Override
    public String edit(UserVo userVo) {
        UserVo user = userRepo.save(userVo);
        return (user != null) ? "SUCCESS" : "FAILURE";
    }

    @Override
    public String delete(long id) {
        userRepo.deleteById(id);
        return "SUCCESS";
    }

    @Override
    public Map<String, Object> signin(String username, String password) {
        try {
            //   manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Map<String, Object> map = new HashMap<>();
            System.out.println("ID:  "+username);
            UserVo user = userRepo.findByUsername(username);
            List<Role> roles = user.getRoles();
            String tok = provider.createToken(username, roles);
            map.put("token", provider.createToken(username, roles));
            map.put("user", user);
            System.out.println("token :: "+tok);
            return map;
        } catch (AuthenticationException e) {
            throw new SecurityRuntimeException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public String signup(UserVo user) {
        if (!userRepo.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            List<Role> roles = new ArrayList<>();
            roles.add(Role.USER);
            user.setRoles(roles);
            userRepo.save(user);
            return provider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public void delete(String username) {
        userRepo.deleteByUsername(username);
    }

    @Override
    public UserVo search(String username) {
        UserVo user = userRepo.findByUsername(username);
        if (user == null) {
            throw new SecurityRuntimeException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    @Override
    public UserVo whoami(HttpServletRequest req) {
        return userRepo.findByUsername(provider.getUsername(provider.resolveToken(req)));
    }

    @Override
    public String refresh(String username) {
        return provider.createToken(username, userRepo.findByUsername(username).getRoles());
    }
}