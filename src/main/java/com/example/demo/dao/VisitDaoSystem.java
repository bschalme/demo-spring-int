/**
 * 
 */
package com.example.demo.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Visit;

/**
 * A simple implementation that just uses system-generated values to populate a
 * Visit.
 * 
 * @author Brian Schalme
 *
 */
@Repository
public class VisitDaoSystem implements VisitDao {

    @Override
    public Visit findOne(Integer visitId) {
        Visit visit = new Visit();
        visit.setVisitId(visitId);
        Random rand = new Random();
        int n = rand.nextInt(10) + 1;
        switch (n) {
        case 1:
            visit.setVisitType("Cancellation");
            break;
        case 2:
            visit.setVisitType("NoShow");
            break;
        default:
            visit.setVisitType("SubsequentVisit");
            break;
        }
        visit.setPatientName("Jennifer Red");
        
        return visit;
    }

}
