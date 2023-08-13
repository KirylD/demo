package com.example.demo

import com.example.demo.dto.CreateUserDto
import com.example.demo.dto.UserDto
import com.example.demo.dto.UsersPage
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Tag(name = "Users")
@RestController
@RequestMapping("/api/v1/users")
class UserController(val service: UserService) {

    @Operation(summary = "Returns Users according to pageable settings")
    @GetMapping
    fun getAll(pageable: Pageable): UsersPage = service.findAll(pageable)

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): UserDto = service.findById(id)

    @PostMapping
    fun createUser(@RequestBody user: CreateUserDto): UserDto = service.create(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable("id") id: Long, @RequestBody user: UserDto): UserDto =
        service.update(user)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: Long) = service.deleteById(id)
}
