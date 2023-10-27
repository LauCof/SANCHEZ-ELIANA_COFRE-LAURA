package com.backend.test;

import com.backend.Dao.impl.OdontologoDaoH2;
import com.backend.Service.OdontologoService;
import com.backend.model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;

public class OdontologoServiceTest {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/testClase;INIT=RUNSCRIPT FROM 'test.sql'", "parcial", "parcial");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    void deberiaAgregarUnOdontologo(){

        Odontologo odontologo = new Odontologo(2545,"Laura","Lorca");

        Odontologo odontologoRegistrado = odontologoService.registrarOdontologo(odontologo);

        Assertions.assertTrue(odontologoRegistrado.getId() != 0);
    }

    @Test
    void deberiaRetornarUnaListaNoVacia(){

        Assertions.assertFalse(odontologoService.listarOdontologos().isEmpty());
    }
}
