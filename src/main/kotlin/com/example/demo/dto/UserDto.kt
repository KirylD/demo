package com.example.demo.dto

import com.example.demo.User
import jakarta.validation.constraints.NotBlank
import java.util.stream.Collectors

data class UserDto(val id: Long, @NotBlank val username: String) {
    companion object Factory {
        fun fromEntity(user: User) = UserDto(user.id!!, user.username)

        fun fromEntityList(users: List<User>): List<UserDto> {
            return users.stream()
                .map { user -> fromEntity(user) }
                .collect(Collectors.toList())
        }
    }
}
