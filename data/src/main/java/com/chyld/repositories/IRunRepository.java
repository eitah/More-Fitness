package com.chyld.repositories;

import com.chyld.entities.Run;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRunRepository extends PagingAndSortingRepository<Run, Integer> {
}
