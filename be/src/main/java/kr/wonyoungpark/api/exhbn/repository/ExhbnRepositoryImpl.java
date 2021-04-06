package kr.wonyoungpark.api.exhbn.repository;


import javax.persistence.EntityManager;

import kr.wonyoungpark.api.exhbn.domain.Exhbn;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;


@Repository
public class ExhbnRepositoryImpl extends QuerydslRepositorySupport implements ExhbnCustomRepository {

    //private final JPAQueryFactory qf;
    private final EntityManager em;
    public ExhbnRepositoryImpl(EntityManager em) {
        super(Exhbn.class);
        //this.qf = qf;
        this.em = em;
    }
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Exhbn> findByExhbnNum(long exhbnNum) {
//		return em.createQuery("select e from Exhbn e where e.exhbn_num like :exhbnNum")
//					.setParameter("exhbnNum", exhbnNum)
//					.getResultList();
//	}

}
