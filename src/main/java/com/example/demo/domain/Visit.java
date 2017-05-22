/**
 * 
 */
package com.example.demo.domain;

import org.apache.commons.codec.binary.StringUtils;

import lombok.Data;

/**
 * @author Brian Schalme
 *
 */
@Data
public class Visit {
    private int visitId;
    private String visitType;
    private String patientName;

    public boolean isNoShow() {
        return StringUtils.equals(visitType, "NoShow");
    }

    public boolean isCancellation() {
        return StringUtils.equals(visitType, "Cancellation");
    }

}
