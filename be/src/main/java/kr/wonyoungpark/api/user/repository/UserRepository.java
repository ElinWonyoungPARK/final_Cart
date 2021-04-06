package kr.wonyoungpark.api.user.repository;

import kr.wonyoungpark.api.user.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

interface UserCustomRepository {

}
@Repository
public interface UserRepository extends JpaRepository<UserVo, Long>, UserCustomRepository {
    boolean existsByUsername(String username);
    UserVo findByUsername(String username);
    @Transactional
    void deleteByUsername(String username);
}
