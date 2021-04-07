package kr.wonyoungpark.api.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.wonyoungpark.api.review.domain.Review;
import kr.wonyoungpark.api.review.domain.ReviewDTO;

interface ReviewCustomRepository{
	public List<ReviewDTO> findByUserNum(long UserNum);
}

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {
	
}
