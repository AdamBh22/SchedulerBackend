package beSoft.tn.SchedulerProject.services;

import beSoft.tn.SchedulerProject.Mapper.AppUserMapper;
import beSoft.tn.SchedulerProject.dto.AppUserDto;
import beSoft.tn.SchedulerProject.model.AppUser;
import beSoft.tn.SchedulerProject.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUserDto> findAllAppUsers() {
        List<AppUser> list = appUserRepository.findAll();
        return list.stream().map(AppUserMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public AppUserDto findAppUserById(Integer id) {
        Optional<AppUser> optionalAppUser = appUserRepository.findById(id);
        return optionalAppUser.map(AppUserMapper.INSTANCE::toDto).orElse(null);
    }

    public AppUserDto save(AppUserDto appUserDto) {
        AppUser appUser = AppUserMapper.INSTANCE.toEntity(appUserDto);
        AppUser user = appUserRepository.save(appUser);
        return AppUserMapper.INSTANCE.toDto(user);
    }

    public AppUserDto update(AppUserDto appUserDto) {
        AppUser appUser = AppUserMapper.INSTANCE.toEntity(appUserDto);
        return AppUserMapper.INSTANCE.toDto(appUserRepository.save(appUser));
    }
}
