#Daily-Trade-Reporting-Engine

Test of Code to JPMorgan

## Getting Started

Clone the repository and import it to a Spring Tool Suite IDE and press "Run as Java Application"

### Prerequisites
I've used Spring to generate the sample data.
So if you want to load sample data, you need to create them as beans in the file /src/main/java/com/jpmorgan/beans/beans.xml
The name of this beans must be trade1, trade2, trade3, ..... tradeN
```
<bean id="trade1" class="com.jpmorgan.beans.Trade">
		<property name="cur" ref="currencyUSD"></property>
		<property name="ent" ref="entityFoo"></property>
		<property name="tt" ref="buyTradeType"></property>
		<property name="instructionDate" value="01 Jan 2016 "></property>
		<property name="settlementDate" value="02 Jan 2016 "></property>
		<property name="units" value="300"></property>
		<property name="pricePerUnit" value="100.25"></property>		
</bean>
```

##Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://projects.spring.io/spring-framework/) - Java Framework
* [JUnit](http://junit.org/junit4/) - Unit test

