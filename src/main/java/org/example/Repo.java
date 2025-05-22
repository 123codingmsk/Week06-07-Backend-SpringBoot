package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Contact, Integer> {
}
