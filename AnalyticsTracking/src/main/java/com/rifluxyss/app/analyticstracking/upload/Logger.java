package com.rifluxyss.app.analyticstracking.upload;

import android.util.Xml;

import androidx.lifecycle.MutableLiveData;

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

public class Logger {

    public String uploadData() throws IOException,ParseException {

        StringBuilder stringBuilder = new StringBuilder();
        List<AnalyticsLog> analyticsLogs = new Analytics().getAllLog();
        for (AnalyticsLog analytics : analyticsLogs) {
            stringBuilder.append(upload(analytics));
        }
        return stringBuilder.toString();
    }

    public String upload(AnalyticsLog analytics) throws IOException, ParseException {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);
        serializer.startDocument(null, null);

        List<AnalyticsLog> analyticsLogs = new Analytics().getAllLog();
        serializer.startTag(null, "LogEntry");
        serializer.attribute(null, "EventTime", new DateTimeUtils().getDateTime(analytics.eventTime));
        serializer.attribute(null, "HostId", Utils.emptyIfNull(analytics.hostId));
        serializer.attribute(null, "UserId", analytics.userID);
        serializer.attribute(null, "LocationNbr", analytics.locationNbr);
        serializer.attribute(null, "RouteNbr", String.valueOf(analytics.routNbr));
        serializer.attribute(null, "Day", String.valueOf(analytics.day));
        serializer.attribute(null, "Logger", Utils.emptyIfNull(analytics.logger));
        serializer.attribute(null, "EventNbr", String.valueOf(analytics.eventNbr));
        serializer.attribute(null, "AddtlDesc", String.valueOf(analytics.addtlDesc));
        serializer.attribute(null, "AddtlNbr", String.valueOf(analytics.addtlNbr));
        serializer.endTag(null, "LogEntry");
        serializer.endDocument();
       
        String xml = writer.toString();
        return xml.substring(xml.indexOf("?>") + 2);
    }

    public MutableLiveData<String> uploadLogsAPi(UploadLogsViewModel mViewModel) throws IOException, ParseException {
        return mViewModel.uploadLogs(uploadData());
    }

}
