package kr.wonyoungpark.api.hall.service;


import kr.wonyoungpark.api.hall.domain.Hall;

import java.util.List;

public interface HallService {
    public List<Hall> findByHallNameAndHallLocation(String name, String location);
    public long update(String hallClosed, long hallNum);

}
