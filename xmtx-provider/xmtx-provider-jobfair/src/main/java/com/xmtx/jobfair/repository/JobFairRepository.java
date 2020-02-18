package com.xmtx.jobfair.repository;

import com.xmtx.jobfair.dataObject.JobFair;
import org.springframework.data.jpa.repository.JpaRepository;

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

    @Override
    Optional<JobFair> findById(Integer integer);

    @Override
    void deleteById(Integer id);
}
