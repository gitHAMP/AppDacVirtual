package pe.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.upc.entity.Day;
import pe.upc.repository.DayRepository;
import pe.upc.service.DayService;

import java.util.List;
import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private DayRepository dayRepository;

    @Override
    public List<Day> getAll() throws Exception {
        return dayRepository.findAll();
    }

    @Override
    public Page<Day> getAll(Pageable pageable) throws Exception {
        return dayRepository.findAll(pageable);
    }

    @Override
    public Day saveOrUpdate(Day entity) throws Exception {
        return dayRepository.save(entity);
    }

    @Override
    public Optional<Day> getOne(Long id) throws Exception {
        return dayRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        dayRepository.deleteById(id);
    }
}
