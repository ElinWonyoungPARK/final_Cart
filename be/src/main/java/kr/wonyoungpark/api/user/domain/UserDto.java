package kr.wonyoungpark.api.user.domain;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import kr.wonyoungpark.api.analysis.domain.Analysis;
import kr.wonyoungpark.api.booking.domain.Booking;
import kr.wonyoungpark.api.review.domain.Review;
import lombok.Data;
@Data
public class UserDto {
    @ApiModelProperty(position = 0)
    private String username;
    @ApiModelProperty(position = 1)
    private String email;
    @ApiModelProperty(position = 2)
    private String password;
    @ApiModelProperty(position = 3)
    List<Role> roles;
    private long userNum;
    private String name;
    private String gender;
    private String birthday;
    private String phoneNumber;
    private String admin;
    private String preferGenre;
    private List<Review> reviews;
    private List<Analysis> analyses;
    private List<Booking> bookings;
}
