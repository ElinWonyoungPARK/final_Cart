package kr.wonyoungpark.api.user.service;

import kr.wonyoungpark.api.security.domain.SecurityProvider;
import kr.wonyoungpark.api.security.exception.SecurityRuntimeException;
import kr.wonyoungpark.api.user.domain.Role;
import kr.wonyoungpark.api.user.domain.UserVO;
import kr.wonyoungpark.api.user.repository.UserRepository;
import lombok.Getter;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
@Getter
public class UserServiceImpl implements UserService{
	private final UserRepository userRepo;
	private final PasswordEncoder passwordEncoder;
	private final SecurityProvider provider;
	private final AuthenticationManager manager;

	@Override
	public String save(UserVO userVo) {
		System.out.println(("===2===:"+userVo.toString()));
		UserVO user = userRepo.save(userVo);
		return (user != null) ? "SUCCESS" : "FAILURE";
	}

	@Override
	public List<UserVO> all() {
		return userRepo.findAll();
	}

	@Override
	public Optional<UserVO> one(long id) {
		return userRepo.findById(id);
	}

	@Override
	public String edit(UserVO userVo) {
		UserVO user = userRepo.save(userVo);
		return (user != null) ? "SUCCESS" : "FAILURE";
	}

	@Override public boolean checkId(String id) {
		return (userRepo.checkId(id) != null ? true : false); }

	@Override public boolean checkEmail(String email) {
		return (userRepo.checkEmail(email) != null ? true : false); }

	@Override
	public String delete(long id) {
		System.out.print(">>>>>>> MMM>>>>>>>>>"+id);
		userRepo.deleteById(id);
		return "SUCCESS";
	}

	@Override
	public Map<String, Object> signin(String username, String password) {
		try {
			//   manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			Map<String, Object> map = new HashMap<>();
			System.out.println("ID:  "+username);
			UserVO user = userRepo.findByUsername(username);
			List<Role> roles = user.getRoles();
			String tok = provider.createToken(username, roles);
			System.out.println("token :: "+tok);
			map.put("token", tok);
			map.put("user", user);
			return map;
		} catch (AuthenticationException e) {
			throw new SecurityRuntimeException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@Override
	public String signup(UserVO user) {
		if (!userRepo.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Role> roles = new ArrayList<>();
			roles.add(Role.USER);
			// user.setRoles(roles);
			userRepo.save(user);
			return provider.createToken(user.getUsername(), roles);
		} else {
			throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public UserVO search(String username) {
		UserVO user = userRepo.findByUsername(username);
		if (user == null) {
			throw new SecurityRuntimeException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}
	@Override
	public UserVO whoami(HttpServletRequest req) {
		return userRepo.findByUsername(provider.getUsername(provider.resolveToken(req)));
	}
	@Override
	public String refresh(String username) {
		return provider.createToken(username, userRepo.findByUsername(username).getRoles());
	}
}