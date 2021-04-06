package kr.wonyoungpark.api.booking.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kr.wonyoungpark.api.exhbn.domain.Exhbn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kr.wonyoungpark.api.user.domain.UserVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity @Data @Table(name = "bookings") @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Booking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_num") private long bookNum;
    @Column(name = "book_date") private String bookDate;
    @Column(name = "total_price") private String totalPrice;
    @Column(name = "book_name") private String bookName;
    @Column(name = "book_email") private String bookEmail;
    @Column(name = "book_pnumber") private String bookPnumber;

    @ManyToOne
    @JoinColumn(name = "user_num")
    private UserVo user;

    @ManyToOne
    @JoinColumn(name = "exhbn_num")
    private Exhbn exhbn;
}
