package cad.osb.iaspr_1.services;

import cad.osb.iaspr_1.domain.Expert;

public interface ExpertService {
    Expert getNextExpert();
    Expert getCurrentExpert();
}
