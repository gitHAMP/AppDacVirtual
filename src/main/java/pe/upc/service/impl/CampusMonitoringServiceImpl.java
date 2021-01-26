package pe.upc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.entity.CampusMonitoring;
import pe.upc.repository.CampusMonitoringRepository;
import pe.upc.service.CampusMonitoringService;

import java.util.List;
import java.util.Optional;

@Service
public class CampusMonitoringServiceImpl implements CampusMonitoringService {
    @Autowired
    private CampusMonitoringRepository campusMonitoringRepository;

    @Override
    public List<CampusMonitoring> getAll() throws Exception {
        return null;
    }

    @Override
    public Page<CampusMonitoring> getAll(Pageable pageable) throws Exception {
        return null;
    }

    @Transactional
    @Override
    public CampusMonitoring saveOrUpdate(CampusMonitoring entity) throws Exception {
        return campusMonitoringRepository.save(entity);
    }

    @Override
    public Optional<CampusMonitoring> getOne(Long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) throws Exception {

    }
}
