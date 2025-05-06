package com.test.elibrary.mapper;

import com.test.elibrary.dto.BorrowedResponseDTO;
import com.test.elibrary.entity.BorrowedBookEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BorrowedBookMapper {

    BorrowedResponseDTO toDto(BorrowedBookEntity entity);

    List<BorrowedResponseDTO> toDtoList(List<BorrowedBookEntity> entityList);
}
