package com.menschmaschine.worker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TasksRepository {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Transactional(readOnly = true)
  public Object findAll() {
    return jdbcTemplate.query("select * from tasks", (rs, rowNum) -> rs.getString("NAME"));
  }
}
