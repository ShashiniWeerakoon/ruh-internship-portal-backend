package ruh_internship_portal_backend.example.ruh_internship_portal_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ruh_internship_portal_backend.example.ruh_internship_portal_backend.entity.WeeklyDiaryUpdate;

@Repository
@EnableJpaRepositories
public interface WeeklyDiaryUpdateRepo extends JpaRepository<WeeklyDiaryUpdate, Long> {
}
