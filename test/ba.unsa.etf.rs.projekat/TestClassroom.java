package ba.unsa.etf.rs.projekat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestClassroom {
    @Test
    void setName(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        room.setName("II-1");
        assertEquals("II-1",room.getName());
    }
    @Test
    void toStringClassroom(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        String string = room.toString();
        assertEquals("ime",string);
    }
    @Test
    void setNumberOfStudents(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        room.setNumberOfStudents(10);
        assertEquals(10,room.getNumberOfStudents());
    }
    @Test
    void setNumberOfStudentsException(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            room.setNumberOfStudents(60);
        });
        String ocekivano = "Ne možete imati preko 30 ucenika!";
        String postojeca = exception.getMessage();
        assertEquals(ocekivano, postojeca);
    }
    @Test
    void setId(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        room.setId(20);
        assertEquals(20,room.getId());
    }
    @Test
    void setYear(){
        ClassRoom room = new ClassRoom(1,15,"ime",2);
        room.setYear(5);
        assertEquals(5,room.getYear());
    }
}
