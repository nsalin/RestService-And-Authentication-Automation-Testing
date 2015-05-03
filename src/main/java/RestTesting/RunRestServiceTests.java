package RestTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import RestTesting.ResourcesTesting.CommentsCRUD;
import RestTesting.ResourcesTesting.PhotosCRUD;
import RestTesting.ResourcesTesting.UsersCRUD;

/**
 * Created by Alin on 4/26/2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({UsersCRUD.class, PhotosCRUD.class, CommentsCRUD.class})

public class RunRestServiceTests {

}
