package com.rifluxyss.app.analyticstracking.upload;

import android.util.Xml;

import androidx.lifecycle.MutableLiveData;

import com.rifluxyss.app.analyticstracking.AppManagerSingleton;
import com.rifluxyss.app.analyticstracking.R;
import com.rifluxyss.app.analyticstracking.common.DateTimeUtils;
import com.rifluxyss.app.analyticstracking.common.Utils;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.viewmodel.UploadLogsViewModel;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.List;

/**
 * The type Logger.
 */
public class Logger extends AppManagerSingleton {

    /**
     * Upload data string.
     *
     * @return the string
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    private String uploadData(List<AnalyticsLog> analyticsLogs) throws IOException, ParseException {
        StringBuilder stringBuilder = new StringBuilder();
        for (AnalyticsLog analytics : analyticsLogs) {
            stringBuilder.append(upload(analytics));
        }
        return stringBuilder.toString();

    }

    /**
     * Upload string.
     *
     * @param analytics the analytics
     * @return the string
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    private String upload(AnalyticsLog analytics) throws IOException, ParseException {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);
        serializer.startDocument(null, null);

        String eventTime = analytics.eventTime != null ? new DateTimeUtils().getDateTime(analytics.eventTime) : Utils.EMPTY;
        String routeNbr = analytics.routNbr != null ? String.valueOf(analytics.routNbr) : Utils.EMPTY;
        String dayOfWeek = analytics.day != null ? String.valueOf(analytics.day) : Utils.EMPTY;

        serializer.startTag(null, getInstance().getContext().getString(R.string.str_logentry));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_eventTime), eventTime);
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_hostID), Utils.emptyIfNull(analytics.hostId));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_userId), Utils.emptyIfNull(analytics.userID));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_locationNbr), Utils.emptyIfNull(analytics.locationNbr));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_routeNbr), routeNbr);
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_day), dayOfWeek);
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_logger), Utils.emptyIfNull(analytics.logger));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_eventNbr), String.valueOf(analytics.eventNbr));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_addtlDesc), String.valueOf(analytics.addtlDesc));
        serializer.attribute(null, getInstance().getContext().getString(R.string.str_addtlNbr), String.valueOf(analytics.addtlNbr));
        serializer.endTag(null, getInstance().getContext().getString(R.string.str_logentry));
        serializer.endDocument();

        String xml = writer.toString();
        return xml.substring(xml.indexOf("?>") + 2);
    }

    /**
     * Upload logs a pi mutable live data.
     *
     * @return the mutable live data
     * @throws IOException    the io exception
     * @throws ParseException the parse exception
     */
    public MutableLiveData<String> uploadLogsAPi(List<AnalyticsLog> analyticsLogs) throws ParseException, IOException {

        UploadLogsViewModel uploadLogsViewModel = new UploadLogsViewModel();
        uploadLogsViewModel.init();

        if (analyticsLogs != null && analyticsLogs.size() > 0) {

            String logsData = uploadData(analyticsLogs);
            return uploadLogsViewModel.uploadLogs(logsData);

        } else {

            return new MutableLiveData<>();
        }

    }

}
