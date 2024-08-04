package io.github.edsonzuchi.warehouse.core.dto;

import java.util.Objects;

public record UserDto(String name, String email) {
    public UserDto {
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
    }
}
