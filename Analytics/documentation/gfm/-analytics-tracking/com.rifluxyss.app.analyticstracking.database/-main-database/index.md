//[AnalyticsTracking](../../../index.md)/[com.rifluxyss.app.analyticstracking.database](../index.md)/[MainDatabase](index.md)

# MainDatabase

[androidJvm]\
abstract class [MainDatabase](index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

## Functions

| Name | Summary |
|---|---|
| [analyticsLogDaoLogDao](analytics-log-dao-log-dao.md) | [androidJvm]<br>abstract fun [analyticsLogDaoLogDao](analytics-log-dao-log-dao.md)(): [AnalyticsLogDao](../../com.rifluxyss.app.analyticstracking.dao/-analytics-log-dao/index.md) |
| [assertNotMainThread](index.md#-917214377%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [assertNotMainThread](index.md#-917214377%2FFunctions%2F-1898713888)() |
| [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [assertNotSuspendingTransaction](index.md#1166251624%2FFunctions%2F-1898713888)() |
| [beginTransaction](index.md#1020009182%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [beginTransaction](index.md#1020009182%2FFunctions%2F-1898713888)() |
| [clearAllTables](index.md#404244410%2FFunctions%2F-1898713888) | [androidJvm]<br>abstract fun [clearAllTables](index.md#404244410%2FFunctions%2F-1898713888)() |
| [close](index.md#1674273423%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [close](index.md#1674273423%2FFunctions%2F-1898713888)() |
| [compileStatement](index.md#1146188466%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [compileStatement](index.md#1146188466%2FFunctions%2F-1898713888)(sql: [String](https://developer.android.com/reference/kotlin/java/lang/String.html)): [SupportSQLiteStatement](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteStatement.html) |
| [endTransaction](index.md#622722960%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [endTransaction](index.md#622722960%2FFunctions%2F-1898713888)() |
| [getAutoMigrations](index.md#-437888903%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getAutoMigrations](index.md#-437888903%2FFunctions%2F-1898713888)(autoMigrationSpecs: [Map](https://developer.android.com/reference/kotlin/java/util/Map.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;, [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;): [List](https://developer.android.com/reference/kotlin/java/util/List.html)&lt;[Migration](https://developer.android.com/reference/kotlin/androidx/room/migration/Migration.html)&gt; |
| [getInvalidationTracker](index.md#-1572952849%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getInvalidationTracker](index.md#-1572952849%2FFunctions%2F-1898713888)(): [InvalidationTracker](https://developer.android.com/reference/kotlin/androidx/room/InvalidationTracker.html) |
| [getOpenHelper](index.md#528322745%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getOpenHelper](index.md#528322745%2FFunctions%2F-1898713888)(): [SupportSQLiteOpenHelper](https://developer.android.com/reference/kotlin/androidx/sqlite/db/SupportSQLiteOpenHelper.html) |
| [getQueryExecutor](index.md#1823899982%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getQueryExecutor](index.md#1823899982%2FFunctions%2F-1898713888)(): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [getRequiredAutoMigrationSpecs](index.md#1623281881%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getRequiredAutoMigrationSpecs](index.md#1623281881%2FFunctions%2F-1898713888)(): [Set](https://developer.android.com/reference/kotlin/java/util/Set.html)&lt;[Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;out [AutoMigrationSpec](https://developer.android.com/reference/kotlin/androidx/room/migration/AutoMigrationSpec.html)&gt;&gt; |
| [getTransactionExecutor](index.md#139460856%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [getTransactionExecutor](index.md#139460856%2FFunctions%2F-1898713888)(): [Executor](https://developer.android.com/reference/kotlin/java/util/concurrent/Executor.html) |
| [getTypeConverter](index.md#361519777%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun &lt;[T](index.md#361519777%2FFunctions%2F-1898713888)&gt; [getTypeConverter](index.md#361519777%2FFunctions%2F-1898713888)(klass: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;[T](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent)&gt;): [T](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html#settagifabsent) |
| [init](index.md#1039887154%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [init](index.md#1039887154%2FFunctions%2F-1898713888)(configuration: [DatabaseConfiguration](https://developer.android.com/reference/kotlin/androidx/room/DatabaseConfiguration.html)) |
| [inTransaction](index.md#-1889647314%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [inTransaction](index.md#-1889647314%2FFunctions%2F-1898713888)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isOpen](index.md#-277138657%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [isOpen](index.md#-277138657%2FFunctions%2F-1898713888)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [query](index.md#129106736%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [query](index.md#129106736%2FFunctions%2F-1898713888)(query: [String](https://developer.android.com/reference/kotlin/java/lang/String.html), args: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;): [Cursor](https://developer.android.com/reference/kotlin/android/database/Cursor.html) |
| [runInTransaction](index.md#1063989044%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [runInTransaction](index.md#1063989044%2FFunctions%2F-1898713888)(body: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html))<br>open fun &lt;[V](index.md#-1038828496%2FFunctions%2F-1898713888)&gt; [runInTransaction](index.md#-1038828496%2FFunctions%2F-1898713888)(body: [Callable](https://developer.android.com/reference/kotlin/java/util/concurrent/Callable.html)&lt;[V](index.md#-1038828496%2FFunctions%2F-1898713888)&gt;): [V](index.md#-1038828496%2FFunctions%2F-1898713888) |
| [setTransactionSuccessful](index.md#954356125%2FFunctions%2F-1898713888) | [androidJvm]<br>open fun [setTransactionSuccessful](index.md#954356125%2FFunctions%2F-1898713888)() |

## Inheritors

| Name |
|---|
| [AnalyticsDatabase](../-analytics-database/index.md) |
