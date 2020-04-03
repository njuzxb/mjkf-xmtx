package com.xmtx.history.repository;

import com.xmtx.history.dataObject.BrowsingHistory;
import com.xmtx.common.DTO.TopNDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrowsingHistoryRepository extends JpaRepository<BrowsingHistory, Integer> {

    <S extends BrowsingHistory> S save(S s);

    // 获得24小时以内TopN
    @Query(nativeQuery = true, value = "select jobid, count(*) browsingNum from browsing_history " +
            "where gmt_browsing >=(NOW() - interval 24 hour)" +
            "group by jobid order by browsingNum desc limit 10")
    List<Object[]>  getOneDayTopN();

}
