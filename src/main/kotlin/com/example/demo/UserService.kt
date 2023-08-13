package com.example.demo

import com.example.demo.dto.CreateUserDto
import com.example.demo.dto.UserDto
import com.example.demo.dto.UsersPage
import jakarta.transaction.Transactional
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserService(val repository: UserRepository) {

    private val logger = LoggerFactory.getLogger(this.javaClass.canonicalName)

    @Transactional
    fun create(userDto: CreateUserDto): UserDto {
        logger.info("Create user {}", userDto)
        val user = User(userDto.username)
        repository.save(user)
        return UserDto.fromEntity(user)
    }

    @Transactional
    fun findAll(pageable: Pageable): UsersPage {
        val users = repository.findAll(pageable)
        return UsersPage.build(users)
    }

    @Transactional
    fun deleteById(id: Long) {
        logger.info("Delete user [{}]", id)
        repository.deleteById(id)
    }

    @Transactional
    fun findById(id: Long): UserDto {
        val user = repository.findById(id).orElseThrow { UserNotFoundException("User with id [$id] not found") }
        return UserDto.fromEntity(user)
    }

    @Transactional
    fun update(userDto: UserDto): UserDto {
        logger.info("Update user {}", userDto)
        val user = User(userDto.id, userDto.username)
        repository.save(user)
        return UserDto.fromEntity(user)
    }

}




