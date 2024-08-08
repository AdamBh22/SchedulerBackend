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
        return DependencyMapper.INSTANCE.dependencyToDependencyDto(dependency);
    }

    public List<DependencyDto> findAll() {
        List<Dependency> dependencies = dependencyRepository.findAll();
        return dependencies.stream().map(DependencyMapper.INSTANCE::dependencyToDependencyDto).toList();
    }

    public DependencyDto save(DependencyDto dependencyDto) {
        Dependency dependency=DependencyMapper.INSTANCE.dependencyDtoToDependency(dependencyDto);
        return DependencyMapper.INSTANCE.dependencyToDependencyDto(dependencyRepository.save(dependency));
    }

    public void delete(Integer id) {
        dependencyRepository.deleteById(id);
    }
    public DependencyDto update(String Status, DependencyDto dependencyDto) {
        if(dependencyDto == null){
            return null;
        }
        dependencyDto.setStatus(Status);
        Dependency dependency=DependencyMapper.INSTANCE.dependencyDtoToDependency(dependencyDto);
        return DependencyMapper.INSTANCE.dependencyToDependencyDto(dependencyRepository.save(dependency));
    }
}
