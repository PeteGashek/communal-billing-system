communal-billing-system
=======================
Add maven URL into karaf:

        features:addurl mvn:org.room72.cbs/features/0.0.1/xml 


Install example feature in container:


        features:install cbs

Starting
-------------------
in container execute:



        cbs:createbill

//Where arg is number of year (for example 2013). 
Arg is yet empty . Implementation on the way.

!!!!IMPORTANT
deploy to karaf joda-time-2.2.jar
