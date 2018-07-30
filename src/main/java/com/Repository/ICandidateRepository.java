package com.Repository;

import com.model.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICandidateRepository extends CrudRepository<Candidate, Integer> {

    @Query(value = "select count(sdms.candidate.certified) from  sdms.candidate where certified='yes'" ,nativeQuery = true)
    int getCertifiedCandidate();

    @Query(value = "select count(sdms.candidate.candidate_id) from sdms.candidate", nativeQuery = true)
    int getEnrolledCandidate();

    @Query(value = "select count(candidate_id) from candidate join sdms.batch b on candidate.batch_id = b.batch_id where b.assessment_date <curdate()" ,nativeQuery = true)
    int getAssessedCandidate();

    @Query(value="select count(candidate_id) as Enrolled,(select count(candidate_id) from candidate where batch_id in(select batch_id from Batch)) as Assessed,(select count(candidate_id) from candidate where certified=' yes') as Certified from candidate",nativeQuery = true)
    List<Integer> getNoOfCandidates();

    @Query(value = "select count(candidate_id) from candidate)" ,nativeQuery = true)
    int getTotalCandidateEnrolled();
}
