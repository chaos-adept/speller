package tests.externallib;

import java.io.Serializable;

public class MockItem implements Serializable
{
	public static MockItem create()
	{
		return new MockItem();
	}
}