package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.DependencyMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.DependencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DependencyService {
    @Autowired
    DependencyRepository dependencyRepository;

    public DependencyDto findById(Integer id) {
        Dependency dependency=dependencyRepository.findById(id).orElse(null);
        return DependencyMapper.INSTANCE.toDto(dependency);
    }

    public List<DependencyDto> findAll() {
        List<Dependency> dependencies = dependencyRepository.findAll();
        return dependencies.stream().map(DependencyMapper.INSTANCE::toDto).toList();
    }

    public DependencyDto save(DependencyDto dependencyDto) {
        Dependency dependency=DependencyMapper.INSTANCE.toEntity(dependencyDto);
        return DependencyMapper.INSTANCE.toDto(dependencyRepository.save(dependency));
    }
}
