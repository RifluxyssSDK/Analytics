package com.rifluxyss.app.analyticstracking.upload;

import android.annotation.SuppressLint;
import android.util.Xml;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.rifluxyss.app.analyticstracking.common.Utils;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.log.Analytics;
import com.rifluxyss.app.analyticstracking.viewmodel.UploadLogsViewModel;

import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.io.StringWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Logger {

    @SuppressLint("NewApi")
    private static final DateTimeFormatter legacyEventTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");

    @SuppressLint("NewApi")
    public String upload() throws IOException {

        XmlSerializer serializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        serializer.setOutput(writer);
        serializer.startDocument(null, null);
        List<AnalyticsLog> analyticsLogs = new Analytics().getAllLog();
        /*for (AnalyticsLog log : analyticsLogs) {

        }*/

        serializer.startTag(null, "LogEntry");
        serializer.attribute(null, "EventTime", analyticsLogs.get(0).eventTime.format(legacyEventTimeFormatter));
        //use host id to carry the version
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
        //get ride of the xml tag
        return xml.substring(xml.indexOf("?>") + 2);
    }

    public MutableLiveData<String> uploadLogsAPi(UploadLogsViewModel mViewModel) throws IOException {
        return mViewModel.uploadLogs(upload());
    }

}
