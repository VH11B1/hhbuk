package edu.avans.hartigehap.service;

import edu.avans.hartigehap.domain.planning.Planning;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Alex on 9-3-2015.
 */
public interface PlanningOverviewService {

    // use case: het is mogelijk voor de manager om een overzicht op te vragen
    // met daarin wie op dat moment welke rol vervult
    List<Planning> getCurrentWorking ();

    List<Planning> getWeekPlanning ();

    List<Planning> getAllPlanningFromNow ();

    Page<Planning> getAllPlanningFromNowPageable(Pageable pageable);
}
