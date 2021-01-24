package pe.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.upc.entity.Week;
import pe.upc.repository.WeekRepository;
import pe.upc.service.WeekService;

import java.util.List;
import java.util.Optional;

@Service
public class WeekServiceImpl implements WeekService {

    @Autowired
    private WeekRepository weekRepository;


    @Override
    public List<Week> getAll() throws Exception {
        return weekRepository.findAll();
    }

    @Override
    public Page<Week> getAll(Pageable pageable) throws Exception {
        return weekRepository.findAll(pageable);
    }

    @Override
    public Week saveOrUpdate(Week entity) throws Exception {
        return weekRepository.save(entity);
    }

    @Override
    public Optional<Week> getOne(Long id) throws Exception {
        return weekRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        weekRepository.deleteById(id);
    }
}
