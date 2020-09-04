# Advanced-HttpURLConnection
[![](https://jitpack.io/v/VishnuSivadasVS/Advanced-HttpURLConnection.svg)](https://jitpack.io/#VishnuSivadasVS/Advanced-HttpURLConnection)
[![Vishnu Sivadas](https://www.vishnusivadas.com/github/codequality.svg?style=flat)](https://github.com/VishnuSivadasVS)

Making HttpURLConnection faster, easy and secure. Best method to impliment httpurlconnection in android.

* [Download demo apk and see how it works.](https://github.com/VishnuSivadasVS/Advanced-HttpURLConnection/releases/download/1.2/AdvancedHttpUrlConnection-debug.apk)

## Steps to add the library to your project.

* Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```
* Add the dependency
```
 dependencies {
 	implementation 'com.github.VishnuSivadasVS:Advanced-HttpURLConnection:1.2'
	}
```
## Methods and how to use them
We have Two classes FetchData and PutData. Import the Library to your file first (In android studio paste the code and press alt + enter).
### Read Data From a URL - FetchData.class
You need to use Handler and post a Runnable. Inside the run method add the code for FetchData.

* Creating the object for FetchData, pass the URL as argument.
```
FetchData fetchData = new FetchData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/readTest.php");
```
* Calling startFetch() returns a boolean value.
```
fetchData.startFetch();
```
* To know when the process is completes use onComplete() which returns a boolean value.
```
fetchData.onComplete();
```
* If the process is complete, use the getResult() to get the result value.
```
fetchData.getResult();
```
* Full implimentation with Handler. You can also add a progress bar at the commended regions.
```
//Start ProgressBar first (Set visibility VISIBLE)
Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
    @Override
    public void run() {
        FetchData fetchData = new FetchData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/readTest.php");
        if (fetchData.startFetch()) {
            if (fetchData.onComplete()) {
                String result = fetchData.getResult();
		//End ProgressBar (Set visibility to GONE)
                Log.i("FetchData", result);
            }
        }
    }
});
```

### Write data with POST and GET methods - PutData.class
You need to use Handler and post a Runnable. Inside the run method add the code for PutData.

* First we need to create to arrays, one for field name of the parameter and another for the data. Make sure the order is correct.
```
String[] field = new String[2];
field[0] = "param-1";
field[1] = "param-2";
String[] data = new String[2];
data[0] = "data-1";
data[1] = "data-2";
```
* PHP representation, The post array will look like,
```
$_POST['param-1'] = "data-1";
$_POST['param-2'] = "data-2";
```

* Creating the object for PutData, pass the URL, method, field, data as arguments. The method can be POST and also GET.
```
PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
```
* Calling startFetch() for starting the process, it returns a boolean value.
```
putData.startPut();
```
* To know when the process is completes use onComplete() which returns a boolean value.
```
putData.onComplete();
```
* If the process is complete, use the getResult() to get the result value.
```
putData.getResult();
```
* Full implimentation with Handler. You can also add a progress bar at the commended regions.
```
//Start ProgressBar first (Set visibility VISIBLE)
Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
    @Override
    public void run() {
        //Starting Write and Read data with URL
        //Creating array for parameters
        String[] field = new String[2];
        field[0] = "param-1";
        field[1] = "param-2";
        //Creating array for data
        String[] data = new String[2];
        data[0] = "data-1";
        data[1] = "data-2";
        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "POST", field, data);
        if (putData.startPut()) {
            if (putData.onComplete()) {
                String result = putData.getResult();
                //End ProgressBar (Set visibility to GONE)
                Log.i("PutData", result);
            }
        }
        //End Write and Read data with URL
    }
});
```

This is just like a pre-release version there are lot of other features coming soon.

## Authors

* **Vishnu Sivadas** - *Developer* - [Website](https://www.vishnusivadas.com/)

Check out my other works [@VishnuSivadasVS](https://github.com/VishnuSivadasVS)
