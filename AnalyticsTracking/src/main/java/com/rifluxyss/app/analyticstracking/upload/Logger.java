package com.rifluxyss.app.analyticstracking.upload;

import android.util.Log;
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

    public String upload() throws IOException, ParseException {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);
        serializer.startDocument(null, null);

        List<AnalyticsLog> analyticsLogs = new Analytics().getAllLog();
        serializer.startTag(null, "LogEntry");
        serializer.attribute(null, "EventTime", new DateTimeUtils().getDateTime(analyticsLogs.get(0).eventTime));
        serializer.attribute(null, "HostId", Utils.emptyIfNull(analyticsLogs.get(0).hostId));
        serializer.attribute(null, "UserId", analyticsLogs.get(0).userID);
        serializer.attribute(null, "LocationNbr", analyticsLogs.get(0).locationNbr);
        serializer.attribute(null, "RouteNbr", String.valueOf(analyticsLogs.get(0).routNbr));
        serializer.attribute(null, "Day", String.valueOf(analyticsLogs.get(0).day));
        serializer.attribute(null, "Logger", Utils.emptyIfNull(analyticsLogs.get(0).logger));
        serializer.attribute(null, "EventNbr", String.valueOf(analyticsLogs.get(0).eventNbr));
        serializer.attribute(null, "AddtlDesc", String.valueOf(analyticsLogs.get(0).addtlDesc));
        serializer.attribute(null, "AddtlNbr", String.valueOf(analyticsLogs.get(0).addtlNbr));
        serializer.endTag(null, "LogEntry");
        serializer.endDocument();
        String xml = writer.toString();
        return xml.substring(xml.indexOf("?>") + 2);
    }

    public MutableLiveData<String> uploadLogsAPi(UploadLogsViewModel mViewModel) throws IOException, ParseException {
        return mViewModel.uploadLogs(upload());
    }

}
