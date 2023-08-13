package com.example.demo.dto

import jakarta.validation.constraints.NotBlank

data class CreateUserDto(val id: Long?, @NotBlank val username: String)
