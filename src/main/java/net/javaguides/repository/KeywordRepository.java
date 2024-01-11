package net.javaguides.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.entity.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {

}
