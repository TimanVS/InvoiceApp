package ua.timan.invoice.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.timan.web_static.ui.SampleWebStaticApplication;

@ContextConfiguration(classes = SampleWebStaticApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractSpringTest {
	
}
