//[AnalyticsTracking](../../../index.md)/[com.rifluxyss.app.analyticstracking.log](../index.md)/[Analytics](index.md)

# Analytics

[androidJvm]\
open class [Analytics](index.md) : [AppManagerSingleton](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/index.md)

## Constructors

| | |
|---|---|
| [Analytics](-analytics.md) | [androidJvm]<br>open fun [Analytics](-analytics.md)() |

## Functions

| Name | Summary |
|---|---|
| [deleteAllLog](delete-all-log.md) | [androidJvm]<br>open fun [deleteAllLog](delete-all-log.md)() |
| [deleteBeforeDateLog](delete-before-date-log.md) | [androidJvm]<br>open fun [deleteBeforeDateLog](delete-before-date-log.md)(day: [Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;<br>open fun [deleteBeforeDateLog](delete-before-date-log.md)(localDateTime: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [deleteLogs](delete-logs.md) | [androidJvm]<br>open fun [deleteLogs](delete-logs.md)(day: [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;) |
| [getAllLog](get-all-log.md) | [androidJvm]<br>open fun [getAllLog](get-all-log.md)(): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt; |
| [getContext](index.md#683828051%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getContext](index.md#683828051%2FFunctions%2F-1898713888)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [getDateTimeLogs](get-date-time-logs.md) | [androidJvm]<br>open fun [getDateTimeLogs](get-date-time-logs.md)(localDateTime: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html)): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;&gt; |
| [getDateWeekLogs](get-date-week-logs.md) | [androidJvm]<br>open fun [getDateWeekLogs](get-date-week-logs.md)(day: [Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;&gt; |
| [getInstance](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/get-instance.md) | [androidJvm]<br>open fun [getInstance](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/get-instance.md)(): [AppManagerSingleton](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/index.md) |
| [getListAnalyticsHostID](get-list-analytics-host-i-d.md) | [androidJvm]<br>open fun [getListAnalyticsHostID](get-list-analytics-host-i-d.md)(hostID: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt; |
| [getListAnalyticsLocationRoute](get-list-analytics-location-route.md) | [androidJvm]<br>open fun [getListAnalyticsLocationRoute](get-list-analytics-location-route.md)(locationNumber: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), routeNumber: [Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt; |
| [getListAnalyticsUserId](get-list-analytics-user-id.md) | [androidJvm]<br>open fun [getListAnalyticsUserId](get-list-analytics-user-id.md)(usrID: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt; |
| [getSpecificDateTimeLogs](get-specific-date-time-logs.md) | [androidJvm]<br>open fun [getSpecificDateTimeLogs](get-specific-date-time-logs.md)(startDayTime: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html), endDateTime: [LocalDateTime](https://developer.android.com/reference/kotlin/java/time/LocalDateTime.html)): [LiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/LiveData.html)&lt;[List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;&gt; |
| [initialize](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/initialize.md) | [androidJvm]<br>open fun [initialize](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/initialize.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) |
| [insert](insert.md) | [androidJvm]<br>open fun [insert](insert.md)(analyticsLog: [AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md))<br>open fun [insert](insert.md)(analyticsLog: [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[AnalyticsLog](../../com.rifluxyss.app.analyticstracking.enitity/-analytics-log/index.md)&gt;) |
| [localDatabase](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/local-database.md) | [androidJvm]<br>open fun [localDatabase](../../com.rifluxyss.app.analyticstracking/-app-manager-singleton/local-database.md)(): [AnalyticsDatabase](../../com.rifluxyss.app.analyticstracking.database/-analytics-database/index.md) |
