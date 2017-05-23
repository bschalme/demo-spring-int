/**
 * 
 */
package com.example.demo.transformers;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.dao.VisitDao;
import com.example.demo.domain.Visit;

/**
 * Unit tests for {@link VisitTransformer}.
 * 
 * @author Brian Schalme
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class VisitTransformerUnitTest {

    @InjectMocks
    private VisitTransformer transformer;

    @Mock
    private VisitDao dao;

    @Test
    public void testFindVisit() throws Exception {
        when(dao.findOne(isA(Integer.class))).thenReturn(jackSparrow());

        Visit result = transformer.findVisit(new Visit());

        assertThat(result, notNullValue());
        assertThat(result.getPatientName(), equalTo("Jack Sparrow"));
    }

    private Visit jackSparrow() {
        Visit jack = new Visit();
        jack.setVisitId(4);
        jack.setPatientName("Jack Sparrow");
        jack.setVisitType("SubsequentVisit");
        return jack;
    }
}
