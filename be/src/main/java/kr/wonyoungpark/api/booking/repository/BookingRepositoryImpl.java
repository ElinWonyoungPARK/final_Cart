package kr.wonyoungpark.api.booking.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import kr.wonyoungpark.api.booking.domain.Booking;

@Repository
public class BookingRepositoryImpl extends QuerydslRepositorySupport implements BookingCustomRepository{
	//private final JPAQueryFactory qf;
	private final EntityManager em;
	public BookingRepositoryImpl(EntityManager em) {
		super(Booking.class);
		//this.qf = qf;
		this.em = em;
	}

}
