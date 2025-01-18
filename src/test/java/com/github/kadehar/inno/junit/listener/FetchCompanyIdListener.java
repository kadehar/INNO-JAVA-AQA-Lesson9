package com.github.kadehar.inno.junit.listener;

import com.github.kadehar.inno.network.base.NoAuthClient;
import com.github.kadehar.inno.network.company.CompanyClient;
import com.github.kadehar.inno.network.company.data.Company;
import com.github.kadehar.inno.storage.CompanyIdStorage;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

public class FetchCompanyIdListener implements TestExecutionListener {
    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        CompanyClient companyClient = new CompanyClient(new NoAuthClient());
        Company company = companyClient.fetch();
        CompanyIdStorage.INSTANCE.put(company.id());
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        CompanyIdStorage.INSTANCE.clear();
    }
}
