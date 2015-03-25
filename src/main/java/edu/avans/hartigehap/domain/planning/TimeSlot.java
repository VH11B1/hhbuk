package edu.avans.hartigehap.domain.planning;

import edu.avans.hartigehap.domain.DomainObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Alex on 3-3-2015.
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
public abstract class TimeSlot extends DomainObject {
    private DayPart part;
    private LocalDateTime start;
    private Date startDate;
    private LocalDateTime end;

    public TimeSlot (TimeSlot.DayPart dayPart, LocalDateTime start, LocalDateTime end) {
        setPart(dayPart);
        setEnd(end);
        setStart(start);
    }

    public Date getStartDate () {
        return Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
    }

    @Getter
    public enum DayPart {

        MORNING("7:00", "12:00"), AFTERNOON("12:00", "16:00"), EVENING("16:00",
                "21:00"), NIGHT("21:00", "1:00");

        private String start;
        private String end;

        private DayPart (String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
}
