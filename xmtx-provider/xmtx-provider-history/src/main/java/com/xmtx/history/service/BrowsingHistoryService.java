package com.xmtx.history.service;

import com.xmtx.common.DTO.TopNDTO;

import java.util.List;

public interface BrowsingHistoryService {


    // 插入新浏览记录
    void save(Integer jobid, Integer userid);

    List<TopNDTO> getTopNBrowsingCount();

}
