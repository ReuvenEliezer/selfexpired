package entities;

import org.springframework.format.Formatter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    @Override
    public LocalDateTime parse(String text, Locale locale) {
        return LocalDateTime.parse(text, DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return DateTimeFormatter.ISO_DATE_TIME.format(object);
    }

}