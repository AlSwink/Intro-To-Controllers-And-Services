package com.cooksys;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

	@Mappings({
		@Mapping(source = "friends", target = "friendID")
	})
	PersonDto personToPersonDto(Person person);
	
	Person personDtoToPerson(PersonDto personDto);
	
}
