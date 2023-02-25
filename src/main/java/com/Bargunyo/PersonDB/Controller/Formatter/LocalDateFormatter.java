package com.Bargunyo.PersonDB.Controller.Formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class LocalDateFormatter implements Formatter<LocalDate> {

    /*
    * Esta clase formatea la fecha. Lo podríamos hacer desde el modelo
    * con un método getFormattedDate, pero es mejor no modificar el modelo
    * para hacer cambios que no afectan a la lógica, sino a la estética.
    *
    * Está etiquetado con @Component, que permite que Spring la identifique. Entonces,
    * en cada variable LocalDate aplicará los cambios de LocalDateFormatter según
    * la implementación de Formatter.
    * */

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;


    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text,dateTimeFormatter);
    }

    @Override
    public String print(LocalDate object, Locale locale) {

        return dateTimeFormatter.format(object);
    }
}
