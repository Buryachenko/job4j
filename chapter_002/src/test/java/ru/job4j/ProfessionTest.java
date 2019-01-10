package ru.job4j.profession;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Oleg Buryachenko (mailto:ovburyachenko@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class ProfessionTest {
    @Test
    public void testProfession() {
        Doctor doctor = new Doctor();
        Patient patient = new Patient();
        doctor.triats(patient);
        Engeneer engeneer = new Engeneer();
        House house = new House();
        engeneer.builds(house);
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.learn(student);
    }
}











