package com.xmtx.jobfair.repository;

import com.xmtx.jobfair.dataObject.EnterpriseInfo;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：djq.
 * @ Date       ：Created in 18:50 2020/2/13
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public interface EnterpriseInfoRepository extends JpaRepository<EnterpriseInfo,Integer> {
    @Override
    Optional<EnterpriseInfo> findById(Integer id);
    List<EnterpriseInfo> findAllById(Integer enterpriseId);
    List<EnterpriseInfo> findAll();

}
