# java-holidayppi

An official java client library for https://holidayapi.pl/

**Logging**

 The application uses log4j to log events. 

Provide the logging configuration by having the file log4j.xml in the classpath. 

You can download the pre-configured configuration file from the directory `<project_root>/log4j/log4j2.xml` 

****
**Usage:**
***

**Maven dependency**
```
<dependency>
    <groupId>com.github.holidayapi</groupId>
    <artifactId>java-holidayapi</artifactId>
    <version>1.0</version>
</dependency>
```
**Sample java code**
```java
        //create a consumer
        APIConsumer consumer = new HolidayAPIConsumer("https://holidayapi.pl/v1/holidays");

        //generate the wuery parameters
        QueryParams params = new QueryParams();
        params.key("your_api_key")
                .month(5)
                .day(16)
                .country(QueryParams.Country.POLAND)
                .year(2019)
                //JSON is the default format
                .format(QueryParams.Format.JSON)
                .pretty(true);

        try {
            //make the API call
            HolidayAPIResponse response = consumer.getHolidays(params);
            
            //check the status code of the API call
            int status = response.getStatus();
            if (status != 200) {

                //handle error scenario

            } else {

                //handle success scenario

                List<Holiday> holidays = response.getHolidays();
                for (Holiday h : holidays) {
                    //do your thing
                }
            }
        } catch (IOException e) {
            //handle exception
        }
```