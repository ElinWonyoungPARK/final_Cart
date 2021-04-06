package kr.wonyoungpark.api.user.domain;

import kr.wonyoungpark.api.analysis.domain.Analysis;
import kr.wonyoungpark.api.booking.domain.Booking;
import kr.wonyoungpark.api.review.domain.Review;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "users") @Data
public class UserVo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_num") long userNum;
    @Column String username;
    @Column String password;
    @Column String name;
    @Column String email;
    @Column String gender;
    @Column String birthday;
    @Column(name = "phone_number") String phoneNumber;
    @Column String admin;
    @Column(name = "prefer_genre") String preferGenre;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Analysis> analyses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    List<Role> roles;
}
