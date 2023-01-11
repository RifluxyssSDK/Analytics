package com.rifluxyss.app.analyticstracking.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestInterface {

    @Headers({"applicationCode: CPRNT"})
    @POST("/CoPilotServices/UploadLogFile.aspx")
    Call<String> uploadAnalyticsLogs(@Body String message);
}
