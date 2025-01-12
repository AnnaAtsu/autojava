package ru.stqa.mantis.manager;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.IssuesApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.Identifier;
import io.swagger.client.model.Issue;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import ru.stqa.mantis.model.IssueData;

import java.net.CookieManager;

public class RestApiHelper extends HelperBase{

    public RestApiHelper(ApplicationManager manager) {
        super(manager);
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
        Authorization.setApiKey(manager.property("apiKey"));
    }


    public void createIssue(IssueData issueData) {


        Issue issue = new Issue();
        issue.setSummary(issueData.summary());
        issue.setDescription(issueData.description());
        var projectId = new Identifier();
        projectId.setId(issueData.project());
        issue.setProject(projectId);
        var categotyId = new Identifier();
        categotyId.setId(issueData.category());
        issue.setCategory(categotyId);
        IssuesApi apiInstance = new IssuesApi();
              try {
            apiInstance.issueAdd(issue);
        } catch (ApiException e) {
            new RuntimeException(e);
        }
    }
}
