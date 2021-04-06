package kr.wonyoungpark.api.exhbn.service;

import kr.wonyoungpark.api.common.service.AbstractService;
import kr.wonyoungpark.api.exhbn.domain.Exhbn;
import kr.wonyoungpark.api.exhbn.repository.ExhbnRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class ExhbnServiceImpl extends AbstractService<Exhbn> implements ExhbnService {
    private final ExhbnRepository exhbnrepository;

    @Override public long save(Exhbn e) { return (exhbnrepository.save(e) != null) ? 1 : 0;}
    @Override public long delete(Exhbn e) { exhbnrepository.delete(e); return(getOne(e.getExhbnNum()) == null) ? 1 : 0;}
    @Override public long count() { return exhbnrepository.count();}
    @Override public Exhbn getOne(long id) { return exhbnrepository.getOne(id);}
    @Override public Optional<Exhbn> findById(long id) { return exhbnrepository.findById(id);}
    @Override public boolean existsById(long id) { return exhbnrepository.existsById(id);}
    @Override public List<Exhbn> findAll() { return exhbnrepository.findAll();}
    @Override public Exhbn findByExhbnNum(long exhbnNum) { return exhbnrepository.findByExhbnNum(exhbnNum);}
    @Override public long update(String exhbnTitle, String startDate, String endDate, String exhbnGenre, String exhbnPrice,
                                 String exhbnArtist, String exhbnContent, String exhbnImage, String hallLocation, long exhbnNum) {
        return exhbnrepository.update(exhbnTitle, startDate, endDate, exhbnGenre, exhbnPrice,
                exhbnArtist, exhbnContent, exhbnImage, hallLocation, exhbnNum);}


}
