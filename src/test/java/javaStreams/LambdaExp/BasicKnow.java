package javaStreams.LambdaExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

public class BasicKnow {
	@Test(groups = { "Business" }, timeOut = 3000)
	public void funs() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Harmeet");
		names.add("Shyam");
		names.add("Hari");
		names.add("Gopal");
		names.add("Harpreet");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("H")) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println("---------");
  }

	@Test(groups = { "Function" })
	public void StreamFun() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Harmeet");
		names.add("Shyam");
		names.add("Hari");
		names.add("Gopal");
		names.add("Harpreet");

		// Above whole code work with a single line of code with using java stream
		// collection.
		long c = names.stream().filter(s -> s.startsWith("H")).count();

		System.out.println("Using Stream collections " + c);
		System.out.println("---------");
	}

	@Test(groups = { "Business" })
	public void StreamFun01() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Harmeet");
		names.add("Shyam");
		names.add("Hari");
		names.add("Gopal");
		names.add("Harpreet");

//		long d = Stream.of("Harmeet", "Shyam", "Hari", "Gopal", "Harpreet").filter(s ->) {
//			s.startsWith("H");
//
//		}).
//		System.out.println(d);
// Printing the greater than 4 letter.
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		System.out.println("---------");
	}

	@Test(groups = { "Business" })
	public void StreamFun02() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Harmeet");
		names.add("Shyam");
		names.add("Hari");
		names.add("Gopal");
		names.add("Harpreet");

		// Ends with some letter, and upper case.
		names.stream().filter(a -> a.endsWith("t")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		System.out.println("---------");
	}

	@Test(groups = { "Function" }, enabled = true)
	public void ArrayList() {

		System.out.println("Enabled used with TestNG attribute");
		// Array List define into the list.
		List<String> names = Arrays.asList("Harmeet", "Shyam", "Hari", "Gopal", "Harpreet");

		// Sorted the array list string with specific letter, upper-case the string
		names.stream().filter(s -> s.startsWith("H")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		System.out.println("---------");
	}

	@Test(groups = { "Business" })
	public void StreamConcat() {
		ArrayList<String> names01 = new ArrayList<String>();

		names01.add("Vikram");
		names01.add("Rishi");
		names01.add("Karandeep");

		// Array List define into the list.
		List<String> names = Arrays.asList("Harmeet", "Shyam", "Hari", "Gopal", "Harpreet");

		Stream<String> newstream = Streams.concat(names01.stream(), names.stream());
//Merging two different list of values.
		newstream.sorted().forEach(s -> System.out.println(s));
		System.out.println("---------");

	}

	@Test(groups = { "Business" })
	public void StreamMatch() {
		ArrayList<String> names01 = new ArrayList<String>();

		names01.add("Vikram");
		names01.add("Rishi");
		names01.add("Karandeep");

		// Array List define into the list.
		List<String> names = Arrays.asList("Harmeet", "Shyam", "Hari", "Gopal", "Harpreet");

		Stream<String> newstream = Streams.concat(names01.stream(), names.stream());

		boolean flag = newstream.anyMatch(s -> s.equalsIgnoreCase("Har777meet"));
		System.out.println(flag);
		AssertJUnit.assertTrue(flag);
		System.out.println("---------");

	}

	@DataProvider
	public Object[] getdata() {
		Object[] nn = new Object[3];

		nn[0] = "Vikram";
		nn[1] = "Rishi";
		nn[2] = "Karandeep";
		return nn;
	}

	@Test(groups = { "Function" }, dependsOnMethods = { "StreamMatch" }, dataProvider = "getdata")
	public void streamCollect(String str) {

		//Collect all the result and use for th further output process.
		List<String> names = Arrays.asList("Harmeet", "Shyam", "Hari", "Gopal", "Harpreet");

		List<String> cl = names.stream().filter(s -> s.startsWith("H")).sorted().map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		System.out.println(cl.get(0));
		System.out.println("DataProvider name " + str);
		System.out.println("-----------");

	}

	@Test(groups = { "Function" })
	public void AssignStream() {
		List<Integer> i = Arrays.asList(1, 2, 2, 5, 6, 9, 8, 6, 3, 6, 2, 7);
		// unique numbers using Steam
		// sort the number
		System.out.println("Unique Number :");
		i.stream().distinct().forEach(s -> System.out.println(s));
		System.out.println("--------");
		List<Integer> isort = i.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(isort.get(2));

	}
}
