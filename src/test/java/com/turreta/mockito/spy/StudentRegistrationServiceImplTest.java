package com.turreta.mockito.spy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * 
 * @author Turreta.com
 *
 */
public class StudentRegistrationServiceImplTest {

    /**
     * Refers to a mock object
     */
    StudentRegistrationRequest mockedServiceRequestObject;

    /**
     * Refers to a spy object
     */
    StudentRegistrationRequest spyServiceRequestObject;

    /**
     * Refers to a real object Mockito spies on.
     */
    StudentRegistrationRequest spiedOnrealServiceRequestObject;

    @Before
    public void setUp() {
        /**
         * Create a mock object
         */
        mockedServiceRequestObject = Mockito.mock(StudentRegistrationRequestImpl.class);

        /**
         * Create a real object to spy on.
         */
        spiedOnrealServiceRequestObject = new StudentRegistrationRequestImpl();

        /**
         * Create a spy object
         */
        spyServiceRequestObject = Mockito.spy(new StudentRegistrationRequestImpl());
    }

    /**
     * Test the difference between spy and mock object in their behavior.
     * 
     * Spy objects allow us to use real object; whereas mock do not and requires the behaviors to be stubbed out (e.g.,
     * using Mockito.when(..)...())
     */
    @Test
    public void test_spy_vs_mock() {

        StudentBean searchCriteria = new StudentBean("111", "Karl SG");

        spyServiceRequestObject.setStudentSearchCriteria(searchCriteria);
        StudentBean returnedBeanFromSpyObject = spyServiceRequestObject.getStudentSearchCriteria();
        Assert.assertTrue(returnedBeanFromSpyObject != null);

        mockedServiceRequestObject.setStudentSearchCriteria(searchCriteria);

        /**
         * Returns null as there is no "real codes" in setStudentSearchCriteria(...) and getStudentSearchCriteria().
         * 
         * The behavior is undefined specially for getStudentSearchCriteria()
         * */
        StudentBean returnedBeanFromMockedObject = mockedServiceRequestObject.getStudentSearchCriteria();
        Assert.assertTrue(returnedBeanFromMockedObject == null);

    }

    /**
     * Test spy and real objects are two different objects. They refer to the same object. Changes in spy object do not
     * affect the real object.
     * 
     */
    @Test
    public void test_spy_and_realobject_are_two_different_objects() {

        StudentBean searchCriteria = new StudentBean("111", "Karl SG");
        spiedOnrealServiceRequestObject.setStudentSearchCriteria(searchCriteria);

        // Spy object does not have StudentBean object
        Assert.assertNull(this.spyServiceRequestObject.getStudentSearchCriteria());
    }

}
