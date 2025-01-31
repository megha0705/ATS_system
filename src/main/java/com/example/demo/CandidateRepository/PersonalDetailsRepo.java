package com.example.demo.CandidateRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.CandidateDatabase.PersonalDetails;
@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Integer> {
    @Query("SELECT p.candidate_name FROM PersonalDetails p JOIN p.candidateExperience e JOIN p.candidateSkills s JOIN p.candidateEducation ed WHERE e.job_title = :job_title AND e.months_of_experience = :months_of_experience AND s.skillName IN :skillName AND ed.degree_name = :degree_name")
    List<String> findByCandidateExperienceAndSkillsAndEducation(@Param("job_title") String job_title ,@Param("months_of_experience") double months_of_experience, @Param("skillName") List<String> skillName, @Param("degree_name") String degree_name);
}
