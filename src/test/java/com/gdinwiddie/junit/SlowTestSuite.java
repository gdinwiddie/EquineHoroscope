package com.gdinwiddie.junit;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.gdinwiddie.creditcardprocessor.merchantbank.LocalhostJsonMerchantBankAdapterTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({SlowTests.class})
@SuiteClasses(LocalhostJsonMerchantBankAdapterTest.class)
public class SlowTestSuite {

}
