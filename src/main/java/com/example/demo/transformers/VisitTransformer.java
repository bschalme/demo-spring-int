/**
 * 
 */
package com.example.demo.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VisitDao;
import com.example.demo.domain.Visit;

/**
 * @author Brian Schalme
 *
 */
@Service
public class VisitTransformer {
    @Autowired
    private VisitDao dao;

    public Visit findVisit(Visit visit) {
        return dao.findOne(visit.getVisitId());
    }
}
