package com.gdinwiddie.junit;

import org.junit.Ignore;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@Ignore
@RunWith(Categories.class)
@Categories.ExcludeCategory({SlowTests.class})
@SuiteClasses(DefaultTestSuite.class /* what can I put here to include all tests implicitly? */)
public class DefaultTestSuite {

}
