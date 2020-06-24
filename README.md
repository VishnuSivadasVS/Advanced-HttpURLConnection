# Advanced-HttpURLConnection
[![](https://jitpack.io/v/VishnuSivadasVS/Advanced-HttpURLConnection.svg)](https://jitpack.io/#VishnuSivadasVS/Advanced-HttpURLConnection)
[![Vishnu Sivadas](https://www.vishnusivadas.com/github/codequality.svg?style=flat)](https://github.com/VishnuSivadasVS)

Making HttpURLConnection easy and secure. Best method to impliment httpurlconnection in android.

* [Download demo apk and see how it works.](https://github.com/VishnuSivadasVS/Advanced-HttpURLConnection/releases/download/1.1/AdvancedHttpUrlConnection-debug.apk)

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
 	implementation 'com.github.VishnuSivadasVS:Advanced-HttpURLConnection:1.1'
	}
```
## Methods and how to use them
We have Two classes FetchData and PutData. Import the Library to your file first (In android studio paste the code and press alt + enter).
### Read Data From a URL - FetchData.class
```
//Start ProgressBar first (Set visibility VISIBLE)
Handler handler = new Handler();
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
```
//Start ProgressBar first (Set visibility VISIBLE)
Handler handler = new Handler();
handler.post(new Runnable() {
    @Override
    public void run() {
        //Starting Write and Read data with URL
        //Creating array for parameters
        String[] param = new String[2];
        param[0] = "param-1";
        param[1] = "param-2";
        //Creating array for data
        String[] data = new String[2];
        data[0] = "data-1";
        data[1] = "data-2";
        PutData putData = new PutData("https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php", "GET", param, data);
        if (putData.startFetch()) {
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
