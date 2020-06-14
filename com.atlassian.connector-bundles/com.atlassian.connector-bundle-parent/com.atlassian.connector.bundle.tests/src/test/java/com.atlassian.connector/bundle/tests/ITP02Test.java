/*******************************************************************************
 * Copyright (c) 2008, 2011 Sonatype Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sonatype Inc. - initial API and implementation
 *******************************************************************************/
package com.atlassian.connector.bundle.tests;

import org.junit.Assert;
import org.junit.Test;

import com.atlassian.connector.bundle.ITP02;

public class ITP02Test {

    @Test
    public void basic() {
        ITP02 testee = new ITP02();
        Assert.assertEquals("maven-bundle-plugin", testee.getMessage());
    }

}
