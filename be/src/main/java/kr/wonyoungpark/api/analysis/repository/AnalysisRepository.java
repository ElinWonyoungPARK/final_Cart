package kr.wonyoungpark.api.analysis.repository;

import kr.wonyoungpark.api.analysis.domain.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;

interface AnalysisCustomRepository{
	
}

public interface AnalysisRepository extends JpaRepository<Analysis, Long>, AnalysisCustomRepository {

}
