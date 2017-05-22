/**
 * 
 */
package com.example.demo.dao;

import com.example.demo.domain.Visit;

/**
 * @author Brian Schalme
 *
 */
public interface VisitDao {
    public Visit findOne(Integer visitId);
}
