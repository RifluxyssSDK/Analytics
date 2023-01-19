AnalyticsTracking
===============
Analytics library, it's helps to store your log details from the given data.

### Description

* This is a simple and straight forward library for store and get user analytics through your application usage.

### How to integrate into your app ?

Integrating the project is simple, All you need to do is follow the below steps.

Step 1. Add the JitPack repository to your build file. Add it in your **settings.gradle** at the end
of repositories:

>            allProjects {
>              repositories {
>                maven { url "https://jitpack.io" }
>              }
>            }

Step 2. Add the dependency: ( NOTE: Replace the tag with latest version )

>            dependencies {
>                implementation 'com.github.RifluxyssSDK:Analytics:1.0.9'
>            } 

### Quick Start

In order to start using Analytics Tracker, Just copy below code to your project and just pass the
required values and that's all you done!...

>        AppManagerSingleton.getInstance().initialize(this);
>        analytics = new Analytics();
>        analytics.insert(create("1", "ID=0d5867ee-1a71-4944-9737-fb906d8b7f9d|currentCustomerHelper Initialized0012702140", 1.0f, 11, "Test"));
>        List<AnalyticsLog> analyticsLogs = new Analytics().getAllLog();

### Quick Start Upload API

In order to Start using Analytics Tracker Upload the Data in API

> UploadLogsViewModel mViewModel = new ViewModelProvider(this).get(UploadLogsViewModel.class);
> mViewModel.init();
> AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {
> try {
> new Logger().uploadLogsAPi(mViewModel).observe(this, response -> {
> String responseData = response != null ? response : "failure"; Log.e("status", "get Response===> " + responseData); });
> } catch (Throwable throwable) {
> Log.e("status", "get Response===> " + throwable.getLocalizedMessage());
> throwable.printStackTrace();
> }
> });

### Technologies we used

* Java 8
* Room Database
* Retrofit2
* LocalDateTime
* Exception Handling


### Authors

* [Rifluxyss Team](http://www.rifluxyss.com/)

### Fork & Star if it helped you.

