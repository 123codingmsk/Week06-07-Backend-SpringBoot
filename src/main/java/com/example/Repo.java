package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<MessageClass, Long> {

}
