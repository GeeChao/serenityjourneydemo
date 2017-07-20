# Serenity screenplay/journey design pattern

A short demo on the screenplay design pattern and its approach on writing high quality automated acceptance tests based
on SOLID development principles - in particular the single responsibility principle and open closed principle to ensure 
that when things break - we know exactly where and why due to the classes only serving a single purpose whilst being 
extensible. 

Our demo will be based off the TodoMVC angularJS application and integrated with CucumberJS to show how the additional 
layers of abstraction utilized by the screenplay pattern which allows us to create more maintainable and robust test
suites. 

## Run test suite
* Default driver is ChromeDriver, you will need to append this driver to your system env if it isn't already set. 
* mvn clean verify

This will run the entire test suite using the mvn failsafe plugin which currently includes 2 feature files and then 
aggregate the report afterwards which will be found at target/site/index.html

## Configuration
There is a serenity.properties configuration file located in the root directory of the project which contains all the 
settings you can customize. You can also pass config parameters in as as system properties. 
See here for the full list:
* http://thucydides.info/docs/serenity-staging/#_serenity_system_properties_and_configuration

## Appendix
* This project was based off the serenity demo github project - https://github.com/serenity-bdd/screenplay-pattern-todomvc
* This is another good project that was based off an actual website - https://github.com/navvro/serenity-demo

