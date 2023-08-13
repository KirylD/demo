package com.example.demo.dto

import com.example.demo.User
import org.springframework.data.domain.Page

data class UsersPage(val users: List<UserDto>, val totalUsers: Long, val totalPages: Int) {
    companion object Factory {
        fun build(usersPage: Page<User>): UsersPage {
            return UsersPage(
                UserDto.fromEntityList(usersPage.content),
                usersPage.totalElements,
                usersPage.totalPages
            )
        }
    }
}
