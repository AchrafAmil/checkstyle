package com.puppycrawl.tools.checkstyle;

import com.puppycrawl.tools.checkstyle.checks.StaticVariableNameCheck;

public class StaticVariableNameCheckTest
    extends BaseCheckTestCase
{
    public StaticVariableNameCheckTest(String aName)
    {
        super(aName);
    }

    public void testSpecified()
        throws Exception
    {
        final CheckConfiguration checkConfig = new CheckConfiguration();
        checkConfig.setClassname(StaticVariableNameCheck.class.getName());
        checkConfig.addProperty("format", "^s[A-Z][a-zA-Z0-9]*$");
        final Checker c = createChecker(checkConfig);
        final String fname = getPath("InputSimple.java");
        final String[] expected = {
            "30:24: Name 'badStatic' must match pattern '^s[A-Z][a-zA-Z0-9]*$'.",
        };
        verify(c, fname, expected);
    }
}
