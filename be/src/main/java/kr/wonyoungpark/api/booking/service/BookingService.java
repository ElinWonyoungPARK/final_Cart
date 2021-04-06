package kr.wonyoungpark.api.booking.service;

import kr.wonyoungpark.api.booking.domain.Booking;

import java.util.List;

public interface BookingService {
    public long update(String bookName, String bookEmail, String bookPnumber, long bookNum);
    public Booking findByBookNum(long bookNum);
}

