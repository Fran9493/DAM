package com.mycompany.garcia_cutillas_franciscojose_actut04.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Fran
 */
public class FechaUtil {

    public static Date convierteFecha(String fechaSpain) {

        DateTimeFormatter formatoSpain = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaLocalDate = LocalDate.parse(fechaSpain, formatoSpain);

        return Date.valueOf(fechaLocalDate);

    }

}
