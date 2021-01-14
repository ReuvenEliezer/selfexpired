package entities;

import java.time.LocalDateTime;

public class DateTimeEntity {

    private LocalDateTime localDateTime;

//    for deserialize
    public DateTimeEntity() {
    }

    public LocalDateTime getDateTime() {
        return localDateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.localDateTime = dateTime;
    }

    public DateTimeEntity(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "DateTimeEntity{" +
                "localDateTime=" + localDateTime +
                '}';
    }
}
