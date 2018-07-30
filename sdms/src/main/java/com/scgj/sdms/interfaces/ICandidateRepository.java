package com.scgj.sdms.interfaces;

import com.scgj.sdms.model.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICandidateRepository extends CrudRepository<Candidate,String> {

    Candidate findByAadharNo(long aadharNo);
    Candidate save(Candidate candidate);

    @Query(value = "select count(candidate.certified) from candidate where certified='yes'" ,nativeQuery = true)
    int getCertifiedCandidate();

    @Query(value = "select count(candidate.candidate_id) from candidate", nativeQuery = true)
    int getEnrolledCandidate();

    @Query(value="select count(candidate_id) as Enrolled,(select count(candidate_id) from candidate where batch_id in(select batch_id from Batch)) as Assessed,(select count(candidate_id) from candidate where certified=' yes') as Certified from candidate",nativeQuery = true)
    List<Integer> getNoOfCandidates();

    @Query(value = "select count(candidate_id) from candidate)" ,nativeQuery = true)
    int getTotalCandidateEnrolled();
}
