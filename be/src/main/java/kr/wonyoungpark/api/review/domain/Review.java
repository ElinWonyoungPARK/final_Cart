package kr.wonyoungpark.api.review.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kr.wonyoungpark.api.exhbn.domain.Exhbn;
import kr.wonyoungpark.api.user.domain.UserVo;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;

@Entity @Table(name = "reviews") @Data @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_num") long reviewNum;
    @Column(name = "review_title") String reviewTitle;
    @Column(name = "review_content") String reviewContent;
    @Column(name = "reg_date") String regDate;
    @Column String score;
    @ManyToOne
    @JoinColumn(name="user_num")
    private UserVo user;
    @ManyToOne
    @JoinColumn(name = "exhbn_num")
    private Exhbn exhbn;

}
