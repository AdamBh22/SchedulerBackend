package beSoft.tn.SchedulerProject.Mapper;

import beSoft.tn.SchedulerProject.dto.RecentDto;
import beSoft.tn.SchedulerProject.model.Recent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecentMapper {
    RecentMapper INSTANCE= Mappers.getMapper(RecentMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "type",target = "type")
    @Mapping(source = "user",target = "user")
    RecentDto recentToRecentDto(Recent recent);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    @Mapping(source = "type",target = "type")
    @Mapping(source = "user",target = "user")
    Recent recentDtoToRecent(RecentDto recentDto);
}
