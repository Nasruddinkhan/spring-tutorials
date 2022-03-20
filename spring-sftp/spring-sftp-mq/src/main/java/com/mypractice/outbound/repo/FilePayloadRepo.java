package com.mypractice.outbound.repo;

import com.mypractice.outbound.model.FilePayload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilePayloadRepo  extends JpaRepository<FilePayload, Integer> {

}
