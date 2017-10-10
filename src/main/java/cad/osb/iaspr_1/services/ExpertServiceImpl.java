package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Expert;

public class ExpertServiceImpl implements ExpertService {

    private int currentExpertNum;
    private Expert currentExpert;

    @Override
    public Expert getNextExpert() {
        currentExpert = new Expert(currentExpertNum++, -1.0);
        return currentExpert;
    }

    @Override
    public Expert getCurrentExpert() {
        return currentExpert;
    }
}
