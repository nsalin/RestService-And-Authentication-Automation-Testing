package rest_testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import rest_testing.resources_testing.CommentsCRUD;
import rest_testing.resources_testing.PhotosCRUD;
import rest_testing.resources_testing.UsersCRUD;

/**
 * Created by Win81 on 4/26/2015.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({UsersCRUD.class, PhotosCRUD.class, CommentsCRUD.class})

public class RunRestServiceTests {

}
