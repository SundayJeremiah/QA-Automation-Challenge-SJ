package com.ExlibrisFETestProject.ExlibrisFETest;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty", "json:C:/WS/ExlibWS/ExlibrisFETest/Cucumber_Default/cucumber.json"},
		features = {"src/test/resource"}, tags = {"@tag"}
		)


public class RunnerTest {

}