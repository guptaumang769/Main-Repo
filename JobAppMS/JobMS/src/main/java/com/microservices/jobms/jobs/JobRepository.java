package com.microservices.jobms.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}

/* We can use CrudRepository instead of JpaRepository to perform CRUD operations.*/