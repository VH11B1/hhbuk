package edu.avans.hartigehap.domain.criteria;

import edu.avans.hartigehap.domain.criteria.impl.NotInPlannedRoleCriteria;
import edu.avans.hartigehap.domain.criteria.impl.NotPresentCriteria;
import edu.avans.hartigehap.domain.criteria.impl.PlannedCriteria;
import edu.avans.hartigehap.domain.criteria.impl.PresentCriteria;
import edu.avans.hartigehap.domain.planning.Planning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3-3-2015.
 *
 * Builder pattern
 */
public class CriteriaBuilder {

    private static CriteriaBuilder instance;

    private static List<Criteria> criteriaList;

    // singleton
    public static CriteriaBuilder getInstance(){
        if (instance == null){
            instance = new CriteriaBuilder();
        }
        criteriaList = new ArrayList<Criteria>();
        return instance;
    }

    private CriteriaBuilder(){
        // nope
    }

    public CriteriaBuilder and(final Criteria.Type... types){

        Criteria[] crits = new Criteria[types.length];

        for (int i = 0; i < types.length; i++) {
            crits[i] = getCriteriaByType(types[i]);
        }

        criteriaList.add(new AndCriteria(crits));

        // chaining
        return this;
    }


    public CriteriaBuilder or(final Criteria.Type... types){

        Criteria[] crits = new Criteria[types.length];

        for (int i = 0; i < types.length; i++) {
            crits[i] = getCriteriaByType(types[i]);
        }

        criteriaList.add(new OrCriteria(crits));

        // chaining
        return this;
    }

    public CriteriaBuilder single(final Criteria.Type type){
        criteriaList.add(getCriteriaByType(type));

        return this;
    }

    public List<Planning> fetch(final List<Planning> allPlannings){
        List<Planning> list = allPlannings;
        for (Criteria c : criteriaList){
            //System.err.println("calling meetcriteria for a " + c.getClass().getName());
            list = c.meetCriteria(list);
        }
        return list;
    }

    private Criteria getCriteriaByType(final Criteria.Type type){
        //TODO move to enum Criteria.Type
        switch (type){
            case PLANNED : return new PlannedCriteria();
            case PRESENT : return new PresentCriteria();
            case NOT_PRESENT: return new NotPresentCriteria();
            case NOT_IN_PLANNED_ROLE: return new NotInPlannedRoleCriteria();
        }
        return null;
    }
}
