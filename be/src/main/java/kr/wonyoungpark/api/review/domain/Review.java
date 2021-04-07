package kr.wonyoungpark.api.review.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import kr.wonyoungpark.api.exhibition.domain.Exhbn;
import kr.wonyoungpark.api.user.domain.UserVO;

import lombok.Getter;

import java.util.Date;

@Entity @Getter @Table(name = "reviews")
public class Review {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_num") private long reviewNum;
	@Column(name = "review_title") private String reviewTitle;
	@Column(name = "review_content") private String reviewContent;
	@Column(name = "reg_date") private Date regDate;
	@Column private String score;

	@JsonBackReference(value = "user")
	@ManyToOne
	@JoinColumn(name = "user_num")
	private UserVO user;

	@JsonBackReference(value = "exhbn")
	@ManyToOne
	@JoinColumn(name = "exhbn_num")
	private Exhbn exhbn;

	public void setReviewNum(long reviewNum) {
		this.reviewNum = reviewNum;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public void setExhbn(Exhbn exhbn) {
		this.exhbn = exhbn;
	}

	@Override
	public String toString() {
		return "Review{" +
				"reviewNum=" + reviewNum +
				", reviewTitle='" + reviewTitle + '\'' +
				", reviewContent='" + reviewContent + '\'' +
				", regDate=" + regDate +
				", score='" + score + '\'' +
				'}';
	}
}

/*
create table boards(
   board_num int primary key auto_increment,
   title varchar(30),
   content varchar(300),
   date varchar(20),
   id varchar(20)
   );*/