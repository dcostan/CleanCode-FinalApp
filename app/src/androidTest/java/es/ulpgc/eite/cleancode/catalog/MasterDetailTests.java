package es.ulpgc.eite.cleancode.catalog;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class MasterDetailTests {

  @Rule
  public ActivityTestRule<ProductListActivity> testRule =
      new ActivityTestRule<>(ProductListActivity.class);

  @Test
  public void masterDetailTests() {

    ViewInteraction textView1 = onView(withText("Product List"));
    textView1.check(matches(isDisplayed()));

    /*
    ViewInteraction textView2 = onView(allOf(
        ViewMatchers.withId(R.id.content),
        isDisplayed()
    ));
    textView2.check(matches(withText("Product 1")));
    */

    onData(anything())
        .inAdapterView(withId(R.id.product_list))
        .atPosition(0)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Product 1")));


    DataInteraction linearLayout = onData(anything())
        .inAdapterView(allOf(withId(R.id.product_list)))
        .atPosition(3);
    linearLayout.perform(click());


    ViewInteraction textView3 = onView(withText("Product Detail"));
    textView3.check(matches(isDisplayed()));


    ViewInteraction textView4 = onView(allOf(
        withId(R.id.product_type),
        isDisplayed()
    ));
    textView4.check(matches(withText(
        "Details about Product:  4\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here."
    )));

    ViewInteraction appCompatImageButton = onView(allOf(
        withContentDescription("Navigate up"),
        isDisplayed()
    ));
    appCompatImageButton.perform(click());


    ViewInteraction textView5 = onView(withText("Product List"));
    textView5.check(matches(isDisplayed()));

    /*
    ViewInteraction textView6 = onView(allOf(
        withId(R.id.content),
        isDisplayed()
    ));
    textView6.check(matches(withText("Product 1")));
    */

    onData(anything())
        .inAdapterView(withId(R.id.product_list))
        .atPosition(0)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Product 1")));

    DataInteraction linearLayout3 = onData(anything())
        .inAdapterView(allOf(withId(R.id.product_list)))
        .atPosition(5);
    linearLayout3.perform(click());


    ViewInteraction textView7 = onView(withText("Product Detail"));
    textView7.check(matches(isDisplayed()));


    ViewInteraction textView8 = onView(allOf(
        withId(R.id.product_type),
        isDisplayed()
    ));
    textView8.check(matches(withText(
        "Details about Product:  6\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here."
    )));
  }


}
