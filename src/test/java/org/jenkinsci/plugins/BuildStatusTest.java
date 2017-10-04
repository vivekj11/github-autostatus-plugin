/*
 * The MIT License
 *
 * Copyright 2017 jxpearce.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins;

import org.jenkinsci.plugins.githubautostatus.BuildStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.kohsuke.github.GHCommitState;
import org.kohsuke.github.GHRepository;
import static org.mockito.Mockito.*;

/**
 *
 * @author jxpearce
 */
public class BuildStatusTest {
    
    public BuildStatusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContext method, of class BuildStatus.
     */
    @Test
    public void testGetContext() {
        System.out.println("getContext");
        String expResult = "test context";
        BuildStatus instance = new BuildStatus(null, "", "", expResult);
        String result = instance.getContext();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCommitState method, of class BuildStatus.
     */
    @Test
    public void testGetCommitState() {
        System.out.println("getCommitState");
        BuildStatus instance = new BuildStatus(null, "", "", "");

        GHCommitState result = instance.getCommitState();
        assertEquals(GHCommitState.PENDING, result);
    }

    /**
     * Test of setCommitState method, of class BuildStatus.
     */
    @Test
    public void testSetCommitState() throws Exception {
        System.out.println("setCommitState");
        
        GHRepository repository = mock(GHRepository.class);
        BuildStatus instance = new BuildStatus(repository, "", "", "");

        instance.setCommitState(GHCommitState.SUCCESS);

        GHCommitState result = instance.getCommitState();
        assertEquals(GHCommitState.SUCCESS, result);
        //String sha1, GHCommitState state, String targetUrl, String description, String context
        verify(repository).createCommitStatus("", GHCommitState.SUCCESS, "", "Building stage", "");
    }
    
}
