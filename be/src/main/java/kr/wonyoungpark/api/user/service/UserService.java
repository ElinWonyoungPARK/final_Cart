package kr.wonyoungpark.api.user.service;

import kr.wonyoungpark.api.user.domain.UserVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    String save(UserVo userVo);
    List<UserVo> all();
    Optional<UserVo> one(long id);
    String edit(UserVo userVo);
    String delete(long id);
    public String signup(UserVo user);
    public void delete(String username);
    public Map<String, Object> signin(String username, String password);
    public UserVo search(String username);
    public UserVo whoami(HttpServletRequest req);
    public String refresh(String username);
}
