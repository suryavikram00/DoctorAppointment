
import com.prepation.doctorappointment.model.Patient;
import org.junit.Assert;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NMSLAP570
 */
public class TestClass {
   
    @Test
    public void equalObjectTesting(){
        Patient patientOne = new Patient("PatientA");
        Patient patientTwo = new Patient("PatientA");
        
        Assert.assertEquals(patientOne, patientTwo);
    }
    
}
