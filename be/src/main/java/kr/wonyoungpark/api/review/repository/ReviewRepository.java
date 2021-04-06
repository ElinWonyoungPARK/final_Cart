package kr.wonyoungpark.api.review.repository;


import kr.wonyoungpark.api.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface ReviewCustomRepository{

}
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewCustomRepository {

}
