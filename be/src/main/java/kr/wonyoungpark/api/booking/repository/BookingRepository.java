package kr.wonyoungpark.api.booking.repository;


import java.util.List;

import kr.wonyoungpark.api.booking.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


interface BookingCustomRepository{
}
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingCustomRepository{
    @Query(value="update bookings b set b.book_name = :bookName, b.book_email = :bookEmail, b.book_pnumber =:bookPnumber"
            + " where b.book_num = :bookNum;", nativeQuery = true)
    public long update(@Param("bookName") String bookName,
                       @Param("bookEmail") String bookEmail, @Param("bookPnumber") String bookPnumber,
                       @Param("bookNum") long bookNum);

    @Query(value="select * from bookings b where b.book_num like :bookNum", nativeQuery = true)
    public Booking findByBookNum(@Param("bookNum") long bookNum);

}
