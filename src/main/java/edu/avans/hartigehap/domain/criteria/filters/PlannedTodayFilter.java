package edu.avans.hartigehap.domain.criteria.filters;

import edu.avans.hartigehap.domain.planning.Planning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 10-3-2015.
 */
public class PlannedTodayFilter extends FilterDecorator<LocalDateTime> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PlannedTodayFilter.class);
    public PlannedTodayFilter (List<Planning> list) {
        super(list, LocalDateTime.now());
    }

    public PlannedTodayFilter (Filter f) {
        super(f, LocalDateTime.now());
        setOriginal(f);
    }

    @Override
    public List<Planning> filter () {
        List<Planning> originalList = getPlanningList();
        List<Planning> filteredList = new ArrayList<Planning>();

        for (Planning p : originalList) {
            if (dateIsToday(p)) {
                filteredList.add(p);
            }
        }

        return filteredList;
    }

    private boolean dateIsToday (Planning p) {
        if (p.getPlannedSlot().getStart().compareTo(LocalDateTime.now()) >= -1 & p.getPlannedSlot().getStart().compareTo(LocalDateTime.now()) <= -1) {
            return true;
        }
        if (p.getPlannedSlot().getEnd().compareTo(LocalDateTime.now()) >= -1 & p.getPlannedSlot().getEnd().compareTo(LocalDateTime.now()) <= -1) {
            return true;
        }

        return false;
    }

    @Override
    public void set (LocalDateTime... l) {

        LOGGER.debug("This filter does not require filter items to be set");
    }
}
