package ba.unsa.etf.rs.projekat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestAdministrator {
    @Test
    void setEmail(){
        Administrator admin = new Administrator(2,"email","pass");
        admin.setEmail("admin@gmail.com");
        assertEquals("admin@gmail.com",admin.getEmail());
    }
    @Test
    void setId(){
        Administrator admin = new Administrator(2,"email","pass");
        admin.setId(3);
        assertEquals(3,admin.getId());
    }
    @Test
    void setPassword(){
        Administrator admin = new Administrator(2,"email","pass");
        admin.setPassword("123");
        assertEquals("123",admin.getPassword());
    }
}
