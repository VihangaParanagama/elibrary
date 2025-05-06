package com.test.elibrary.mapper;

import com.test.elibrary.dto.UserDTO;
import com.test.elibrary.entity.RoleEntity;
import com.test.elibrary.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapRolesToStrings")
    UserDTO toDto(UserEntity userEntity);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapStringsToRoles")
    UserEntity toEntity(UserDTO userDTO);

    @Named("mapRolesToStrings")
    default Set<String> mapRolesToStrings(Set<RoleEntity> roles) {
        return roles.stream()
                .map(RoleEntity::getName)
                .collect(Collectors.toSet());
    }

    @Named("mapStringsToRoles")
    default Set<RoleEntity> mapStringsToRoles(Set<String> roleNames) {
        return roleNames.stream()
                .map(name -> {
                    RoleEntity role = new RoleEntity();
                    role.setName(name);
                    return role;
                }).collect(Collectors.toSet());
    }
}
