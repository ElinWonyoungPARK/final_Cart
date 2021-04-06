package kr.wonyoungpark.api.review.service;

import kr.wonyoungpark.api.review.domain.Review;
import kr.wonyoungpark.api.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepo;
    @Override
    public String save(Review review) {
        System.out.println(("===2===: "+review.toString()));
        Review rev = reviewRepo.save(review);
        return (rev != null) ? "SUCCESS" : "FAILURE";
    }

    @Override
    public List<Review> all() {
        return reviewRepo.findAll();
    }

    @Override
    public Optional<Review> one(long id) {
        return reviewRepo.findById(id);
    }

    @Override
    public String edit(Review review) {
        Review rev = reviewRepo.save(review);
        return (rev != null) ? "SUCCESS" : "FAILURE";
    }

    @Override
    public String delete(long id) {
        reviewRepo.deleteById(id);
        return "SUCCESS";
    }

    @Override
    public List<Review> selectJoinAll() {
        return null;
    }
}
