package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.RecentMapper;
import beSoft.tn.SchedulerProject.dto.*;
import beSoft.tn.SchedulerProject.model.*;
import beSoft.tn.SchedulerProject.repository.RecentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecentService {
    @Autowired
    RecentRepository recentRepository;
    @Autowired
    RecentMapper recentMapper;

    public List<RecentDto> getAllRecents() {
        List<Recent> recents = recentRepository.findAll();
        return recents.stream().map(recentMapper::recentToRecentDto).toList();
    }

    public RecentDto getRecentById(Integer id) {
        Recent recent= recentRepository.findById(id).orElse(null);
        return recentMapper.recentToRecentDto(recent);
    }

    public RecentDto saveRecent(RecentDto recentDto) {
        Recent recent1=recentMapper.recentDtoToRecent(recentDto);
        Recent recent= recentRepository.save(recent1);
        return recentMapper.recentToRecentDto(recent);
    }
}
