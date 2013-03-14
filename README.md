communal-billing-system
=======================
Add maven URL into karaf:

        features:addurl mvn:org.room72.cbs/features/0.0.1/xml 


Install example feature in container:


        features:install cbs

Starting
-------------------
in container execute:



        cbs:hello
