package com.github.kadehar.inno.junit.listener;

import com.github.kadehar.inno.config.ApiConfig;
import com.github.kadehar.inno.config.Configuration;
import com.github.kadehar.inno.network.auth.TokenClient;
import com.github.kadehar.inno.network.auth.data.Token;
import com.github.kadehar.inno.network.auth.data.User;
import com.github.kadehar.inno.network.base.NoAuthClient;
import com.github.kadehar.inno.storage.TokenStorage;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;

public class FetchTokenListener implements TestExecutionListener {
    private static final ApiConfig config = Configuration.INSTANCE.api();

    @Override
    public void testPlanExecutionStarted(TestPlan testPlan) {
        TokenClient tokenClient = new TokenClient(new NoAuthClient());
        User user = new User(config.adminUsername(), config.adminPassword());
        Token token = tokenClient.fetch(user);
        TokenStorage.INSTANCE.put(token.value());
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        TokenStorage.INSTANCE.clear();
    }
}
