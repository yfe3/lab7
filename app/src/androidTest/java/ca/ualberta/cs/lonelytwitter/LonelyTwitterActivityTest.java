package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Runs before starting tests
     * @throws Exception
     */
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());

    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.enterText((EditText) solo.getView(R.id.body), "");
        assertTrue(solo.waitForText("Test Tweet!"));
        solo.clickOnButton("Clear");
    }
    public void testClickTweetList(){
        solo.assertCurrentActivity("wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("");
    }

    /**
     * Runs after tests
     * @throws Exception
     */
    @Override
    public void tearDown() throws Exception{

    }
}