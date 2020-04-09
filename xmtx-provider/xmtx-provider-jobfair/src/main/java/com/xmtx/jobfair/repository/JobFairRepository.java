package com.xmtx.jobfair.repository;

import com.xmtx.jobfair.dataObject.JobFair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:33 2020/2/13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface JobFairRepository extends JpaRepository<JobFair,Integer> {
    @Override
    <S extends JobFair> S save(S s);

    @Override
    List<JobFair> findAll();

    @Query(value = "select id from job_fair where promoter = ?1",nativeQuery = true)
    List<Integer> findByPromoter(String username);

    @Override
    Optional<JobFair> findById(Integer integer);

    Optional<JobFair> findByIdAndEnabled(Integer jobid, Integer enabled);

    @Override
    void deleteById(Integer id);
}
