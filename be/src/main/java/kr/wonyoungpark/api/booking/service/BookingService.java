package kr.wonyoungpark.api.booking.service;

import java.util.List;

import kr.wonyoungpark.api.booking.domain.Booking;

public interface BookingService {
	public long update(String bookName, String bookEmail, String bookPnumber, long bookNum);
}
