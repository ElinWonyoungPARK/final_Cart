package kr.wonyoungpark.api.review.service;


import kr.wonyoungpark.api.review.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    String save(Review review);
    List<Review> all();
    Optional<Review> one(long id);
    String edit(Review review);
    String delete(long id);
    List<Review> selectJoinAll();
}

