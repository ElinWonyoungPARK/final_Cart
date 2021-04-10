package kr.wonyoungpark.api.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.wonyoungpark.api.user.domain.QUserVO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import kr.wonyoungpark.api.user.domain.UserVO;

import static kr.wonyoungpark.api.user.domain.QUserVO.userVO;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserCustomRepository{
	private final JPAQueryFactory qf;
	public UserRepositoryImpl(JPAQueryFactory qf) {
		super(UserVO.class);
		this.qf = qf;
	}
	@Override
	public UserVO checkId(String id) {
		return qf.selectFrom(userVO)
				.where(userVO.username.eq(id))
				.fetchOne();
	}
	@Override
	public UserVO checkEmail(String email) {
		return qf.selectFrom(userVO)
				.where(userVO.email.eq(email))
				.fetchOne();
	}
}
