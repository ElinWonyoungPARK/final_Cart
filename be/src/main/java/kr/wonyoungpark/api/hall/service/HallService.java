package kr.wonyoungpark.api.hall.service;

import java.util.List;

import kr.wonyoungpark.api.hall.domain.Hall;

public interface HallService {
	public List<Hall> findByHallNameAndHallLocation(String name, String location);
	public long update(String hallClosed, long hallNum);
	
}
