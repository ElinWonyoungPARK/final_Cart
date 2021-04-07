package kr.wonyoungpark.api.recommend.repository;

import kr.wonyoungpark.api.recommend.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

interface RecommendCustomRepository{
	
}
public interface RecommendRepository extends JpaRepository<Recommend, Long>, RecommendCustomRepository {

}
