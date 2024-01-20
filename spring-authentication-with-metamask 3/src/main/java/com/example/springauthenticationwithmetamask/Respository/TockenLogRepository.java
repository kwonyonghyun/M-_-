package com.example.springauthenticationwithmetamask.Respository;

import com.example.springauthenticationwithmetamask.Entity.TockenCreatLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TockenLogRepository extends JpaRepository<TockenCreatLog,Long> {

    public List<TockenCreatLog> findAll();

}
