import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class GreenBarTest {

    @Test
    public void junitWorks() {
        assertTrue(true);
    }

    @Test
    public void hamcrestWorks() {
       assertThat(true, is(equalTo(true)));
    }

    @Test
    public void mockitoWorks() {
        Mockito.doNothing();
    }
}
