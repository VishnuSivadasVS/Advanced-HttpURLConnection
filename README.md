# Advanced-HttpURLConnection
[![](https://jitpack.io/v/VishnuSivadasVS/Advanced-HttpURLConnection.svg)](https://jitpack.io/#VishnuSivadasVS/Advanced-HttpURLConnection)
[![Vishnu Sivadas](https://www.vishnusivadas.com/github/codequality.svg?style=flat)](https://github.com/VishnuSivadasVS)

Making HttpURLConnection easy and secure. Best method to impliment httpurlconnection in android.

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
 	implementation 'com.github.VishnuSivadasVS:Advanced-HttpURLConnection:1.0'
	}
```
## Methods and how to use them
We have Two classes FetchData and PutData. Import the Library to your file first (In android studio paste the code and press alt + enter).
### Read Data From a URL - FetchData.class
1. Create an object for FetchData class, pass the URL as argument. Don't forget to import the class.
```
String URL = "https://projects.vishnusivadas.com/AdvancedHttpURLConnection/readTest.php";
FetchData fetchData = new FetchData(URL);
```
2. Start the fetching data.
```
fetchData.start();
```
3. Get the result as string.
```
String data = fetchData.getResult();
```

### Write data with POST and GET methods - PutData.class
1. Creating array for parameters
   ```
   String[] param = new String[2];
   param[0] = "param-1";
   param[1] = "param-2";
   ```
   _Use any parameter name that you like._
   
2. Creating array for data
   ```
   String[] data = new String[2];
   data[0] = "data-1";
   data[1] = "data-2";
   ```
   _Add as many as data and parameters as you like. Make sure number of parameters is equal to number of data. Also add them in exact order._
	
3. Create an object for PutData class, pass the URL as argument. Don't forget to import the class.
```
String URL = "https://projects.vishnusivadas.com/AdvancedHttpURLConnection/putDataTest.php";
PutData putData = new PutData(URL, "POST", param, data);
```

4. Start the putData process.
```
putData.start();
```

5. Get the result as string.
```
String data = putData.getResult();
```

This is just like a pre-release version there are lot of other features coming soon.

## Authors

* **Vishnu Sivadas** - *Developer* - [Website](https://www.vishnusivadas.com/)

Check out my other works [@VishnuSivadasVS](https://github.com/VishnuSivadasVS)
