package com.xmtx.provider.repository;

import com.xmtx.provider.model.Admin;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableDiscoveryClient  //更通用，不仅仅用于Eurake
//@Mapper
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


    List<Admin> findAllByEnabled(Integer enable);

}
