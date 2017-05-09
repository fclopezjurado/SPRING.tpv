package controllers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TokenControllerIT.class, ProductControllerIT.class, UserControllerIT.class, ArticleControllerIT.class})
public class AllControllersIntegrationTests {

}
