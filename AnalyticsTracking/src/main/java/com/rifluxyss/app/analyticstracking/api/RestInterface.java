package com.rifluxyss.app.analyticstracking.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Interface of RestInterface
 * Based on the method of the API Call
 */
public interface RestInterface {

    /**
     * @param message of Input value
     * @return of Response Data
     */
    @Headers({"applicationCode: CPRNT"})
    @POST("/CoPilotServices/UploadLogFile.aspx")
    Call<String> uploadAnalyticsLogs(@Body String message);
}
