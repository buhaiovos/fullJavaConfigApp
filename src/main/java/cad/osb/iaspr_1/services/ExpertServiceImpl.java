package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Expert;

import java.util.ArrayList;
import java.util.List;

public class ExpertServiceImpl implements ExpertService {

    private int currentExpertNum;
    private Expert currentExpert;
    private List<Expert> expertList;

    public ExpertServiceImpl() {
        expertList = new ArrayList<>();
    }

    @Override
    public Expert getNextExpert() {
        currentExpert = new Expert(currentExpertNum++, -1.0);
        expertList.add(currentExpert);
        return currentExpert;
    }

    @Override
    public Expert getCurrentExpert() {
        return currentExpert;
    }

    @Override
    public int getExpertsNum() {
        return currentExpertNum;
    }
}
