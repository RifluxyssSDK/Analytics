package com.rifluxyss.app.analyticstracking.upload;

import android.annotation.SuppressLint;
import android.util.Xml;

import com.rifluxyss.app.analyticstracking.common.Utils;
import com.rifluxyss.app.analyticstracking.enitity.AnalyticsLog;
import com.rifluxyss.app.analyticstracking.log.Analytics;

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
        for (AnalyticsLog log : analyticsLogs) {
            serializer.startTag(null, "LogEntry");
            serializer.attribute(null, "EventTime", log.eventTime.format(legacyEventTimeFormatter));
            //use host id to carry the version
            serializer.attribute(null, "HostId", Utils.emptyIfNull(log.hostId));
            serializer.attribute(null, "UserId", log.userID);
            serializer.attribute(null, "LocationNbr", log.locationNbr);
            serializer.attribute(null, "RouteNbr", String.valueOf(log.routNbr));
            serializer.attribute(null, "Day", String.valueOf(log.day));
            serializer.attribute(null, "Logger", Utils.emptyIfNull(log.logger));
            serializer.attribute(null, "EventNbr", String.valueOf(log.eventNbr));
            serializer.attribute(null, "AddtlDesc", String.valueOf(log.addtlDesc));
            serializer.attribute(null, "AddtlNbr", String.valueOf(log.addtlNbr));
            serializer.endTag(null, "LogEntry");
        }
        serializer.endDocument();
        String xml = writer.toString();
        //get ride of the xml tag
        return xml.substring(xml.indexOf("?>") + 2);
    }

}
