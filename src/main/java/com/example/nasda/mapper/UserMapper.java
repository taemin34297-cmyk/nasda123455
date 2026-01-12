package com.example.nasda.mapper;

import com.example.nasda.domain.UserEntity;
import com.example.nasda.dto.UserJoinDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    /**
     * DTO를 엔티티로 변환
     */
    public UserEntity toEntity(UserJoinDto dto) {
        if (dto == null) return null;

        return UserEntity.builder()
                .loginId(dto.getLoginId())
                .password(dto.getPassword()) // 암호화 전 비밀번호가 담김
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .build();
    }

    /**
     * 엔티티를 DTO로 변환 (로그인 정보 반환 등에 사용)
     */
    public UserJoinDto toDto(UserEntity entity) {
        if (entity == null) return null;

        return UserJoinDto.builder()
                .loginId(entity.getLoginId())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .build();
    }
}